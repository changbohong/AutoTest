package edu.bupt.cbh.test.service.impl;

import edu.bupt.cbh.test.dao.TestDao;
import edu.bupt.cbh.test.entity.Test;
import edu.bupt.cbh.test.service.TestService;
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

    @Override
    public Integer createTest(Integer userId, Integer isExcuteNow, Timestamp excuteTime) {
        Test test = new Test();
        test.setUserId(userId);
        test.setIsExcuteNow(isExcuteNow);
        test.setCreateTime(new Timestamp(new Date().getTime()));
        test.setExcuteTime(excuteTime);
        return testDao.insertTest(test);
    }

    @Override
    public void executeTest() {
        System.out.println("executeTest " + testDao.getCurrentDate());
    }
}
