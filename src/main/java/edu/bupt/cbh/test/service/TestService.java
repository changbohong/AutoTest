package edu.bupt.cbh.test.service;

import edu.bupt.cbh.test.entity.Test;
import edu.bupt.cbh.test.vo.CreateTestVO;
import edu.bupt.cbh.user.entity.User;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by scarlett on 2017/5/22.
 */
public interface TestService {

    /**
     * 创建测试
     * @param createTestVO 测试参数
     * @return
     */
    Integer createTest(CreateTestVO createTestVO);

    /**
     * 执行测试
     */
    void executeTest();

    List<Test> searchTestByName(String name);

    List<Test> searchTestLikeName(String name);

    void DeleteTestBy(Integer id);

    Test getTestById(Integer id);

}
