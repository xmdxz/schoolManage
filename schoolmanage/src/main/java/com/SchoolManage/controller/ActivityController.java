package com.SchoolManage.controller;

import com.SchoolManage.pojo.Activity;
import com.SchoolManage.service.ActivityService;
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
 * @Date 2021/2/17 16:48
 * @Description TODO
 * @Version 1.0
 */
@Controller
@RequestMapping("activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @RequestMapping("findall")
    @ResponseBody
    public List<Activity> findAll(int page, int num) {
        List<Activity> list = activityService.findAll(page, num);
        return list;
    }

    @RequestMapping("findallcount")
    @ResponseBody
    public int findAllCount() {
        int allCount = activityService.findAllCount();
        return allCount;
    }

    @RequestMapping("findbystudentpage")
    @ResponseBody
    public List<Activity> findByStudentPage(String student,
                                            int page,
                                            int num) {
        List<Activity> byStudentPage = activityService.findByStudentPage(student, page, num);
        return byStudentPage;
    }

    @RequestMapping("findByStudentNoPage")
    @ResponseBody
    public List<Activity> findByStudentNoPage(String student) {
        return activityService.findByStudentNoPage(student);
    }

    @RequestMapping("findbystudentcount")
    @ResponseBody
    public int findByStudentCount(String student) {
        return activityService.findByStudentCount(student);
    }

    @RequestMapping("findbyactive")
    @ResponseBody
    public List<Activity> findByActive(String active, Integer Page, Integer num) {
        return activityService.findByActive(active, Page, num);
    }

    @RequestMapping("findbyactivecount")
    @ResponseBody
    public Integer findByActiveCount(String active) {
        return activityService.findByActiveCount(active);
    }

    @RequestMapping("findbytime")
    @ResponseBody
    public List<Activity> findByTime(Date date, Integer Page, Integer num) {
        return activityService.findByTime(date, Page, num);
    }

    @RequestMapping("findbytimecount")
    @ResponseBody
    public int findByTimeCount(Date date) {
        return activityService.findByTimeCount(date);
    }

    @RequestMapping("findbytimeyearandmonthcount")
    @ResponseBody
    public List<Activity> findByTimeYearAndMonth(Date time, Integer Page, Integer num) {
        return activityService.findByTimeYearAndMonth(time, Page, num);
    }

    @RequestMapping("findbyres")
    @ResponseBody
    public List<Activity> findByRes(String responsible, Integer Page, Integer num) {
        return activityService.findByRes(responsible, Page, num);
    }

    @RequestMapping("findbyrescount")
    @ResponseBody
    public int findByResCount(String responsible) {
        return activityService.findByResCount(responsible);
    }

    @RequestMapping("findbytimeyear")
    @ResponseBody
    public List<Activity> findByTimeYear(Date time, Integer Page, Integer num) {
        return findByTimeYear(time, Page, num);
    }

    @RequestMapping("findbytimeyearcount")
    @ResponseBody
    public int findByTimeYearCount(Date time) {
        return activityService.findByTimeYearCount(time);
    }

    @RequestMapping("insertac")
    public String insertAc(Activity activity) {
        System.out.println(activity);
        int i = activityService.insertAc(activity);
        if (i != 0) {
            return "loginp_3";
        } else return "redirect:/activity.html";
    }

    @RequestMapping("deleteac")
    @ResponseBody
    public Map<String, Object> deleteAc(int id) {
        Map<String, Object> map = new HashMap<>();
        int i = activityService.deleteAc(id);
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
    public Activity findById(int id) {
        return activityService.findById(id);
    }
}

