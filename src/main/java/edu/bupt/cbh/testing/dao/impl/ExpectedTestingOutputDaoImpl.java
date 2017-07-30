package edu.bupt.cbh.testing.dao.impl;

import edu.bupt.cbh.common.dao.BaseDaoImpl;
import edu.bupt.cbh.testing.dao.ExpectedTestingOutputDao;
import edu.bupt.cbh.testing.dao.TestingOutputDao;
import edu.bupt.cbh.testing.entity.ExpectedTestingOutput;
import edu.bupt.cbh.testing.entity.TestingOutput;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by changbohong on 2017/7/23.
 */
@Repository
public class ExpectedTestingOutputDaoImpl extends BaseDaoImpl implements ExpectedTestingOutputDao {

    @Override
    public Integer insertExpectedOutput(ExpectedTestingOutput expectedTestingOutput) {
        return sqlSessionTemplate.insert(this.getNameSpace()+".insertexpectedTestingOutput" , expectedTestingOutput);
    }

    @Override
    public List<ExpectedTestingOutput> getExpectedTestingOutputList(Integer testingId) {
        return sqlSessionTemplate.selectList(this.getNameSpace()+".getExpectedTestingOutputList" , testingId);
    }
}
