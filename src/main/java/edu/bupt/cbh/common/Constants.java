package edu.bupt.cbh.common;

/**
 * Created by changbohong on 2017/5/15.
 */
public class Constants {

    public static class UserCons{
        public static final String DEFAULT_PASSWORD = "123456";
    }

    public static class InitTemplateCons {
        public static final String REGIST_PATH = "/Users/scarlett/Developer/AutoTest/src/main/java/edu/bupt/cbh/template/init/RegistTemplate.xml";
        public static final String REGIST_LISTNODE = "template";
        public static final String LOGIN_PATH = "";
        public static final String LOGIN_LEVELONE = "";
    }

    public static class TestCons{
        public static final Boolean EXCUTE_NOW = true;
        public static final Boolean NOT_EXCUTE_NOW = false;
        public static final Boolean EXCUTED = true;
        public static final Boolean NOT_EXCUTED = false;
    }

    public static class TestingResults{
        public static final String TRUE = "正确";
        public static final String FALSE = "错误";
        public static final String KEY_NOT_FOUND = "未收到该字段";
    }

    public static class TestType{
        public static final String FUNTCION = "功能";
        public static final String PAGE = "页面";
        public static final String SEARCH = "搜索";
    }

    public static final Integer PAGE_SIZE = 10;
}
