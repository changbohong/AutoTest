package edu.bupt.cbh.test.dao;

import edu.bupt.cbh.test.entity.Test;

import java.util.Date;

/**
 * Created by scarlett on 2017/5/22.
 */
public interface TestDao {
    Integer insertTest(Test test);

    String getCurrentDate();
}
