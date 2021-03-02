package com.SchoolManage.service;

import com.SchoolManage.dao.ActivityDao;
import com.SchoolManage.exception.FieldNotExistException;
import com.SchoolManage.pojo.Activity;
import com.SchoolManage.util.TableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
    public List<Activity> findAll(String comy, Integer Page, Integer num) {
        return activityDao.findAll(comy, (Page - 1) * num, num);
    }

    @Override
    public int findAllCount(String comy) {
        return activityDao.findAllCount(comy);
    }

    @Override
    public List<Activity> findByStudentPage(String comy, String student, Integer Page, Integer num) {
        return activityDao.findByStudentPage(comy, student, (Page - 1) * num, num);
    }

    @Override
    public List<Activity> findByStudentNoPage(String comy, String student) {
        return activityDao.findByStudentNoPage(comy, student);
    }

    @Override
    public int findByStudentCount(String comy, String student) {
        return activityDao.findByStudentCount(comy, student);
    }

    @Override
    public List<Activity> findByActive(String comy, String active, Integer Page, Integer num) {
        return activityDao.findByActive(comy, active, (Page - 1) * num, num);
    }

    @Override
    public int findByActiveCount(String comy, String active) {
        return activityDao.findByActiveCount(comy, active);
    }

    @Override
    public List<Activity> findByTime(String comy, Date date, Integer Page, Integer num) {
        return activityDao.findByTime(comy, date, (Page - 1) * num, num);
    }

    @Override
    public int findByTimeCount(String comy, Date date) {
        return activityDao.findByTimeCount(comy, date);
    }

    @Override
    public List<Activity> findByRes(String comy, String responsible, Integer Page, Integer num) {
        return activityDao.findByRes(comy, responsible, (Page - 1) * num, num);
    }

    @Override
    public int findByResCount(String comy, String responsible) {
        return activityDao.findByResCount(comy, responsible);
    }


    @Override
    public List<Activity> findByTimeYearAndMonth(String comy, Date time, Integer Page, Integer num) {
        return activityDao.findByTimeYearAndMonth(comy, time, (Page - 1) * num, num);
    }

    @Override
    public int findByTimeYearAndMonthCount(String comy, Date time) {
        return activityDao.findByTimeYearAndMonthCount(comy, time);
    }

    @Override
    public List<Activity> findByTimeYear(String comy, Date time, Integer Page, Integer num) {
        return activityDao.findByTimeYear(comy, time, (Page - 1) * num, num);
    }

    @Override
    public int findByTimeYearCount(String comy, Date time) {
        return activityDao.findByTimeYearCount(comy, time);
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

    @Override
    public Activity findById(int id) {
        return activityDao.findById(id);
    }

    @Override
    public int updateData(Activity activity) {
        return activityDao.updateData(activity);
    }

    @Override
    public int BatchAddition(String path) {
        int num = 0;
        try {
            //path写实际path
            TableUtil<Activity> tableUtil = new TableUtil<Activity>(path, Activity.class);
            List<Activity> list = tableUtil.GetTableRowContent();
            //调用插入接口
            //批量上传，list集合
            num = activityDao.insertAcs(list);
        } catch (IOException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchFieldException e) {
            e.printStackTrace();
            return -2;
        } catch (FieldNotExistException e) {
            //此处应处理表格问题，返回前端
            e.printStackTrace();
            return -3;
        }
        return num;

    }
}
