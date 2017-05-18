package edu.bupt.cbh.common;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by changbohong on 2017/5/16.
 */
public class BaseDao {

    @Autowired
    protected SqlSessionTemplate sqlSessionTemplate;

    public String getNameSpace(){
        return this.getClass().getName();
    }

    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }
}
