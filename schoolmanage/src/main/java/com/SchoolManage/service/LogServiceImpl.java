package com.SchoolManage.service;

import com.SchoolManage.dao.LogDao;
import com.SchoolManage.pojo.AdminUser;
import com.SchoolManage.pojo.Log;
import com.SchoolManage.pojo.Student;
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
    public int insertNew(String type, String message, String teacher, String student, String table) {
        Log log = new Log();
        log.setMessage(message);
        log.setOperation_student(student);
        log.setOperation_table(table);
        log.setOperation_teacher(teacher);
        log.setType(type);
        log.setTime(new Timestamp(new Date().getTime()));
        return logDao.insertLog(log);
    }

    @Override
    public List<Log> findAll(String comy, Integer page) {
        return logDao.findLog(comy, (page - 1) * 7);
    }

    @Override
    public List<Log> findLogByTime(String comy, Timestamp time) {
        return logDao.findLogByTime(comy, time);
    }

    @Override
    public List<Log> findLogByTimeYearAndMonth(String comy, Timestamp time) {
        return logDao.findLogByTimeYearAndMonth(comy, time);
    }

    @Override
    public List<Log> findLogByTimeYear(String comy, Timestamp time) {
        return logDao.findLogByTimeYear(comy, time);
    }

    @Override
    public List<Log> findLogByDate(String comy, Timestamp date) {
        return logDao.findLogByDate(comy, date);
    }

    @Override
    public List<Log> findLogByTeacher(String comy, AdminUser adminUser) {
        return logDao.findLogByTeacher(comy, adminUser);
    }

    @Override
    public List<Log> findLogByStudent(String comy, Student student) {
        return logDao.findLogByStudent(comy, student);
    }

    @Override
    public List<Log> findLogByTable(String comy, String table) {
        return logDao.findLogByTable(comy, table);
    }
}
