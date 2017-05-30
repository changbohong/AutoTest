package edu.bupt.cbh.testing.service;

import edu.bupt.cbh.testing.entity.Testing;

import java.util.List;

/**
 * Created by scarlett on 2017/5/25.
 */
public interface TestingService {

    void insertTestingList(Integer testId, List<Testing> testingList);
}
