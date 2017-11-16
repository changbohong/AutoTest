package edu.bupt.cbh.testing.dao;

import edu.bupt.cbh.testing.entity.TestingLinkResult;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by changbohong on 2017/11/16.
 */
@Repository
public interface TestingLinkResultDao {

    void saveAll(List<TestingLinkResult> testingLinkResults);

}
