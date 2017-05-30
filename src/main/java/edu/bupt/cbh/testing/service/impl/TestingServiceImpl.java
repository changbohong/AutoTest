package edu.bupt.cbh.testing.service.impl;

import edu.bupt.cbh.testing.dao.TestingDao;
import edu.bupt.cbh.testing.entity.Testing;
import edu.bupt.cbh.testing.service.TestingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by scarlett on 2017/5/25.
 */
public class TestingServiceImpl implements TestingService{

    @Autowired
    private TestingDao testingDao;

    @Override
    public void insertTestingList(Integer testId, List<Testing> testingList) {
        for (Testing testing : testingList){
            testing.setTestId(testId);
        }
        testingDao.insertTestingList(testingList);
    }
}
