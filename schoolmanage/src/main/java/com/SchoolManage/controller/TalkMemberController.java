package com.SchoolManage.controller;

import com.SchoolManage.pojo.TalkMember;
import com.SchoolManage.service.TalkMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author RainGoal
 * @Description DOTO
 * @Date 2021/3/24
 * @Version 1.0
 */
@Controller
@RequestMapping("talkmember")
public class TalkMemberController {
    @Autowired
    private TalkMemberService talkMemberService;

    @RequestMapping("findall")
    @ResponseBody
    public List<TalkMember> findAll(String type, Integer Page, Integer num) {
        return talkMemberService.findAll(type, Page, num);
    }

    @RequestMapping("findallcount")
    @ResponseBody
    public int findAllCount(String type) {
        return talkMemberService.findAllCount(type);
    }

    @RequestMapping("findbyid")
    @ResponseBody
    public TalkMember findById(Integer id) {
        return talkMemberService.findById(id);
    }

    @RequestMapping("findbycodeandtype")
    @ResponseBody
    public List<TalkMember> findByCodeAndType(String type, String code, Integer Page, Integer num) {
        return talkMemberService.findByCodeAndType(type, code, Page, num);
    }

    @RequestMapping("findbycodeandtypecount")
    @ResponseBody
    public int findByCodeAndTypeCount(String type, String code) {
        return talkMemberService.findByCodeAndTypeCount(type, code);
    }

    @RequestMapping("findbycode")
    @ResponseBody
    public List<TalkMember> findByCode(String code, Integer Page, Integer num) {
        return talkMemberService.findByCode(code, Page, num);
    }

    @RequestMapping("findbycodecount")
    @ResponseBody
    public int findByCodeCount(String code) {
        return talkMemberService.findByCodeCount(code);
    }

    @RequestMapping("findbyname")
    @ResponseBody
    public List<TalkMember> findByName(String type, String name, Integer Page, Integer num) {
        return talkMemberService.findByName(type, name, Page, num);
    }

    @RequestMapping("findbynamecount")
    @ResponseBody
    public int findByNameCount(String type, String name) {
        return talkMemberService.findByNameCount(type, name);
    }

    @RequestMapping("updatedata")
    public String updateData(TalkMember talkMember) {
        int i = talkMemberService.updateData(talkMember);
        if (i != 0) {
            return "redirect:这里改一下成功跳转地址";
        } else return "redirect:这里改一下失败跳转地址";
    }

    @RequestMapping("insertdata")
    public String insertData(TalkMember talkMember) {
        int i = talkMemberService.insertData(talkMember);
        if (i != 0) {
            return "redirect:地址";
        } else return "redirect:地址";
    }

    @RequestMapping("deletedata")
    @ResponseBody
    public Map<String, Object> deleteData(int id) {
        int i = talkMemberService.deleteData(id);
        HashMap<String, Object> map = new HashMap<>();
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
}
