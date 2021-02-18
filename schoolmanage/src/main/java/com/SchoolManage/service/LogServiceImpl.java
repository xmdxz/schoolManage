package com.SchoolManage.service;

import com.SchoolManage.dao.LogDao;
import com.SchoolManage.pojo.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;

    @Override
    public int insertNew(String type,String message,String teacher,String student,String table) {
        Log log =new Log();
        log.setMessage(message);
        log.setOperation_student(student);
        log.setOperation_table(table);
        log.setOperation_teacher(teacher);
        log.setType(type);
        log.setTime(new Timestamp(new Date().getTime()));
        return logDao.insertLog(log) ;
    }

    @Override
    public List<Log> findAll(Integer page) {
        return logDao.findLog((page-1)*7);
    }
}
