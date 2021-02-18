package com.SchoolManage.service;

import com.SchoolManage.dao.ActivityDao;
import com.SchoolManage.pojo.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * @Author RainGoal
 * @Date 2021/2/17 16:43
 * @Description TODO
 * @Version 1.0
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityDao activityDao;


    @Override
    public List<Activity> findAll(Integer Page, Integer num) {
        return activityDao.findAll((Page - 1) * num, num);
    }

    @Override
    public int findAllCount() {
        return activityDao.findAllCount();
    }

    @Override
    public List<Activity> findByStudentPage(String student, Integer Page, Integer num) {
        return activityDao.findByStudentPage(student, (Page - 1) * num, num);
    }

    @Override
    public List<Activity> findByStudentNoPage(String student) {
        return activityDao.findByStudentNoPage(student);
    }

    @Override
    public int findByStudentCount(String student) {
        return activityDao.findByStudentCount(student);
    }

    @Override
    public List<Activity> findByActive(String active, Integer Page, Integer num) {
        return activityDao.findByActive(active, (Page - 1) * num, num);
    }

    @Override
    public int findByActiveCount(String active) {
        return activityDao.findByActiveCount(active);
    }

    @Override
    public List<Activity> findByTime(Date date, Integer Page, Integer num) {
        return activityDao.findByTime(date, (Page - 1) * num, num);
    }

    @Override
    public int findByTimeCount(Date date) {
        return activityDao.findByTimeCount(date);
    }

    @Override
    public List<Activity> findByRes(String responsible, Integer Page, Integer num) {
        return activityDao.findByRes(responsible, (Page - 1) * num, num);
    }

    @Override
    public int findByResCount(String responsible) {
        return activityDao.findByResCount(responsible);
    }


    @Override
    public List<Activity> findByTimeYearAndMonth(Date time, Integer Page, Integer num) {
        return activityDao.findByTimeYearAndMonth(time, (Page - 1) * num, num);
    }

    @Override
    public int findByTimeYearAndMonthCount(Date time) {
        return activityDao.findByTimeYearAndMonthCount(time);
    }

    @Override
    public List<Activity> findByTimeYear(Date time, Integer Page, Integer num) {
        return activityDao.findByTimeYear(time, (Page - 1) * num, num);
    }

    @Override
    public int findByTimeYearCount(Date time) {
        return activityDao.findByTimeYearCount(time);
    }

    @Override
    public int insertAc(Activity activity) {
        return activityDao.insertAc(activity);
    }

    @Override
    public int insertAcs(List<Activity> list) {
        return activityDao.insertAcs(list);
    }

    @Override
    public int deleteAc(Integer id) {
        return activityDao.deleteAc(id);
    }
}
