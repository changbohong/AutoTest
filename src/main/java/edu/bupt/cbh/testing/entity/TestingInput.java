package edu.bupt.cbh.testing.entity;

/**
 * Created by changbohong on 2017/7/23.
 */

public class TestingInput {
    private Integer inputId;
    private Integer testingId;
    private String key;
    private String value;

    public Integer getOutputId() {
        return inputId;
    }

    public void setOutputId(Integer outputId) {
        this.inputId = outputId;
    }

    public Integer getTestingId() {
        return testingId;
    }

    public void setTestingId(Integer testingId) {
        this.testingId = testingId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
