package edu.bupt.cbh.test.dao.impl;

import edu.bupt.cbh.common.dao.BaseDaoImpl;
import edu.bupt.cbh.test.dao.TestDao;
import edu.bupt.cbh.test.entity.Test;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by scarlett on 2017/5/22.
 */
@Repository
public class TestDaoImpl extends BaseDaoImpl implements TestDao {
    @Override
    public Integer insertTest(Test test) {
        return sqlSessionTemplate.insert(this.getNameSpace() + ".insertTest", test);
    }

    @Override
    public String getCurrentDate() {
        return super.getCurrentDate();
    }

    @Override
    public List<Test> searchTestLikeName(String testName) {
        return sqlSessionTemplate.selectList(this.getNameSpace() + ".searchTestLikeName", testName);
    }

    @Override
    public List<Test> searchTestByName(String testName) {
        return sqlSessionTemplate.selectList(this.getNameSpace() + ".searchTestByName", testName);
    }

    @Override
    public Test getTestById(Integer id) {
        return sqlSessionTemplate.selectOne(this.getNameSpace() + "getTestById", id);
    }
}
