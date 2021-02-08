package com.SchoolManage.controller;

import com.SchoolManage.pojo.Dormitory;
import com.SchoolManage.pojo.Student;
import com.SchoolManage.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author RainGoal
 * @Date 2021/2/8 13:54
 * @Description TODO
 * @Version 1.0
 */
@Controller
public class DormitoryController {
    @Autowired
    private DormitoryService dormitoryService;

    @RequestMapping("findDormitoryMember")
    @ResponseBody
    public List<Student> findDormitoryMember(Dormitory dormitory, int Page, int num) {
        return dormitoryService.findDormitoryMember(dormitory, Page, num);
    }

    @RequestMapping("findDormitoryMemberNum")
    @ResponseBody
    public int findDormitoryMemberNum(Dormitory dormitory) {
        return dormitoryService.findDormitoryMemberNum(dormitory);
    }

    @RequestMapping("findAll")
    @ResponseBody
    public List<Dormitory> findAll(int Page, int num) {
        return dormitoryService.findAll(Page, num);
    }

    @RequestMapping("findAllNum")
    @ResponseBody
    public int findAllNum() {
        return dormitoryService.findAllNum();
    }

    @RequestMapping("findByName")
    @ResponseBody
    public List<Dormitory> findByName(String name, int Page, int num) {
        return dormitoryService.findByName(name, Page, num);
    }

    @RequestMapping("findByNameNum")
    @ResponseBody
    public int findByNameNum(String name) {
        return dormitoryService.findByNameNum(name);
    }

    @RequestMapping("findById")
    @ResponseBody
    public Dormitory findById(String id) {
        return dormitoryService.findById(id);
    }

    @RequestMapping("findByBuilding")
    @ResponseBody
    public List<Dormitory> findByBuilding(String building, int Page, int num) {
        return dormitoryService.findByBuilding(building, Page, num);
    }

    @RequestMapping("findByBuildingNum")
    @ResponseBody
    public int findByBuildingNum(String building) {
        return dormitoryService.findByBuildingNum(building);
    }

    @RequestMapping("findByNumber")
    @ResponseBody
    public List<Dormitory> findByNumber(String number, int Page, int num) {
        return dormitoryService.findByNumber(number, Page, num);
    }

    @RequestMapping("findByNumberNum")
    @ResponseBody
    public int findByNumberNum(String number) {
        return dormitoryService.findByNumberNum(number);
    }

    @RequestMapping("findByBuildingAndNumber")
    @ResponseBody
    public Dormitory findByBuildingAndNumber(String building, String number) {
        return dormitoryService.findByBuildingAndNumber(building, number);
    }

    @RequestMapping("insertData")
    public String insertData(Dormitory dormitory) {
        int i = dormitoryService.insertData(dormitory);
        if (i != 0) {
            return "redirect:记得改这里的跳转的页面";
        } else return "redirect:loginp.html";
    }

    @RequestMapping("deleteData")
    @ResponseBody
    public Map<String, Object> deleteData(String building, String number) {
        int i = dormitoryService.deleteData(building, number);
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

    @RequestMapping("updateData")
    public String updateData(Dormitory dormitory) {
        int i = dormitoryService.updateData(dormitory);
        if (i != 0) {
            return "redirect:改一下地址";
        } else return "redirect:改一下地址";
    }

}
