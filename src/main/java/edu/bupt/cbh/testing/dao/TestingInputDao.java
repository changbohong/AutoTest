package edu.bupt.cbh.testing.dao;

import edu.bupt.cbh.testing.entity.TestingInput;

import java.util.List;

/**
 * Created by changbohong on 2017/7/23.
 */
public interface TestingInputDao {
    /**
     * 获得测试单元输入
     * @param testingId
     * @return
     */
    List<TestingInput> getInputList(Integer testingId);

    /**
     * 增加
     * @param testingInput
     * @return
     */
    Integer insertTestingInput(TestingInput testingInput);
}