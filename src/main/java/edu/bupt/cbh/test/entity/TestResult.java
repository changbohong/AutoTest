package edu.bupt.cbh.test.entity;

import edu.bupt.cbh.common.Constants;
import edu.bupt.cbh.testing.entity.ExpectedTestingOutput;
import edu.bupt.cbh.testing.entity.Testing;
import edu.bupt.cbh.testing.entity.TestingInput;
import edu.bupt.cbh.testing.entity.TestingOutput;
import edu.bupt.cbh.user.entity.User;

import java.util.Date;
import java.util.List;

/**
 * Created by scarlett on 2017/5/22.
 * 测试结果
 */
public class TestResult {
    //测试
    private Test test;
    //多个测试单元
    private List<Testing> testingList;
    //每个测试单元的输入
    private List<TestingInput> testingInputList;
    //每个测试单元的预期输出
    private List<ExpectedTestingOutput> expectedTestingOutputList;
    //每个测试单元的实际输出
    private List<TestingOutput> testingOutputList;

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public List<Testing> getTestingList() {
        return testingList;
    }

    public void setTestingList(List<Testing> testingList) {
        this.testingList = testingList;
    }

    public List<TestingInput> getTestingInputList() {
        return testingInputList;
    }

    public void setTestingInputList(List<TestingInput> testingInputList) {
        this.testingInputList = testingInputList;
    }

    public List<ExpectedTestingOutput> getExpectedTestingOutputList() {
        return expectedTestingOutputList;
    }

    public void setExpectedTestingOutputList(List<ExpectedTestingOutput> expectedTestingOutputList) {
        this.expectedTestingOutputList = expectedTestingOutputList;
    }

    public List<TestingOutput> getTestingOutputList() {
        return testingOutputList;
    }

    public void setTestingOutputList(List<TestingOutput> testingOutputList) {
        this.testingOutputList = testingOutputList;
    }
}
