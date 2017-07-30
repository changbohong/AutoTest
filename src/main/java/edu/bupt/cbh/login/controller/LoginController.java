package edu.bupt.cbh.login.controller;

import edu.bupt.cbh.user.entity.User;
import edu.bupt.cbh.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

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
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return LOGIN;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpSession httpSession, User user){
        if (userService.checkPassword(user)){
            httpSession.setAttribute("username", user.getUsername());
            return new ModelAndView("main/main");
        } else {
            return new ModelAndView("login");
        }
    }

    @RequestMapping(value = {"/", "/main"})
    public ModelAndView main(){
        return new ModelAndView("main/main");
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        System.out.println("log out");
        return LOGIN;
    }

    public static final String LOGIN = "login";
}
