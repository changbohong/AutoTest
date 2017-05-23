package edu.bupt.cbh.test.controller;

import com.alibaba.fastjson.JSONObject;
import edu.bupt.cbh.test.service.TestService;
import edu.bupt.cbh.test.vo.CreateTestVO;
import edu.bupt.cbh.test.vo.TestVO;
import edu.bupt.cbh.user.entity.User;
import edu.bupt.cbh.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
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

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/toCreate")
    public ModelAndView toCreate(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("test/createTest");
        modelAndView.addObject("currentTime",new Date());
        return modelAndView;
    }

    //将前缀为CreateTestVO.的属性绑定到 名称为CreateTestVO的对象
    @InitBinder("CreateTestVO")
    public void initBinder1(WebDataBinder binder){
        binder.setFieldDefaultPrefix("CreateTestVO.");
    }

    @RequestMapping(value = "/createTest", method = RequestMethod.POST)
    public Model createTest(HttpSession httpSession, CreateTestVO createTestVO, Model model) {
        String username = (String) httpSession.getAttribute("username");
        Integer testId = testService.createTest(username, createTestVO);
        if (testId == null) {
            String msg = "创建测试失败，测试名称为：" + createTestVO.getName();
            model.addAttribute("msg", msg);
            System.out.println(msg);
            return model;
        }
        model.addAttribute("msg", "创建成功");
        return model;
    }
}
