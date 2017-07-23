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
    private Boolean excuted;
    private Date excuteTime;

    public Boolean getExcuted() {
        return excuted;
    }

    public void setExcuted(Boolean excuted) {
        this.excuted = excuted;
    }

    public Date getExcuteTime() {
        return excuteTime;
    }

    public void setExcuteTime(Date excuteTime) {
        this.excuteTime = excuteTime;
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
