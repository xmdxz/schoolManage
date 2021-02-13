package com.SchoolManage.controller;

import com.SchoolManage.pojo.Logs;
import com.SchoolManage.service.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("logs")
public class LogsController {
    @Autowired
    private  LogsService logsService;


    @RequestMapping("all")
    @ResponseBody
    public List<Logs> findAll(HttpServletRequest request) {
        return logsService.findAll();
    }

    @RequestMapping("new")
    @ResponseBody
    public  int Insertnew(String title, Timestamp start,Timestamp end,String className){
        Logs logs=new Logs();
        logs.setClassName(className);
        logs.setEnd(end);
        logs.setStart(start);
        logs.setTitle(title);
        logsService.insertLogs(logs);
        return logs.getId();
    }
    @RequestMapping("delect")
    @ResponseBody
    public String delectLogs(Integer id){
        int i =logsService.delectLogs(id);
        if (i ==1)
            return "success";
        else return "fail";
    }
    @RequestMapping("updata")
    @ResponseBody
    public String updataLogs(Integer id,String title, Timestamp start,Timestamp end,String className){
        System.out.println("开始更新！");
        Logs logs=new Logs();
        logs.setClassName(className);
        logs.setEnd(end);
        logs.setStart(start);
        logs.setTitle(title);
        logs.setId(id);
        int i =logsService.updataLogs(logs);
        if (i ==1)
            return "success";
        else return "fail";
    }

    @RequestMapping("findById")
    @ResponseBody
    public Logs findById(Integer id){
        return logsService.findById(id);
    }
}
