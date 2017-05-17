package edu.bupt.cbh.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by changbohong on 2017/5/15.
 */
@Controller
public class LoginController {
    /**
     * 未登录，返回登录页面
     * @return
     */
    @RequestMapping("/toLogin")
    public ModelAndView toLogin(){
        ModelAndView modelAndView = new ModelAndView("edu.bupt.cbh.login");
        return modelAndView;
    }

    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }
}
