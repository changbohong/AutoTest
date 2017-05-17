package edu.bupt.cbh.user.dao.impl;

import org.springframework.stereotype.Repository;
import edu.bupt.cbh.user.dao.UserDao;
import edu.bupt.cbh.user.entity.User;
import edu.bupt.cbh.common.BaseDao;

/**
 * Created by changbohong on 2017/5/16.
 */
@Repository
public class UserDaoImpl extends BaseDao implements UserDao {

    public User getUserByName(String name) {
        return (User) sqlSessionTemplate.selectOne(getNameSpace()+".getUserByName", name);
    }
}
