package edu.bupt.cbh.testing.entity;

/**
 * Created by changbohong on 2017/7/23.
 */

public class ExpectedTestingOutput {
    private Integer expectedOutputId;
    private Integer testingId;
    private String outputKey;
    private String outputValue;


    public Integer getTestingId() {
        return testingId;
    }

    public void setTestingId(Integer testingId) {
        this.testingId = testingId;
    }

    public Integer getExpectedOutputId() {
        return expectedOutputId;
    }

    public void setExpectedOutputId(Integer expectedOutputId) {
        this.expectedOutputId = expectedOutputId;
    }

    public String getOutputKey() {
        return outputKey;
    }

    public void setOutputKey(String outputKey) {
        this.outputKey = outputKey;
    }

    public String getOutputValue() {
        return outputValue;
    }

    public void setOutputValue(String outputValue) {
        this.outputValue = outputValue;
    }
}
