package com.SchoolManage.controller;

import com.SchoolManage.pojo.Qingjia;
import com.SchoolManage.service.QingJiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author RainGoal
 * @Date 2021/2/19 17:26
 * @Description TODO
 * @Version 1.0
 */
@Controller
@RequestMapping("QingJia")
public class QingJiaController {
    @Autowired
    private QingJiaService qingJiaService;

    @RequestMapping("findall")
    @ResponseBody
    public List<Qingjia> findAll(Integer Page, Integer num) {
        return qingJiaService.findAll(Page, num);
    }

    @RequestMapping("findallcount")
    @ResponseBody
    public int findAllCount() {
        return qingJiaService.findAllCount();
    }

    @RequestMapping("findbystudentnopage")
    @ResponseBody
    public List<Qingjia> findByStudentNoPage(String student) {
        return qingJiaService.findByStudentNoPage(student);
    }

    @RequestMapping("findbystudentpage")
    @ResponseBody
    public List<Qingjia> findByStudentPage(String student, Integer Page, Integer num) {
        return qingJiaService.findByStudentPage(student, Page, num);
    }

    @RequestMapping("findbystudentcount")
    @ResponseBody
    public int findByStudentCount(String student) {
        return qingJiaService.findByStudentCount(student);
    }

    @RequestMapping("findbytimeyearandmonthandday")
    @ResponseBody
    public List<Qingjia> findByTimeYearAndMonthAndDay(Timestamp timestamp, Integer Page, Integer num) {
        return qingJiaService.findByTimeYearAndMonthAndDay(timestamp, Page, num);
    }

    @RequestMapping("findbytimeyearandmonthanddaycount")
    @ResponseBody
    public int findByTimeYearAndMonthAndDayCount(Timestamp timestamp) {
        return qingJiaService.findByTimeYearAndMonthAndDayCount(timestamp);
    }

    @RequestMapping("findbytimeyearandmonth")
    @ResponseBody
    public List<Qingjia> findByTimeYearAndMonth(Timestamp timestamp, Integer Page, Integer num) {
        return qingJiaService.findByTimeYearAndMonth(timestamp, Page, num);
    }

    @RequestMapping("findbytimeyearandmonthcount")
    @ResponseBody
    public int findByTimeYearAndMonthCount(Timestamp timestamp) {
        return qingJiaService.findByTimeYearAndMonthCount(timestamp);
    }

    @RequestMapping("findbytimeyear")
    @ResponseBody
    public List<Qingjia> findByTimeYear(Timestamp timestamp, Integer Page, Integer num) {
        return qingJiaService.findByTimeYear(timestamp, Page, num);
    }

    @RequestMapping("findbytimeyearcount")
    @ResponseBody
    public int findByTimeYearCount(Timestamp timestamp) {
        return qingJiaService.findByTimeYearCount(timestamp);
    }

    @RequestMapping("findbyteacher")
    @ResponseBody
    public List<Qingjia> findByTeacher(String teacher, Integer Page, Integer num) {
        return qingJiaService.findByTeacher(teacher, Page, num);
    }

    @RequestMapping("insertqingjia")
    public String insertQingjia(Qingjia qingjia) {
        int i = qingJiaService.insertQingjia(qingjia);
        if (i != 0) {
            return "redirect:返回的页面";
        } else return "redirect:返回的页面";
    }

    @RequestMapping("delete")
    @ResponseBody
    public Map<String, Object> deleteQingJia(int id) {
        int i = qingJiaService.deleteQingjia(id);
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
