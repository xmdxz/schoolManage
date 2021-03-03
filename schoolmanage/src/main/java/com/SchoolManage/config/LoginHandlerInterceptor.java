package com.SchoolManage.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author RainGoal
 * @Date 2021/1/28 16:15
 * @Description TODO
 * @Version 1.0
 */

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object administer = session.getAttribute("administer");
        if (administer == null) {
            response.sendRedirect("/login.html");
            return false;
        }
        return true;
        
    }

}
