package com.SchoolManage.controller;

import com.SchoolManage.pojo.AdminUser;
import com.SchoolManage.pojo.Log;
import com.SchoolManage.pojo.Student;
import com.SchoolManage.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("log")
public class LogController {
    @Autowired
    private LogService logService;

    @RequestMapping("all")
    @ResponseBody
    public List<Log> findAll(String comy, Integer page) {
        return logService.findAll(comy, page);
    }

    @RequestMapping("findlogbytime")
    @ResponseBody
    public List<Log> findLogByTime(String comy, Timestamp time) {
        return logService.findLogByTime(comy, time);
    }

    @RequestMapping("findlogbytimeyearandmonth")
    @ResponseBody
    public List<Log> findLogByTimeYearAndMonth(String comy, Timestamp time) {
        return logService.findLogByTimeYearAndMonth(comy, time);
    }

    @RequestMapping("findlogbytimeyear")
    @ResponseBody
    public List<Log> findLogByTimeYear(String comy, Timestamp time) {
        return logService.findLogByTimeYear(comy, time);
    }

    @RequestMapping("findlogbydate")
    @ResponseBody
    public List<Log> findLogByDate(String comy, Timestamp date) {
        return logService.findLogByDate(comy, date);
    }

    @RequestMapping("findlogbyteacher")
    @ResponseBody
    public List<Log> findLogByTeacher(String comy, AdminUser adminUser) {
        return logService.findLogByTeacher(comy, adminUser);
    }

    @RequestMapping("findlogbystudent")
    @ResponseBody
    public List<Log> findLogByStudent(String comy, Student student) {
        return logService.findLogByStudent(comy, student);
    }

    @RequestMapping("findlogbytable")
    @ResponseBody
    public List<Log> findLogByTable(String comy, String table) {
        return logService.findLogByTable(comy, table);
    }
}
