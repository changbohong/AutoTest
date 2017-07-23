package edu.bupt.cbh.testing.dao.impl;

import edu.bupt.cbh.common.dao.BaseDaoImpl;
import edu.bupt.cbh.test.dao.TestDao;
import edu.bupt.cbh.testing.dao.TestingDao;
import edu.bupt.cbh.testing.entity.Testing;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by scarlett on 2017/5/26.
 */
@Repository
public class TestingDaoImpl extends BaseDaoImpl implements TestingDao {

    @Override
    public Integer addTesting(Testing testing) {
        return sqlSessionTemplate.insert(this.getNameSpace() + ".addTesting", testing);
    }

    @Override
    public List<Testing> getAllTestings(Integer testId) {
        return sqlSessionTemplate.selectList(this.getNameSpace() + ".getAllTestings", testId);
    }
}
