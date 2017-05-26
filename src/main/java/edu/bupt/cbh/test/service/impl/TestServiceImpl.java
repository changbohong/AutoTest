package edu.bupt.cbh.test.service.impl;

import edu.bupt.cbh.test.dao.TestDao;
import edu.bupt.cbh.test.entity.Test;
import edu.bupt.cbh.test.service.TestService;
import edu.bupt.cbh.test.vo.CreateTestVO;
import edu.bupt.cbh.user.dao.UserDao;
import edu.bupt.cbh.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by scarlett on 2017/5/22.
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Autowired
    private UserDao userDao;

    @Override
    public Integer createTest(CreateTestVO createTestVO) {
        Test test = new Test();
        User user = userDao.getUserByUsername(createTestVO.getUsername());
        test.setUser(user);
        test.setUserId(user.getId());
        test.setName(createTestVO.getName());
        test.setCreateTime(new Date());
        test.setExcuteTime(createTestVO.getExcuteTime());
        test.setIsExcuteNow(createTestVO.getIsExcuteNow());
        testDao.insertTest(test);
        return test.getId();
    }

    @Override
    public List<Test> searchTestByName(String name) {
        return testDao.searchTestByName(name);
    }

    @Override
    public List<Test> searchTestLikeName(String name) {
        if (name == null){
            name = "";
        }
        return testDao.searchTestLikeName(name);
    }

    @Override
    public void DeleteTestBy(Integer id) {

    }

    @Override
    public void executeTest() {
        System.out.println("executeTest " + testDao.getCurrentDate());
    }

    @Override
    public Test getTestById(Integer id) {
        return testDao.getTestById(id);
    }
}
