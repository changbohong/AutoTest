package edu.bupt.cbh.user.dao.impl;

import org.springframework.stereotype.Repository;
import edu.bupt.cbh.user.dao.UserDao;
import edu.bupt.cbh.user.entity.User;
import edu.bupt.cbh.common.dao.BaseDaoImpl;

/**
 * Created by changbohong on 2017/5/16.
 */
@Repository
public class UserDaoImplImpl extends BaseDaoImpl implements UserDao {

    public User getUserByUsername(String name) {
        return (User) sqlSessionTemplate.selectOne(this.getNameSpace() + ".getUserByUsername", name);
    }
}
