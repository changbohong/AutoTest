package edu.bupt.cbh.test.dao;

import edu.bupt.cbh.test.entity.Test;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by scarlett on 2017/5/22.
 */
@Repository
public interface TestDao {
    Integer insertTest(Test test);

    Integer updateTest(Test test);

    String getCurrentDate();

    /**
     * 模糊匹配
     * @param testName
     * @return
     */
    List<Test> searchTestLikeName(String testName);

    /**
     * 完全匹配
     * @param testName
     * @return
     */
    List<Test> searchTestByName(String testName);



    Test getTestById(Integer id);
}
