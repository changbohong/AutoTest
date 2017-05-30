package edu.bupt.cbh.testing.dao.impl;

import edu.bupt.cbh.common.dao.BaseDaoImpl;
import edu.bupt.cbh.test.dao.TestDao;
import edu.bupt.cbh.testing.dao.TestingDao;
import edu.bupt.cbh.testing.entity.Testing;

import java.util.List;

/**
 * Created by scarlett on 2017/5/26.
 */
public class TestingDaoImpl extends BaseDaoImpl implements TestingDao {

    @Override
    public void insertTestingList(List<Testing> testingList) {
        sqlSessionTemplate.insert(this.getNameSpace() + ".insertTestingList", testingList);
    }
}
