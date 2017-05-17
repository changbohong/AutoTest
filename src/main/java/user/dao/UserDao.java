package user.dao;

import user.entity.User;

/**
 * Created by changbohong on 2017/5/16.
 */
public interface UserDao {
    public User getUserByName(String name);
}
