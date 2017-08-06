package edu.bupt.cbh.testing.entity;

import java.util.List;
import java.util.Map;

/**
 * Created by scarlett on 2017/5/25.
 */
public class Testing {
    private Integer testingId;
    private Integer testId;
    private String url;
    private String testingName;
    private Boolean result;

    private Map<String, Object> testingInput;
    private Map<String, Object> testingOutput;
    private Map<String, Object> expectedTestingOutput;

    private List<TestingOutputResult> testingOutputResultList;

    public List<TestingOutputResult> getTestingOutputResultList() {
        return testingOutputResultList;
    }

    public void setTestingOutputResultList(List<TestingOutputResult> testingOutputResultList) {
        this.testingOutputResultList = testingOutputResultList;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public Map<String, Object> getTestingInput() {
        return testingInput;
    }

    public void setTestingInput(Map<String, Object> testingInput) {
        this.testingInput = testingInput;
    }

    public Map<String, Object> getTestingOutput() {
        return testingOutput;
    }

    public void setTestingOutput(Map<String, Object> testingOutput) {
        this.testingOutput = testingOutput;
    }

    public Map<String, Object> getExpectedTestingOutput() {
        return expectedTestingOutput;
    }

    public void setExpectedTestingOutput(Map<String, Object> expectedTestingOutput) {
        this.expectedTestingOutput = expectedTestingOutput;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public Integer getTestingId() {
        return testingId;
    }

    public void setTestingId(Integer testingId) {
        this.testingId = testingId;
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

}
