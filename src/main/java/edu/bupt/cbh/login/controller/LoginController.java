package edu.bupt.cbh.login.controller;

import edu.bupt.cbh.template.service.InitTemplatDataBaseeService;
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

    @Autowired
    private InitTemplatDataBaseeService initTemplatDataBaseeService;

    /**
     * 未登录，返回登录页面
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin(){
        return LOGIN;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpSession httpSession, User user){
        if (userService.checkPassword(user)){
            httpSession.setAttribute("username", user.getName());
            return "redirect:/main";
        } else {
            return LOGIN;
        }
    }

    @RequestMapping(value = {"/", "/main"})
    public ModelAndView main(){
        return new ModelAndView("main");
    }

    @RequestMapping("/init")
    public void initTemplate(){
        initTemplatDataBaseeService.initTemplateDataBase();
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        System.out.println("log out");
        return LOGIN;
    }

    public static final String LOGIN = "login";
}
