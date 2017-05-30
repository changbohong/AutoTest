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

    private Boolean isExcuteNow;

    private Date excuteTime;

    private List<Testing> testingList;

    public List<Testing> getTestingList() {
        return testingList;
    }

    public void setTestingList(List<Testing> testingList) {
        this.testingList = testingList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
