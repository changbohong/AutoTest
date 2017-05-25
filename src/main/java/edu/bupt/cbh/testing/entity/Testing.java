package edu.bupt.cbh.testing.entity;

import java.net.URL;
import java.util.List;

/**
 * Created by scarlett on 2017/5/25.
 */
public class Testing {
    private Integer testingId;
    private URL url;
    private String testingName;
    private List<String> inputList;
    private List<String> expectOutputList;
    private List<String> outputList;

    public Integer getTestingId() {
        return testingId;
    }

    public void setTestingId(Integer testingId) {
        this.testingId = testingId;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public String getTestingName() {
        return testingName;
    }

    public void setTestingName(String testingName) {
        this.testingName = testingName;
    }

    public List<String> getInputList() {
        return inputList;
    }

    public void setInputList(List<String> inputList) {
        this.inputList = inputList;
    }

    public List<String> getExpectOutputList() {
        return expectOutputList;
    }

    public void setExpectOutputList(List<String> expectOutputList) {
        this.expectOutputList = expectOutputList;
    }

    public List<String> getOutputList() {
        return outputList;
    }

    public void setOutputList(List<String> outputList) {
        this.outputList = outputList;
    }
}
