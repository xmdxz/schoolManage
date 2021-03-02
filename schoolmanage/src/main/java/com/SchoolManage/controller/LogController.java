package com.SchoolManage.controller;

import com.SchoolManage.pojo.Log;
import com.SchoolManage.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
