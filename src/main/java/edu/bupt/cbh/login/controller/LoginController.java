package edu.bupt.cbh.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import edu.bupt.cbh.user.entity.User;
import edu.bupt.cbh.user.service.UserService;

/**
 * Created by changbohong on 2017/5/15.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 未登录，返回登录页面
     * @return
     */
    @RequestMapping("/toLogin")
    public ModelAndView toLogin(){
        ModelAndView modelAndView = new ModelAndView("edu/bupt/cbh/login");
        return modelAndView;
    }

    @RequestMapping(value = "/edu/bupt/cbh/login", method = RequestMethod.POST)
    public ModelAndView login(User user){
        //测试用
        user.setId(1);
        user.setName("admin");
        user.setPassword("123456");

        if (userService.checkLogin(user)){
            return new ModelAndView("success");
        } else {
            return new ModelAndView("fail");
        }
    }
}
