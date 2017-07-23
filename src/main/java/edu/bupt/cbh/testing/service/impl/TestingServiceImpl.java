package edu.bupt.cbh.testing.service.impl;

import edu.bupt.cbh.testing.dao.TestingInputDao;
import edu.bupt.cbh.testing.dao.TestingOutputDao;
import edu.bupt.cbh.testing.dao.TestingDao;
import edu.bupt.cbh.testing.entity.Testing;
import edu.bupt.cbh.testing.entity.TestingInput;
import edu.bupt.cbh.testing.entity.TestingOutput;
import edu.bupt.cbh.testing.service.TestingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by scarlett on 2017/5/25.
 */
@Service
public class TestingServiceImpl implements TestingService{

    @Autowired
    private TestingDao testingDao;

    @Autowired
    private TestingInputDao inputDao;

    @Autowired
    private TestingOutputDao outputDao;

    @Override
    public Integer addTesting(Testing testing) {
        return testingDao.addTesting(testing);
    }

    @Override
    public List<Testing> getAllTestings(Integer testId) {
        return testingDao.getAllTestings(testId);
    }

    @Override
    public Map<String, Object> getInputMap(Integer testingId) {
        List<TestingInput> inputList = inputDao.getInputList(testingId);
        Map<String  , Object> inputMap = new HashMap<>();
        for (TestingInput input : inputList){
            if (inputMap.containsKey(input.getKey())){
                System.out.println("getInputMap + key重复");
            } else {
                inputMap.put(input.getKey() , input.getValue());
            }
        }
        return inputMap;
    }

    @Override
    public void insertOutPutMap(Map<String, Object> outputMap , Integer testingId) {
        for (Map.Entry<String , Object> entry : outputMap.entrySet()){
            TestingOutput output = new TestingOutput();
            output.setKey(entry.getKey());
            output.setValue((String) entry.getValue());
            output.setTestingId(testingId);
            Integer outputId = outputDao.insertOutput(output);
            if (outputId == null){
                System.out.println("output回写失败 + output ：[" + entry.getKey()+ " : " + entry.getValue()+"]");
            }
        }
    }
}
