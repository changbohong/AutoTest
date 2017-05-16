package edu.bupt.cbh.user.dao;

import org.springframework.stereotype.Repository;
import edu.bupt.cbh.user.entity.User;

/**
 * Created by scarlett on 2017/5/16.
 */
@Repository
public interface UserDao {

    public User findUserByName(String name);

}
