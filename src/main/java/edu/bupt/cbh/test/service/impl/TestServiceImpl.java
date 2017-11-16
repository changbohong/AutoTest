package edu.bupt.cbh.test.service.impl;

import edu.bupt.cbh.test.dao.TestDao;
import edu.bupt.cbh.test.entity.Test;
import edu.bupt.cbh.test.entity.TestResult;
import edu.bupt.cbh.test.service.TestService;
import edu.bupt.cbh.test.vo.CreateTestVO;
import edu.bupt.cbh.testing.entity.Testing;
import edu.bupt.cbh.testing.service.TestingService;
import edu.bupt.cbh.user.dao.UserDao;
import edu.bupt.cbh.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by scarlett on 2017/5/22.
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private TestingService testingService;

    @Override
    public Integer createTest(CreateTestVO createTestVO) {
        Test test = new Test();
        User user = userDao.getUserByUsername(createTestVO.getUsername());
        test.setUrl(createTestVO.getUrl());
        test.setUser(user);
        test.setUserId(user.getId());
        test.setTestType(createTestVO.getTestType());
        test.setName(createTestVO.getName());
        test.setCreateTime(new Date());
        test.setExcuteTime(createTestVO.getExcuteTime());
        test.setIsExcuteNow(createTestVO.getIsExcuteNow());
        testDao.insertTest(test);
        return test.getId();
    }

    @Override
    public Integer updateTest(Test test) {
        return testDao.updateTest(test);
    }

    @Override
    public List<Test> searchTestByName(String name) {
        return testDao.searchTestByName(name);
    }

    @Override
    public List<Test> searchTestLikeName(String name) {
        if (name == null) {
            name = "";
        }
        return testDao.searchTestLikeName(name);
    }

    @Override
    public void DeleteTestBy(Integer id) {

    }

    @Override
    public void testRun(Integer testId) throws IOException {
        Test test = this.getTestById(testId);
        String baseUrl = test.getUrl();

        System.out.println("开始执行测试，测试名称：" + test.getName());
        //判断测试类型
        if (test.getTestType() == 0){
            testingService.testingRun(testId, baseUrl);
        } else if (test.getTestType() == 1){
            testingService.testingLinkRun(testId, baseUrl);
        }

        System.out.println("执行测试完毕，测试名称：" + test.getName());
        //如果是，则需要手动点击立即执行
        if (test.getIsExcuteNow()) {
            test.setExcuteTime(new Date());
        }
        test.setExcuted(true);
        this.updateTest(test);
    }

    @Override
    public Test getTestById(Integer id) {
        return testDao.getTestById(id);
    }


    @Override
    public TestResult createTestReport(Integer testId) {
        TestResult testResult = new TestResult();
        //获得Test信息
        Test test = this.getTestById(testId);
        testResult.setTest(test);
        //获得测试单元信息
        List<Testing> testingList = testingService.getAllTestings(testId);
        testResult.setTestingList(testingList);
        //获取测试单元输入/输出/预期输出
        for (Testing testing : testingList) {
            Integer testingId = testing.getTestingId();
            testing.setTestingInput(testingService.getInputMap(testingId));
            Map<String, Object> outputMap = testingService.getOutputMap(testingId);
            Map<String, Object> expectedOutputMap = testingService.getExpectedOutputMap(testingId);
            testing.setTestingOutput(outputMap);
            testing.setExpectedTestingOutput(expectedOutputMap);
        }
        return testResult;
    }
}
