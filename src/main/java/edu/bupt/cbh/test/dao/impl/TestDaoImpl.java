package edu.bupt.cbh.test.dao.impl;

import edu.bupt.cbh.common.dao.BaseDaoImpl;
import edu.bupt.cbh.test.dao.TestDao;
import edu.bupt.cbh.test.entity.Test;
import org.springframework.stereotype.Repository;

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
}
