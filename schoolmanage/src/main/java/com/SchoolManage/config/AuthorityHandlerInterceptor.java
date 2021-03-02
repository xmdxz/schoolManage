package com.SchoolManage.config;

import com.SchoolManage.pojo.AdminUser;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author RainGoal
 * @Description DOTO
 * @Date 2021/3/2
 * @Version 1.0
 */

public class AuthorityHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        AdminUser administer = (AdminUser) session.getAttribute("administer");
        String responsible = administer.getResponsible();
        int flag = 0;
        if (responsible != "") {
            String[] split = responsible.split(",");
            for (int i = 0; i < split.length; i++) {
                System.out.println(split[i]);
                if (split[i].equals("大一")) {
                    flag = 1;
                    break;
                }
            }
            System.out.println(flag);
            if (flag == 0) {
                response.sendRedirect("noresponsible.html");
                return false;
            } else return true;

        }
        response.sendRedirect("noresponsible.html");
        return false;
    }
}
