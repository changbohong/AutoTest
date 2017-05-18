package edu.bupt.cbh.login.controller;

import edu.bupt.cbh.user.entity.User;
import edu.bupt.cbh.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @RequestMapping("/login")
    public ModelAndView login(User user){
        if (userService.checkPassword(user)){
            return new ModelAndView("main");
        } else {
            return new ModelAndView("login");
        }
    }
}
