package edu.bupt.cbh.testing.dao.impl;

import edu.bupt.cbh.common.dao.BaseDaoImpl;
import edu.bupt.cbh.testing.dao.TestingOutputDao;
import edu.bupt.cbh.testing.entity.TestingOutput;
import org.springframework.stereotype.Repository;

/**
 * Created by changbohong on 2017/7/23.
 */
@Repository
public class TestingOutputDaoImpl extends BaseDaoImpl implements TestingOutputDao {
    @Override
    public Integer insertOutput(TestingOutput testingOutput) {
        return sqlSessionTemplate.insert(this.getNameSpace()+".insertOutput" , testingOutput);
    }
}
