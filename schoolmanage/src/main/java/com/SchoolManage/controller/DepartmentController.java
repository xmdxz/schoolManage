package com.SchoolManage.controller;

import com.SchoolManage.pojo.DepartMent;
import com.SchoolManage.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author RainGoal
 * @Date 2021/2/5 16:00
 * @Description TODO
 * @Version 1.0
 */
@Controller
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("findall")
    @ResponseBody
    public List<DepartMent> findAll(int page,int num){
        List<DepartMent> all = departmentService.findAll(page, num);
        return all;
    }

    @RequestMapping("findallnum")
    @ResponseBody
    public int findAllNum(){
        int allNum = departmentService.findAllNum();
        return allNum;
    }

    @RequestMapping("findbyname")
    @ResponseBody
    public List<DepartMent> findByName(String name,int page,int num){
        List<DepartMent> byName = departmentService.findByName(name, page, num);
        return byName;
    }

    @RequestMapping("findbyid")
    @ResponseBody
    public DepartMent findById(int id){
        DepartMent byId = departmentService.findById(id);
        return byId;
    }

    @RequestMapping("findbynamenum")
    public int findByNameNum(String name){
        return departmentService.findByNameNum(name);
    }

    @RequestMapping("findbyminister")
    @ResponseBody
    public List<DepartMent> findByMinister(String minister,int page,int num){
        List<DepartMent> byMinister = departmentService.findByMinister(minister, page, num);
        return byMinister;
    }

    @RequestMapping("findbyministernum")
    @ResponseBody
    public int findByMinisterNum(String minister){
        int byMinisterNum = departmentService.findByMinisterNum(minister);
        return byMinisterNum;
    }

    @RequestMapping("findbycollege")
    @ResponseBody
    public List<DepartMent> findByCollege(String college,int page,int num){
        List<DepartMent> byCollege = departmentService.findByCollege(college, page, num);
        return byCollege;
    }

    @RequestMapping("findbycollegenum")
    @ResponseBody
    public int findByCollegeNum(String college){
        int byCollegeNum = departmentService.findByCollegeNum(college);
        return byCollegeNum;
    }

    @RequestMapping("insertdata")
    public String insertData(DepartMent departMent){
        System.out.println(departMent);
        int i = departmentService.insertData(departMent);
        if (i!=0){
            return "redirect:/departments.html";
        }else return "loginp";
    }

    @RequestMapping("updatedata")
    public String updateData(DepartMent departMent){
        System.out.println(departMent);
        int i = departmentService.updateData(departMent);
        if (i!=0){
            return "redirect:/departments.html";
         }else return "loginp";
    }

    @RequestMapping("deletedata")
    @ResponseBody
    public Map<String,Object> deleteData(int id){
        int i = departmentService.deleteData(id);
        Map<String, Object> map = new HashMap<>();
        if (i!=0){
            map.put("msg", "success");
            map.put("code", 200);
            return map;
        }else {
            map.put("msg", "failed");
            map.put("code", 500);
            return map;
        }
    }

}
