package edu.bupt.cbh.user.entity;

import edu.bupt.cbh.common.Constants;

/**
 * Created by changbohong on 2017/5/15.
 */
public class User {
    //唯一id
    private Integer id;
    //姓名
    private String username;
    //密码
    private String password = Constants.UserCons.DEFAULT_PASSWORD;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
