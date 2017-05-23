package edu.bupt.cbh.user.dao;

import edu.bupt.cbh.user.entity.User;

/**
 * Created by changbohong on 2017/5/16.
 */
public interface UserDao {
    User getUserByUsername(String username);
}
