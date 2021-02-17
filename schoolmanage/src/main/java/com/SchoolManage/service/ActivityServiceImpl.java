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
    public List<Activity> findAll() {
        return activityDao.findAll();
    }

    @Override
    public List<Activity> findByStudent(String student) {
        return activityDao.findByStudent(student);
    }

    @Override
    public List<Activity> findByActive(String active) {
        return activityDao.findByActive(active);
    }

    @Override
    public List<Activity> findByTime(Date date) {
        return activityDao.findByTime(date);
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
