package edu.bupt.cbh.testing.dao;

import edu.bupt.cbh.testing.entity.Testing;

import java.util.List;

/**
 * Created by scarlett on 2017/5/26.
 */
public interface TestingDao {

    Integer addTesting(Testing testing);

    /**
     * 获得此测试下所有测试单元
     * @param testId
     * @return
     */
    List<Testing> getAllTestings(Integer testId);
}