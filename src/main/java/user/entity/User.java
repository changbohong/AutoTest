package user.entity;

import common.Constants;

/**
 * Created by changbohong on 2017/5/15.
 */
public class User {
    //唯一id
    private Integer id;
    //姓名
    private String name;
    //密码
    private String password = Constants.User.DEFAULT_PASSWORD;
}
