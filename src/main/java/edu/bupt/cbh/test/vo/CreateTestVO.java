package edu.bupt.cbh.test.vo;

import edu.bupt.cbh.testing.entity.Testing;

import java.util.Date;
import java.util.List;

/**
 * Created by scarlett on 2017/5/23.
 */
public class CreateTestVO {

    private String username;

    private String name;

    private Integer testType;

    private String url;

    private Boolean isExcuteNow;

    private Date excuteTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTestType() {
        return testType;
    }

    public void setTestType(Integer testType) {
        this.testType = testType;
    }

    public Boolean getIsExcuteNow() {
        return isExcuteNow;
    }

    public void setIsExcuteNow(Boolean isExcuteNow) {
        this.isExcuteNow = isExcuteNow;
    }

    public Date getExcuteTime() {
        return excuteTime;
    }

    public void setExcuteTime(Date excuteTime) {
        this.excuteTime = excuteTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
