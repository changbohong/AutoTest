package edu.bupt.cbh.testing.service;

import edu.bupt.cbh.testing.entity.*;
import edu.bupt.cbh.testing.vo.AddTestingVO;

import java.util.List;
import java.util.Map;

/**
 * Created by scarlett on 2017/5/25.
 */
public interface TestingService {

    /**
     * 创建测试单元
     * @param addTestingVO
     * @return
     */
    Integer addTesting(AddTestingVO addTestingVO);

    /**
     * 更新测试单元
     * @param testing
     */
    void updateTesting(Testing testing);

    /**
     * 获得此测试下的所有测试单元
     * @param testId
     * @return
     */
    List<Testing> getAllTestings(Integer testId);

    /**
     * 读取测试单元输入
     * 数据库中input为单条存储。
     * 将inputList读取出来，组装成map对象
     * @param testingId
     * @return
     */
    Map<String , Object> getInputMap(Integer testingId);

    Map<String , Object> getOutputMap(Integer testingId);

    Map<String , Object> getExpectedOutputMap(Integer testingId);

    /**
     * 测试结果写回
     * @param outputMap
     */
    void insertOutPutMap(Map<String , Object> outputMap , Integer testingId);

    /**
     * 执行测试单元
     * @param testId
     * @param baseUrl
     */
    void testingRun(Integer testId , String baseUrl);

    List<TestingOutputResult> getTestingResultListByTesting(Testing testing);
}
