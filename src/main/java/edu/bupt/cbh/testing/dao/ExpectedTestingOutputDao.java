package edu.bupt.cbh.testing.dao;

import edu.bupt.cbh.testing.entity.ExpectedTestingOutput;
import edu.bupt.cbh.testing.entity.TestingOutput;

import java.util.List;

/**
 * Created by changbohong on 2017/7/23.
 */
public interface ExpectedTestingOutputDao {
    Integer insertExpectedOutput(ExpectedTestingOutput expectedTestingOutput);

    List<ExpectedTestingOutput> getExpectedTestingOutputList(Integer testingId);
}
