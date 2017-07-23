package edu.bupt.cbh.testing.dao;

import edu.bupt.cbh.testing.entity.TestingOutput;

/**
 * Created by changbohong on 2017/7/23.
 */
public interface TestingOutputDao {

    /**
     * 测试单元输出写回
     * 写回单个字段
     * @param testingOutput
     * @return
     */
    Integer insertOutput(TestingOutput testingOutput);
}
