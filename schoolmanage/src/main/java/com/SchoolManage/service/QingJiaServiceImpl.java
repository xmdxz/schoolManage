package com.SchoolManage.service;

import com.SchoolManage.dao.QingJiaDao;
import com.SchoolManage.pojo.Qingjia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author RainGoal
 * @Date 2021/2/19 17:12
 * @Description TODO
 * @Version 1.0
 */
@Service
public class QingJiaServiceImpl implements QingJiaService {
    @Autowired
    private QingJiaDao qingJiaDao;


    @Override
    public List<Qingjia> findAll(Integer Page, Integer num) {
        return qingJiaDao.findAll((Page - 1) * num, num);
    }

    @Override
    public int findAllCount() {
        return qingJiaDao.findAllCount();
    }

    @Override
    public List<Qingjia> findByStudentNoPage(String student) {
        return qingJiaDao.findByStudentNoPage(student);
    }

    @Override
    public List<Qingjia> findByStudentPage(String student, Integer Page, Integer num) {
        return qingJiaDao.findByStudentPage(student, (Page - 1) * num, num);
    }

    @Override
    public int findByStudentCount(String student) {
        return qingJiaDao.findByStudentCount(student);
    }

    @Override
    public List<Qingjia> findByTimeYearAndMonthAndDay(Timestamp timestamp, Integer Page, Integer num) {
        return qingJiaDao.findByTimeYearAndMonthAndDay(timestamp, (Page - 1) * num, num);
    }

    @Override
    public int findByTimeYearAndMonthAndDayCount(Timestamp timestamp) {
        return qingJiaDao.findByTimeYearAndMonthAndDayCount(timestamp);
    }

    @Override
    public List<Qingjia> findByTimeYearAndMonth(Timestamp timestamp, Integer Page, Integer num) {
        return qingJiaDao.findByTimeYearAndMonth(timestamp, (Page - 1) * num, num);
    }

    @Override
    public int findByTimeYearAndMonthCount(Timestamp timestamp) {
        return qingJiaDao.findByTimeYearAndMonthCount(timestamp);
    }

    @Override
    public List<Qingjia> findByTimeYear(Timestamp timestamp, Integer Page, Integer num) {
        return qingJiaDao.findByTimeYear(timestamp, (Page - 1) * num, num);
    }

    @Override
    public int findByTimeYearCount(Timestamp timestamp) {
        return qingJiaDao.findByTimeYearCount(timestamp);
    }

    @Override
    public List<Qingjia> findByTeacher(String teacher, Integer Page, Integer num) {
        return qingJiaDao.findByTeacher(teacher, (Page - 1) * num, num);
    }

    @Override
    public int insertQingjia(Qingjia qingjia) {
        return qingJiaDao.insertQingjia(qingjia);
    }

    @Override
    public int insertQingjias(List<Qingjia> list) {
        return qingJiaDao.insertQingjias(list);
    }

    @Override
    public int deleteQingjia(Integer id) {
        return qingJiaDao.deleteQingjia(id);
    }
}
