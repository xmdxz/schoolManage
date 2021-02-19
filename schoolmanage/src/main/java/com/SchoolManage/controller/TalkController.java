package com.SchoolManage.controller;

import com.SchoolManage.pojo.Talk;
import com.SchoolManage.service.TalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author RainGoal
 * @Date 2021/2/19 12:04
 * @Description TODO
 * @Version 1.0
 */
@Controller
@RequestMapping("talk")
public class TalkController {
    @Autowired
    private TalkService talkService;

    @RequestMapping("findall")
    @ResponseBody
    public List<Talk> findAll(Integer Page, Integer num) {
        return talkService.findAll(Page, num);
    }

    @RequestMapping("findallcount")
    @ResponseBody
    public int findAllCount() {
        return talkService.findAllCount();
    }

    @RequestMapping("inserttalk")
    public String insertTalk(Talk talk) {
        int i = talkService.insertTalk(talk);
        if (i != 0) {
            return "redirect:改变地址";
        } else return "redirect:改变地址";
    }

    @RequestMapping("findbystudentnopage")
    @ResponseBody
    public List<Talk> findByStudentNoPage(String student) {
        return talkService.findByStudentNoPage(student);
    }

    @RequestMapping("findbystudentpage")
    @ResponseBody
    public List<Talk> findByStudentPage(String student, Integer Page, Integer num) {
        return talkService.findByStudentPage(student, Page, num);
    }

    @RequestMapping("findbystudentcount")
    @ResponseBody
    public int findByStudentCount(String student) {
        return talkService.findByStudentCount(student);
    }

    @RequestMapping("findbyteacher")
    @ResponseBody
    public List<Talk> findByTeacher(String teacher, Integer Page, Integer num) {
        return talkService.findByTeacher(teacher, Page, num);
    }

    @RequestMapping("deletetalk")
    @ResponseBody
    public Map<String, Object> deleteTalk(Integer id) {
        int i = talkService.deleteTalk(id);
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

    @RequestMapping("findbytime")
    @ResponseBody
    public List<Talk> findByTime(Date date, Integer Page, Integer num) {
        return talkService.findByTime(date, Page, num);
    }

    @RequestMapping("findbytimecount")
    @ResponseBody
    public int findByTimeCount(Date date) {
        return talkService.findByTimeCount(date);
    }

    @RequestMapping("findbytimeyearandmonth")
    @ResponseBody
    public List<Talk> findByTimeYearAndMonth(Date date, Integer Page, Integer num) {
        return talkService.findByTimeYearAndMonth(date, Page, num);
    }

    @RequestMapping("findbytimeyearandmonthcount")
    @ResponseBody
    public int findByTimeYearAndMonthCount(Date date) {
        return talkService.findByTimeYearAndMonthCount(date);
    }
}
