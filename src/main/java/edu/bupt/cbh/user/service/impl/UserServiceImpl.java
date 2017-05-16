package edu.bupt.cbh.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import edu.bupt.cbh.user.dao.UserDao;
import edu.bupt.cbh.user.entity.User;
import edu.bupt.cbh.user.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by scarlett on 2017/5/16.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public boolean checkLogin(User user) {
        User userDB = userDao.findUserByName(user.getName());
        return userDB != null && userDB.getPassword().equals(user.getPassword());
    }
}
