package com.SchoolManage.controller;

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
    public Map<String,Object> adminUserLogin(String username,String password,String captchacode,HttpServletRequest request){
        String captchacode1 = (String) request.getSession().getAttribute("captchacode");
        System.out.println(captchacode1);
        Map<String, Object> map = new HashMap<>();
        if (CaptchaCodeUtil.verifyCode(captchacode, captchacode1).equals("failed")){
            map.put("msg", "验证码有误");
            map.put("code",500);
            return map;
        }

        String password1 = adminUserService.getPassword(username);
        if (password1==null){
            map.put("msg", "账号不存在");
            map.put("code",500);
            return map;
        }


        if (!password1.equals(password)){
            map.put("msg", "密码错误");
            map.put("code",500);
            return map;
        }

        map.put("msg", "ok");
        map.put("code",200);
        return map;

    }

    @RequestMapping("captcha")
    public void drawCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String code = new CaptchaCodeUtil().randomStr(4);
        request.getSession().setAttribute("captchacode", code);
        CaptchaCodeUtil vcode = new CaptchaCodeUtil(120,38,4,10,code);
        vcode.write(response.getOutputStream());
    }
}
