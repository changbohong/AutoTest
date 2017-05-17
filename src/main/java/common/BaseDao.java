package common;

import org.mybatis.spring.SqlSessionTemplate;

/**
 * Created by changbohong on 2017/5/16.
 */
public class BaseDao {
    protected SqlSessionTemplate sqlSessionTemplate;

    public String getNameSpace(){
        return this.getClass().getName();
    }

    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }
}
