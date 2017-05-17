package user.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import user.dao.UserDao;
import user.entity.User;
import common.BaseDao;

/**
 * Created by changbohong on 2017/5/16.
 */
@Repository
public class UserDaoImpl extends BaseDao implements UserDao {

    public User getUserByName(String name) {
        return (User) sqlSessionTemplate.selectOne(getNameSpace()+".getUserByName", name);
    }
}
