package com.SchoolManage.service;

import com.SchoolManage.pojo.Activity;

import java.sql.Date;
import java.util.List;

/**
 * @Author RainGoal
 * @Date 2021/2/17 16:42
 * @Description TODO
 * @Version 1.0
 */

public interface ActivityService {

    /**
     * 查找全部
     *
     * @return
     */
    List<Activity> findAll();

    /**
     * 根据学生查询
     *
     * @param student
     * @return
     */
    List<Activity> findByStudent(String student);

    /**
     * 根据活动查询
     *
     * @param active
     * @return
     */
    List<Activity> findByActive(String active);

    /**
     * 根据时间查询
     *
     * @param date
     * @return
     */
    List<Activity> findByTime(Date date);

    /**
     * 插入单挑
     *
     * @param activity
     * @return
     */
    int insertAc(Activity activity);

    /**
     * 批量插入
     *
     * @param list
     * @return
     */
    int insertAcs(List<Activity> list);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteAc(Integer id);
}
