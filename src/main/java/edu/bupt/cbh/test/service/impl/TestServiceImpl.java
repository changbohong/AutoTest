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
    public Integer createTest(String username, CreateTestVO createTestVO) {
        Test test = new Test();
        User user = userDao.getUserByUsername(username);
        Integer userId = user.getId();
        test.setUserId(userId);
        test.setName(createTestVO.getName());
        test.setCreateTime(new Date());
        test.setExcuteTime(createTestVO.getExcuteTime());
        testDao.insertTest(test);
        return test.getId();
    }

    @Override
    public void executeTest() {
        System.out.println("executeTest " + testDao.getCurrentDate());
    }
}
