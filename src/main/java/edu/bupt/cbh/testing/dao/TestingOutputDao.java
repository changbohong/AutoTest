package edu.bupt.cbh.testing.dao;

import edu.bupt.cbh.testing.entity.TestingOutput;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by changbohong on 2017/7/23.
 */
@Repository
public interface TestingOutputDao {

    /**
     * 测试单元输出写回
     * 写回单个字段
     * @param testingOutput
     * @return
     */
    Integer insertOutput(TestingOutput testingOutput);

    /**
     * 重新执行测试
     * 更新结果
     * @param testingOutput
     * @return
     */
    Integer updateOutputResult(TestingOutput testingOutput);

    List<TestingOutput> getTestingOutputList(Integer testingId);
}
