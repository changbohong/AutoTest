package edu.bupt.cbh.test.service;

import edu.bupt.cbh.test.entity.Test;
import edu.bupt.cbh.test.entity.TestResult;
import edu.bupt.cbh.test.vo.CreateTestVO;

import java.util.List;
import java.util.Map;

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

    List<Test> searchTestByName(String name);

    List<Test> searchTestLikeName(String name);

    void DeleteTestBy(Integer id);

    Test getTestById(Integer id);

    /**
     * 执行测试
     * @param baseUrl
     * @param targetUrl
     * @param params
     * @return
     */
    Map<String, Object> testRun(String baseUrl , String targetUrl , Map<String, Object> params);

    /**
     * 生成测试报告
     * @param testId
     * @return
     */
    TestResult createTestReport(Integer testId);

}
