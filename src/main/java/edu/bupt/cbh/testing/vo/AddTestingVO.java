package edu.bupt.cbh.testing.vo;

/**
 * Created by scarlett on 2017/7/30.
 */

import edu.bupt.cbh.testing.entity.ExpectedTestingOutput;
import edu.bupt.cbh.testing.entity.Testing;
import edu.bupt.cbh.testing.entity.TestingInput;

import java.util.Date;
import java.util.List;

/**
 * 添加测试单元的输入
 */
public class AddTestingVO {
    //testing
    private Integer testId;
    private String url;
    private String testingName;

    //testingInput
    private List<TestingInput> testingInputList;

    //expectedTestingOutput
    private List<ExpectedTestingOutput> expectedTestingOutputList;

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTestingName() {
        return testingName;
    }

    public void setTestingName(String testingName) {
        this.testingName = testingName;
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

    public void setExpectedTestingOutputList(List<ExpectedTestingOutput> expectedTestingOutputs) {
        this.expectedTestingOutputList = expectedTestingOutputs;
    }
}
