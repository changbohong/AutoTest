package edu.bupt.cbh.test.entity;

import edu.bupt.cbh.common.Constants;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by scarlett on 2017/5/22.
 * 测试
 */
public class Test {
    //一次测试 唯一id
    //一次测试包含多个测试用例
    //例如一次测试可以先测注册，后测表单
    private Integer id;

    private Integer userId;

    private String name;


    private Boolean excuted = Constants.TestCons.NOT_EXCUTED;

    //创建时间
    private Date createTime;

    //是否立即执行 1表示立即执行 -1表示否 默认立即执行
    private Boolean isExcuteNow = Constants.TestCons.EXCUTE_NOW;

    //执行时间
    private Date excuteTime = null;







    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getExcuteTime() {
        return excuteTime;
    }

    public void setExcuteTime(Date excuteTime) {
        this.excuteTime = excuteTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getIsExcuteNow() {
        return isExcuteNow;
    }

    public void setIsExcuteNow(Boolean isExcuteNow) {
        this.isExcuteNow = isExcuteNow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getExcuted() {
        return excuted;
    }

    public void setExcuted(Boolean excuted) {
        this.excuted = excuted;
    }
}
