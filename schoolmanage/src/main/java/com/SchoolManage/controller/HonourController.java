package com.SchoolManage.controller;

import com.SchoolManage.pojo.Honour;
import com.SchoolManage.service.HonourService;
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
 * @Date 2021/2/18 16:55
 * @Description TODO
 * @Version 1.0
 */
@Controller
@RequestMapping("honour")
public class HonourController {
    @Autowired
    private HonourService honourService;

    @RequestMapping("findall")
    @ResponseBody
    public List<Honour> findAll(Integer Page, Integer num) {
        return honourService.findAll(Page, num);
    }

    @RequestMapping("findallcount")
    @ResponseBody
    public int findAllCount() {
        return honourService.findAllCount();
    }

    @RequestMapping("findbystudentpage")
    @ResponseBody
    public List<Honour> findByStudentPage(String student, Integer Page, Integer num) {
        return honourService.findByStudentPage(student, Page, num);
    }

    @RequestMapping("findbystudentnopage")
    @ResponseBody
    public List<Honour> findByStudentNoPage(String student) {
        return honourService.findByStudentNoPage(student);
    }

    @RequestMapping("findbystudentcount")
    @ResponseBody
    public int findByStudentCount(String student) {
        return honourService.findByStudentCount(student);
    }

    @RequestMapping("findbytype")
    @ResponseBody
    public List<Honour> findByType(String Type, Integer Page, Integer num) {
        return honourService.findByType(Type, Page, num);
    }

    @RequestMapping("findbytypecount")
    @ResponseBody
    public int findByTypeCount(String type) {
        return honourService.findByTypeCount(type);
    }

    @RequestMapping("findbyprize")
    @ResponseBody
    public List<Honour> findByPrize(String prize, Integer Page, Integer num) {
        return honourService.findByPrize(prize, Page, num);
    }

    @RequestMapping("findbyprizecount")
    @ResponseBody
    public int findByPrizeCount(String prize) {
        return honourService.findByPrizeCount(prize);
    }

    @RequestMapping("findbytime")
    @ResponseBody
    public List<Honour> findByTime(Date time, Integer Page, Integer num) {
        return honourService.findByTime(time, Page, num);
    }

    @RequestMapping("findbytimecount")
    @ResponseBody
    public int findByTimeCount(Date time) {
        return honourService.findByTimeCount(time);
    }

    @RequestMapping("findbytimeyearandmonth")
    @ResponseBody
    public List<Honour> findByTimeYearAndMonth(Date time, Integer Page, Integer num) {
        return honourService.findByTimeYearAndMonth(time, Page, num);
    }

    @RequestMapping("findbytimeyearandmonthcount")
    @ResponseBody
    public int findByTimeYearAndMonthCount(Date time) {
        return honourService.findByTimeYearAndMonthCount(time);
    }

    @RequestMapping("findbytimeyear")
    @ResponseBody
    public List<Honour> findByTimeYear(Date time, Integer Page, Integer num) {
        return honourService.findByTimeYear(time, Page, num);
    }

    @RequestMapping("findbytimeyearcount")
    @ResponseBody
    public int findByTimeYearCount(Date time) {
        return honourService.findByTimeYearCount(time);
    }

    @RequestMapping("findbyconditions")
    @ResponseBody
    public List<Honour> findByConditions(Map<String, String> map, Integer Page, Integer num) {
        return honourService.findByConditions(map, Page, num);
    }

    @RequestMapping("inserthon")
    public String insertHon(Honour honour) {
        int i = honourService.insertHon(honour);
        if (i != 0) {
            return "redirect:改一下跳转的地址";
        } else return "redirect:改一下跳转的地址";
    }

    @RequestMapping("deletehon")
    @ResponseBody
    public Map<String, Object> deleteHon(int id) {
        Map<String, Object> map = new HashMap<>();
        int i = honourService.deleteHon(id);
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

    @RequestMapping("findbyid")
    @ResponseBody
    public Honour findById(int id) {
        return honourService.findById(id);
    }

    @RequestMapping("update")
    public String updateHonour(Honour honour) {
        int i = honourService.updateHonour(honour);
        if (i != 0) {
            return "redirect:跳转页面";
        } else return "redirect:跳转页面";
    }
}
