package edu.bupt.cbh.user.service;

import edu.bupt.cbh.user.entity.User;

/**
 * Created by changbohong on 2017/5/16.
 */
public interface UserService {
    /**
     * 检查密码正确
     * @param user
     * @return
     */
    public boolean checkPassword(User user);
}
