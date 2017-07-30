package edu.bupt.cbh.testing.dao.impl;

import edu.bupt.cbh.common.dao.BaseDaoImpl;
import edu.bupt.cbh.testing.dao.TestingInputDao;
import edu.bupt.cbh.testing.entity.TestingInput;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by changbohong on 2017/7/23.
 */
@Repository
public class TestingInputDaoImpl extends BaseDaoImpl implements TestingInputDao {
    @Override
    public Integer insertTestingInput (TestingInput testingInput) {
        return sqlSessionTemplate.insert(this.getNameSpace()+".insertTestingInput" , testingInput);
    }

    @Override
    public List<TestingInput> getInputList(Integer testingId) {
        return sqlSessionTemplate.selectList(this.getNameSpace()+".getInputList" , testingId);
    }
}
