package com.SchoolManage.controller;

import com.SchoolManage.exception.NameNullException;
import com.SchoolManage.pojo.Activemember;
import com.SchoolManage.pojo.Activity;
import com.SchoolManage.pojo.Member;
import com.SchoolManage.pojo.Student;
import com.SchoolManage.service.ActiveMemberService;
import com.SchoolManage.util.CreateExlceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author RainGoal
 * @Date 2021/2/19 9:36
 * @Description TODO
 * @Version 1.0
 */
@Controller
@RequestMapping("activemember")
public class ActiveMemberController {
    @Autowired
    private ActiveMemberService activeMemberService;

    @RequestMapping("findall")
    @ResponseBody
    public List<Activemember> findAll(Integer Page, Integer num) {
        return activeMemberService.findAll(Page, num);
    }

    @RequestMapping("findallcount")
    @ResponseBody
    public int findAllCount() {
        return activeMemberService.findAllCount();
    }

    @RequestMapping("findbyactive")
    @ResponseBody
    public List<Activemember> findByActive(Integer id, Integer Page, Integer num) {
        return activeMemberService.findByActive(id, Page, num);
    }

    @RequestMapping("findbyactivecount")
    @ResponseBody
    public int findByActiveCount(Integer id) {
        return activeMemberService.findByActiveCount(id);
    }

    @RequestMapping("findbyclazz")
    @ResponseBody
    public List<Activemember> findByClazz(String clazz, Integer Page, Integer num) {
        return activeMemberService.findByClazz(clazz, Page, num);
    }

    @RequestMapping("findbyclazzcount")
    @ResponseBody
    public int findByClazzCount(String clazz) {
        return activeMemberService.findByClazzCount(clazz);
    }

    @RequestMapping("findbyactiveandclazz")
    @ResponseBody
    public List<Activemember> findByActiveAndClazz(Integer id, String clazz, Integer Page, Integer num) {
        return activeMemberService.findByActiveAndClazz(id, clazz, Page, num);
    }

    @RequestMapping("findbyactiveandclazzcount")
    @ResponseBody
    public int findByActiveAndClazzCount(Integer id, String clazz) {
        return activeMemberService.findByActiveAndClazzCount(id, clazz);
    }

    @RequestMapping("insertdata")
    public String insertData(Activemember activemember) {
        int i = activeMemberService.insertData(activemember);
        if (i != 0) {
            return "redirect:改变跳转地址";
        } else {
            return "redirect:改变跳转地址";
        }
    }

    @RequestMapping("deletedata")
    @ResponseBody
    public Map<String, Object> deleteData(int id) {
        int i = activeMemberService.deleteData(id);
        Map<String, Object> map = new HashMap<>();
        if (i != 0) {
            map.put("msg", "success");
            map.put("code", 200);
            return map;
        } else {
            map.put("msg", "failed");
            map.put("code", 500);
            return map;
        }
    }
    @RequestMapping(value = "Excle",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String ExcleStudent(HttpServletRequest request,Integer id) throws NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException, NameNullException {
        int i=activeMemberService.findByActiveCount(id);
        CreateExlceUtil<Activemember> createExlceUtil = new CreateExlceUtil<>(request,Activemember.class,"活动成员表");
        List<Activemember> list =activeMemberService.findByActive(id,1,i);
        return createExlceUtil.createExcle(list);
    }
    @RequestMapping("findbystudent")
    @ResponseBody
    public Activemember findByStudent(String student,Integer activity) {
        return activeMemberService.findByStudent(student,activity);
    }
    @RequestMapping("findbyname")
    @ResponseBody
    public List<Activemember> findByName(String name,Integer activity, int page, int num) {
       return activeMemberService.findByName(name,activity,page,num);
    }

    @RequestMapping("findByNameCount")
    @ResponseBody
    public String findByNameCount(String name,Integer activity) {

        int i = activeMemberService.findByNameCount(name,activity);
        return Integer.toString(i);
    }
}
