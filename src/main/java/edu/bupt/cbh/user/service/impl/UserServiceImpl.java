package edu.bupt.cbh.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.bupt.cbh.user.dao.UserDao;
import edu.bupt.cbh.user.entity.User;
import edu.bupt.cbh.user.service.UserService;

/**
 * Created by changbohong on 2017/5/16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    public boolean checkPassword(User user) {
        User userDB = userDao.getUserByUsername(user.getUsername());
        return userDB != null && userDB.getPassword().equals(user.getPassword());
    }
}
