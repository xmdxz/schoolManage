package com.SchoolManage.controller;

import com.SchoolManage.pojo.Member;
import com.SchoolManage.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author RainGoal
 * @Date 2021/2/6 8:39
 * @Description TODO
 * @Version 1.0
 */
@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @RequestMapping("findall")
    @ResponseBody
    public List<Member> findAll(int page,int num){
        List<Member> all = memberService.findAll(page, num);
        return all;
    }

    @RequestMapping("findallnum")
    @ResponseBody
    public int findAllNum(){
        return memberService.findAllNum();
    }

    @RequestMapping("findbydepartment")
    @ResponseBody
    public List<Member> findByDepartment(String department,int page,int num){
        List<Member> byDepartment = memberService.findByDepartment(department, page, num);
        return byDepartment;
    }

    @RequestMapping("findbydepartmentnum")
    @ResponseBody
    public int findByDepartmentNum(String department){
        return memberService.findByDepartmentNum(department);
    }

    @RequestMapping("findbyid")
    @ResponseBody
    public Member findById(String id){
        Member byId = memberService.findById(id);
        return byId;
    }

    @RequestMapping("findbyname")
    @ResponseBody
    public List<Member> findByName(String name,int page,int num){
        List<Member> byName = memberService.findByName(name, page, num);
        return byName;
    }

    @RequestMapping("findbynamenum")
    @ResponseBody
    public int findByNameNum(String name){
        return memberService.findByNameNum(name);
    }

    @RequestMapping("findbyposition")
    @ResponseBody
    public List<Member> findByPosition(String position,int page,int num){
        List<Member> byPosition = memberService.findByPosition(position, page, num);
        return byPosition;
    }

    @RequestMapping("findbypositionnum")
    @ResponseBody
    public int findByPositionNum(String position){
        int byPositionNum = memberService.findByPositionNum(position);
        return byPositionNum;
    }

    @RequestMapping("insertdata")
    public String insertData(Member member){
        int i = memberService.insertData(member);
        if (i!=0){
            return "redirect:/departments.html";
        }else return "loginp";
    }

    @RequestMapping("updatedata")
    public String updateData(Member member){
        int i = memberService.updateData(member);
        if (i!=0){
            return "redirect:/departments.html";
        }else return "loginp";
    }

    @RequestMapping("deletedata")
    @ResponseBody
    public Map<String,Object> deleteData(String id){
        int i = memberService.deleteData(id);
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
