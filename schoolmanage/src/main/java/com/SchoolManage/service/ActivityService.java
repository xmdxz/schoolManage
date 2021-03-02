package com.SchoolManage.service;

import com.SchoolManage.pojo.Activity;
import org.apache.ibatis.annotations.Param;

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
    List<Activity> findAll(String comy, Integer Page, Integer num);

    /**
     * 查询全部数量
     *
     * @return
     */
    int findAllCount(String comy);

    /**
     * 根据学生查询
     *
     * @param student
     * @return
     */
    List<Activity> findByStudentPage(String comy, String student, Integer Page, Integer num);

    /**
     * 根据学生查询，无分页
     *
     * @param student
     * @return
     */
    List<Activity> findByStudentNoPage(String comy, String student);

    /**
     * 根据学生查询数量
     *
     * @param student
     * @return
     */
    int findByStudentCount(String comy, String student);

    /**
     * 根据活动查询
     *
     * @param active
     * @return
     */
    List<Activity> findByActive(String comy, String active, Integer Page, Integer num);

    /**
     * 根据活动查询数量
     *
     * @param active
     * @return
     */
    int findByActiveCount(String comy, String active);

    /**
     * 根据年月日时间查询,活动的话，应该不会使用
     *
     * @param date
     * @return
     */
    List<Activity> findByTime(String comy, Date date, Integer Page, Integer num);

    /**
     * 根据年月日查询数量
     *
     * @param date
     * @return
     */
    int findByTimeCount(String comy, Date date);

    /**
     * 根据负责人查找
     *
     * @param responsible
     * @return
     */
    List<Activity> findByRes(String comy, String responsible, Integer Page, Integer num);

    /**
     * 根据负责人查询数量
     *
     * @param responsible
     * @return
     */
    int findByResCount(String comy, String responsible);

    /**
     * 根据年月查询
     *
     * @param Page
     * @param num
     * @return
     */
    List<Activity> findByTimeYearAndMonth(String comy, Date time, Integer Page, Integer num);

    /**
     * 根据年月查询数量
     *
     * @param time
     * @return
     */
    int findByTimeYearAndMonthCount(String comy, Date time);

    /**
     * 根据年查询
     *
     * @param time
     * @param Page
     * @param num
     * @return
     */
    List<Activity> findByTimeYear(String comy, Date time, Integer Page, Integer num);

    /**
     * 根据年查询数量
     *
     * @param time
     * @return
     */
    int findByTimeYearCount(String comy, Date time);

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


    /**
     * @Description: 根据id查询活动
     * @Param: [id]
     * @return: com.SchoolManage.pojo.Activity
     * @Author: RainGoal
     * @Date: 2021/2/18
     */
    Activity findById(int id);

    /**
     * 更新信息的
     */
    int updateData(@Param(value = "activity") Activity activity);

    /**
     * 批量添加学生
     */
    int BatchAddition(String path);

}
