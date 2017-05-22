package edu.bupt.cbh.test.service;

import edu.bupt.cbh.user.entity.User;

import java.sql.Timestamp;

/**
 * Created by scarlett on 2017/5/22.
 */
public interface TestService {
    /**
     * 创建测试
     *
     * @param userId
     * @param isExcuteNow
     * @param excuteTime
     */
    Integer createTest(Integer userId, Integer isExcuteNow, Timestamp excuteTime);

    /**
     * 执行测试
     */
    void executeTest();
}
