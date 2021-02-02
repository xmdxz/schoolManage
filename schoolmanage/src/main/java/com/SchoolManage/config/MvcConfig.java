package com.SchoolManage.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author RainGoal
 * @Date 2021/1/28 15:39
 * @Description TODO
 * @Version 1.0
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/students.html").setViewName("students");
        registry.addViewController("/student-details.html").setViewName("student-details");
        registry.addViewController("/add-student.html").setViewName("add-student");
        registry.addViewController("/edit-student.html").setViewName("edit-student");
        registry.addViewController("/loginp.html").setViewName("loginp");


    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login.html","/admin/login","/admin/captcha","/admin/getadminuser","/assets/**");
    }
}
