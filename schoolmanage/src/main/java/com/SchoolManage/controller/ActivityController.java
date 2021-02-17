package com.SchoolManage.controller;

import com.SchoolManage.pojo.Activity;
import com.SchoolManage.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
    public List<Activity> findAll() {
        List<Activity> all = activityService.findAll();
        return all;
    }

}