package edu.bupt.cbh.testing.service.impl;

import edu.bupt.cbh.test.entity.Test;
import edu.bupt.cbh.testing.dao.ExpectedTestingOutputDao;
import edu.bupt.cbh.testing.dao.TestingInputDao;
import edu.bupt.cbh.testing.dao.TestingOutputDao;
import edu.bupt.cbh.testing.dao.TestingDao;
import edu.bupt.cbh.testing.entity.ExpectedTestingOutput;
import edu.bupt.cbh.testing.entity.Testing;
import edu.bupt.cbh.testing.entity.TestingInput;
import edu.bupt.cbh.testing.entity.TestingOutput;
import edu.bupt.cbh.testing.service.TestingService;
import edu.bupt.cbh.testing.vo.AddTestingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * Created by scarlett on 2017/5/25.
 */
@Service
public class TestingServiceImpl implements TestingService{

    @Autowired
    private TestingDao testingDao;

    @Autowired
    private TestingInputDao testingInputDao;

    @Autowired
    private TestingOutputDao testingOutputDao;

    @Autowired
    private ExpectedTestingOutputDao expectedTestingOutputDao;

    @Override
    public Integer addTesting(AddTestingVO addTestingVO) {
        //保存Testing,返回testingId
        Testing testing = new Testing();
        testing.setTestId(addTestingVO.getTestId());
        testing.setTestingName(addTestingVO.getTestingName());
        testing.setUrl(addTestingVO.getUrl());
        Integer testingId = testingDao.addTesting(testing);
        if (testingId == null){
            System.out.println("插入Testing失败：【testId："+testing.getTestId()+",testingName："+testing.getTestingName()+"】");
        }

        //保存TestingInput
        //保存前先设置testingId
        List<TestingInput> testingInputList = addTestingVO.getTestingInputList();
        for (TestingInput testingInput : testingInputList){
            testingInput.setTestingId(testingId);
            Integer inputId = testingInputDao.insertTestingInput(testingInput);
            if (inputId == null){
                System.out.println("插入TestingInput失败：【testingId:"+testingId+",key："+testingInput.getInputKey()+",value:"+testingInput.getInputValue()+"】");
            }
        }

        //保存ExpectedTestingOutput
        List<ExpectedTestingOutput> expectedTestingOutputList = addTestingVO.getExpectedTestingOutputList();
        for (ExpectedTestingOutput expectedTestingOutput : expectedTestingOutputList){
            expectedTestingOutput.setTestingId(testingId);
            Integer expectedOutputId = expectedTestingOutputDao.insertExpectedOutput(expectedTestingOutput);
            if (expectedOutputId == null){
                System.out.println("插入ExpectedTestingOutput失败：【testingId:"+testingId+",key："+expectedTestingOutput.getOutputKey()+",value:"+expectedTestingOutput.getOutputValue()+"】");
            }
        }

        return testingId;
    }

    @Override
    public void updateTesting(Testing testing) {
        testingDao.updateTesting(testing);
    }

    @Override
    public List<Testing> getAllTestings(Integer testId) {
        return testingDao.getAllTestings(testId);
    }

    @Override
    public Map<String, Object> getInputMap(Integer testingId) {
        List<TestingInput> inputList = testingInputDao.getInputList(testingId);
        Map<String  , Object> inputMap = new HashMap<>();
        for (TestingInput input : inputList){
            if (inputMap.containsKey(input.getInputKey())){
                System.out.println("getInputMap + key重复");
            } else {
                inputMap.put(input.getInputKey() , input.getInputValue());
            }
        }
        return inputMap;
    }

    @Override
    public Map<String, Object> getOutputMap(Integer testingId) {
        List<TestingOutput> outputList = testingOutputDao.getTestingOutputList(testingId);
        Map<String  , Object> outputMap = new HashMap<>();
        for (TestingOutput testingOutput : outputList){
            if (outputMap.containsKey(testingOutput.getOutputKey())){
                System.out.println("getOutputMap key重复");
            } else {
                outputMap.put(testingOutput.getOutputKey() , testingOutput.getOutputValue());
            }
        }
        return outputMap;
    }

    @Override
    public Map<String, Object> getExpectedOutputMap(Integer testingId) {
        List<ExpectedTestingOutput> expectedTestingOutputList = expectedTestingOutputDao.getExpectedTestingOutputList(testingId);
        Map<String  , Object> expectedOutputMap = new HashMap<>();
        for (ExpectedTestingOutput expectedTestingOutput : expectedTestingOutputList){
            if (expectedOutputMap.containsKey(expectedTestingOutput.getOutputKey())){
                System.out.println("getExpectedOutputMap key重复");
            } else {
                expectedOutputMap.put(expectedTestingOutput.getOutputKey() , expectedTestingOutput.getOutputValue());
            }
        }
        return expectedOutputMap;
    }

    @Override
    public void insertOutPutMap(Map<String, Object> outputMap , Integer testingId) {
        for (Map.Entry<String , Object> entry : outputMap.entrySet()){
            TestingOutput output = new TestingOutput();
            output.setOutputKey(entry.getKey());
            output.setOutputValue((String) entry.getValue());
            output.setTestingId(testingId);
            Integer outputId = testingOutputDao.insertOutput(output);
            if (outputId == null){
                System.out.println("output回写失败 + output ：[" + entry.getKey()+ " : " + entry.getValue()+"]");
            }
        }
    }

    @Override
    public void testingRun(Integer testId, String baseUrl) {
        List<Testing> testingList = this.getAllTestings(testId);
        //依次执行
        for (Testing testing : testingList) {
            String targetUrl = testing.getUrl();
            //获得测试单元的输入
            Map<String, Object> params = this.getInputMap(testing.getTestingId());
            //执行测试单元
            Map<String, Object> outputMap = this.testingRun(baseUrl, targetUrl, params);
            //执行结果写回
            this.insertOutPutMap(outputMap, testing.getTestingId());
            //执行结果与预期结果对比，更新测试单元结果
            Map<String, Object> expectedoutputMap = this.getExpectedOutputMap(testing.getTestingId());
            testing.setResult(updateExpectedOutputWithOutput(expectedoutputMap,outputMap));
            this.updateTesting(testing);
        }
    }

    private Map<String, Object> testingRun(String baseUrl, String targetUrl, Map<String, Object> params) {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + targetUrl;
        return restTemplate.postForObject(url, params, Map.class);
    }

    private Boolean updateExpectedOutputWithOutput(Map<String, Object> expectedoutputMap,Map<String, Object> outputMap){
        return expectedoutputMap.equals(outputMap);
    }
}
