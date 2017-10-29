package edu.bupt.cbh.testing.dao;

import edu.bupt.cbh.testing.entity.RandomTestingInput;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by changbohong on 2017/10/29.
 */
@Repository
public interface RandomTestingInuptDao {

    List<RandomTestingInput> listByInputType(@Param("inputType") int inputType);
}
