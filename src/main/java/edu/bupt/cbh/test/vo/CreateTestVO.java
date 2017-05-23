package edu.bupt.cbh.test.vo;

import java.util.Date;

/**
 * Created by scarlett on 2017/5/23.
 */
public class CreateTestVO {

    private String name;

    private Integer isExcuteNow;

    private Date excuteTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsExcuteNow() {
        return isExcuteNow;
    }

    public void setIsExcuteNow(Integer isExcuteNow) {
        this.isExcuteNow = isExcuteNow;
    }

    public Date getExcuteTime() {
        return excuteTime;
    }

    public void setExcuteTime(Date excuteTime) {
        this.excuteTime = excuteTime;
    }
}
