package edu.bupt.cbh.testing.entity;

import java.net.URL;
import java.util.Date;
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

    private Map<String, Object> TestingInput;
    private Map<String, Object> TestingOutput;
    private Map<String, Object> ExpectedTestingOutput;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public Map<String, Object> getTestingInput() {
        return TestingInput;
    }

    public void setTestingInput(Map<String, Object> testingInput) {
        TestingInput = testingInput;
    }

    public Map<String, Object> getTestingOutput() {
        return TestingOutput;
    }

    public void setTestingOutput(Map<String, Object> testingOutput) {
        TestingOutput = testingOutput;
    }

    public Map<String, Object> getExpectedTestingOutput() {
        return ExpectedTestingOutput;
    }

    public void setExpectedTestingOutput(Map<String, Object> expectedTestingOutput) {
        ExpectedTestingOutput = expectedTestingOutput;
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
