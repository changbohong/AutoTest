package edu.bupt.cbh.user.dao;

import edu.bupt.cbh.user.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by changbohong on 2017/5/16.
 */
@Repository
public interface UserDao {
    User getUserByUsername(String username);
}
