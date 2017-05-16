package edu.bupt.cbh.user.dao.impl;

import edu.bupt.cbh.common.BaseDao;
import org.springframework.stereotype.Repository;
import edu.bupt.cbh.user.dao.UserDao;
import edu.bupt.cbh.user.entity.User;

/**
 * Created by scarlett on 2017/5/16.
 */
@Repository
public class UserDaoImpl extends BaseDao implements UserDao{

    @Override
    public User findUserByName(String name) {
        String hql = "FROM user u WHERE u.name = :name";
        return (User) this.getHibernateTemplate().findByNamedParam(hql, "name", name);
    }

}
