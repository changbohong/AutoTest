package edu.bupt.cbh.test.controller;

import edu.bupt.cbh.test.entity.Test;
import edu.bupt.cbh.test.service.TestService;
import edu.bupt.cbh.test.vo.CreateTestVO;
import edu.bupt.cbh.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    //springMVC接收前端Date数据，格式转换
    @InitBinder
    public void initBinder(ServletRequestDataBinder bin){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        CustomDateEditor cust = new CustomDateEditor(sdf,true);
        bin.registerCustomEditor(Date.class,cust);
    }

    @RequestMapping(value = "/createTest", method = RequestMethod.POST)
    public ModelAndView createTest(HttpSession httpSession, CreateTestVO createTestVO) {
        ModelAndView modelAndView = new ModelAndView("main/main");
        String username = (String) httpSession.getAttribute("username");
        Integer testId = testService.createTest(username, createTestVO);
        if (testId == null) {
            String msg = "创建测试失败，测试名称为：" + createTestVO.getName();
            modelAndView.addObject("msg", msg);
            System.out.println(msg);
            return modelAndView;
        }
        modelAndView.addObject("msg", "创建成功");
        return modelAndView;
    }

    @RequestMapping(value = "/searchTest")
    public ModelAndView searchTest(String name, Integer page){
        ModelAndView modelAndView = new ModelAndView("test/listTest");
        List<Test> testList = testService.searchTestLikeName(name);
        modelAndView.addObject("testList", testList);
        return modelAndView;
    }
}
