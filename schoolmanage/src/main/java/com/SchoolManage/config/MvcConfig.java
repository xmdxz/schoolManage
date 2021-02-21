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
        registry.addViewController("/loginp_1.html").setViewName("loginp_1");
        registry.addViewController("/Test.html").setViewName("test");
        registry.addViewController("/departments.html").setViewName("departments");
        registry.addViewController("/edit-department.html").setViewName("edit-department");
        registry.addViewController("/add-department.html").setViewName("add-department");
        registry.addViewController("/member.html").setViewName("member");
        registry.addViewController("/edit-member.html").setViewName("edit-member");
        registry.addViewController("/add-member.html").setViewName("add-member");
        registry.addViewController("/holiday.html").setViewName("holiday");
        registry.addViewController("/event.html").setViewName("event");
        registry.addViewController("/hostel.html").setViewName("hostel");
        registry.addViewController("/add-hostel.html").setViewName("add-hostel");
        registry.addViewController("/loginp_2.html").setViewName("loginp_2");
        registry.addViewController("/loginp_3.html").setViewName("loginp_3");
        registry.addViewController("/edit-hostel.html").setViewName("edit-hostel");
        registry.addViewController("/member-hostel.html").setViewName("member-hostel");
        registry.addViewController("/profile.html").setViewName("profile");
        registry.addViewController("/activity.html").setViewName("activity");
        registry.addViewController("/add-activity.html").setViewName("add-activity");
        registry.addViewController("/edit-activity.html").setViewName("edit-activity");
        registry.addViewController("/member-activity.html").setViewName("member-activity");
        registry.addViewController("/loginp_4.html").setViewName("loginp_4");
        registry.addViewController("/edit-member-activity.html").setViewName("edit-member-activity");
        registry.addViewController("/add-member-activity.html").setViewName("add-member-activity");
        registry.addViewController("/psychology.html").setViewName("psychology");
        registry.addViewController("/edit-holiday.html").setViewName("edit-holiday");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login.html","/admin/login","/admin/captcha","/admin/getadminuser","/assets/**");
    }
}
