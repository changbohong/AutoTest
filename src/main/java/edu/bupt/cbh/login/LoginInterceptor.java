package edu.bupt.cbh.login;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by scarlett on 2017/5/23.
 * 登录认证拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 在进入Handler方法之前执行了，身份认证，用户没有登陆，拦截不再向下执行，返回值为 false ，即可实现拦截；
     * 否则，返回true时，拦截不进行执行；
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求的uri
        String uri = request.getRequestURI();

        //判断uri里是否包含login，如果是则说明用户处在登录页面，则不拦截
        if (uri.indexOf("login") >= 0) {
            return true;
        }

        //获取Session
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        //对于此用户session，如果有username，说明已经登录
        if (username != null) {
            return true;
        }
        //不符合条件的，跳转到登录界面
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
