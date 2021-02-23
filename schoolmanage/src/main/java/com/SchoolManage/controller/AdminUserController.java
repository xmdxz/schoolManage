package com.SchoolManage.controller;

import com.SchoolManage.pojo.AdminUser;
import com.SchoolManage.service.AdminUserService;
import com.SchoolManage.util.CaptchaCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author RainGoal
 * @Date 2021/1/26 15:41
 * @Description TODO
 * @Version 1.0
 */
@Controller
@RequestMapping("/admin")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;

    @RequestMapping("login")
    @ResponseBody
    public Map<String, Object> adminUserLogin(String username, String password, String captchacode,
                                              HttpServletRequest request, HttpServletResponse response) {
        String captchacode1 = (String) request.getSession().getAttribute("captchacode");
        Map<String, Object> map = new HashMap<>();
        if (CaptchaCodeUtil.verifyCode(captchacode, captchacode1).equals("failed")) {
            map.put("msg", "验证码有误");
            map.put("code", 500);
            return map;
        }

        AdminUser adminUser = adminUserService.getAdminUser(username);
        if (adminUser == null) {
            map.put("msg", "账号不存在");
            map.put("code", 500);
            return map;
        }


        if (!adminUser.getPassword().equals(password)) {
            map.put("msg", "密码错误");
            map.put("code", 500);
            return map;
        }

        map.put("msg", "ok");
        map.put("code", 200);
        request.getSession().setAttribute("administer", adminUser);
//        Cookie namecookie = new Cookie("name",adminUser.getName());
//        namecookie.setMaxAge(60*60*24);
//        Cookie departcookie = new Cookie("department", adminUser.getDepartment());
//        departcookie.setMaxAge(60*60*24);
//        Cookie phonecookie = new Cookie("phone", adminUser.getPhone());
//        phonecookie.setMaxAge(60*60*24);
//        Cookie positioncookie = new Cookie("position",adminUser.getPosition());
//        positioncookie.setMaxAge(60*60*24);
//        Cookie usercookie = new Cookie("username", adminUser.getUsername());
//        usercookie.setMaxAge(60*60*24);
//        response.addCookie(namecookie);
//        response.addCookie(departcookie);
//        response.addCookie(phonecookie);
//        response.addCookie(positioncookie);
//        response.addCookie(usercookie);
        return map;

    }


    @RequestMapping("getadminuser")
    @ResponseBody
    public AdminUser findByName(String username) {
        AdminUser adminUser = adminUserService.getAdminUser(username);
        return adminUser;
    }

    @RequestMapping("captcha")
    public void drawCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String code = new CaptchaCodeUtil().randomStr(4);
        request.getSession().setAttribute("captchacode", code);
        CaptchaCodeUtil vcode = new CaptchaCodeUtil(120, 38, 4, 10, code);
        vcode.write(response.getOutputStream());
    }

    @RequestMapping("logout")
    public String logOut(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
//        Cookie namecookie = new Cookie("name",null);
//        namecookie.setMaxAge(0);
//        Cookie departcookie = new Cookie("department", null);
//        departcookie.setMaxAge(0);
//        Cookie phonecookie = new Cookie("phone", null);
//        phonecookie.setMaxAge(0);
//        Cookie positioncookie = new Cookie("position",null);
//        positioncookie.setMaxAge(0);
//        Cookie usercookie = new Cookie("username", null);
//        usercookie.setMaxAge(0);
//        response.addCookie(namecookie);
//        response.addCookie(departcookie);
//        response.addCookie(phonecookie);
//        response.addCookie(positioncookie);
//        response.addCookie(usercookie);
        return "redirect:login.html";
    }

    @RequestMapping("updatepassword")
    @ResponseBody
    public String updatePassword(String username, String password) {
        int i = adminUserService.updatePassword(username, password);
        if (i != 0) {
            return "1";
        } else return "0";
    }
}
