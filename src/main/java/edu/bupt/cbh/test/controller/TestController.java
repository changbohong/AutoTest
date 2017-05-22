package edu.bupt.cbh.test.controller;

import com.alibaba.fastjson.JSONObject;
import edu.bupt.cbh.test.service.TestService;
import edu.bupt.cbh.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by scarlett on 2017/5/22.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/toCreate")
    public ModelAndView toCreate(){
        return new ModelAndView("createTest");
    }

    @RequestMapping(value = "/createTest", method = RequestMethod.POST)
    public JSONObject createTest(User user, String name, Integer isExcuteNow, Timestamp excuteTime){
        Map<String, Object> result = new HashMap<>();

        return (JSONObject) result;
    }
}
