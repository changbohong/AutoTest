package edu.bupt.cbh.test.service;

import edu.bupt.cbh.test.vo.CreateTestVO;
import edu.bupt.cbh.user.entity.User;

import java.sql.Timestamp;

/**
 * Created by scarlett on 2017/5/22.
 */
public interface TestService {

    /**
     * 创建测试
     * @param username 创建人名
     * @param createTestVO 测试参数
     * @return
     */
    Integer createTest(String username, CreateTestVO createTestVO);

    /**
     * 执行测试
     */
    void executeTest();
}
