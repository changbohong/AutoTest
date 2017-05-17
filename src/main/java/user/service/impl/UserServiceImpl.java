package user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.dao.UserDao;
import user.entity.User;
import user.service.UserService;

/**
 * Created by changbohong on 2017/5/16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public boolean checkPassword(User user) {
        User userDB = userDao.getUserByName(user.getName());
        return userDB != null && userDB.getPassword().equals(user.getPassword());
    }
}
