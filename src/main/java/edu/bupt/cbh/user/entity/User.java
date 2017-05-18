package edu.bupt.cbh.user.entity;

import edu.bupt.cbh.common.Constants;

/**
 * Created by changbohong on 2017/5/15.
 */
public class User {
    //唯一id
    private Integer id;
    //姓名
    private String name;
    //密码
    private String password = Constants.UserCons.DEFAULT_PASSWORD;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
