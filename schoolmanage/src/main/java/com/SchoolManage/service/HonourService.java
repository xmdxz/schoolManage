package com.SchoolManage.service;

import com.SchoolManage.pojo.Honour;

import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author RainGoal
 * @Date 2021/2/18 11:21
 * @Description TODO
 * @Version 1.0
 */

public interface HonourService {

    /**
     * 查找全部
     *
     * @return
     */
    List<Honour> findAll(Integer Page, Integer num);

    /**
     * 查找全部数量
     *
     * @return
     */
    int findAllCount();

    /**
     * 根据学生查找
     *
     * @param student
     * @return
     */
    List<Honour> findByStudentPage(String student, Integer Page, Integer num);

    /**
     * 根据学生查找 用于个人信息
     *
     * @param student
     * @return
     */
    List<Honour> findByStudentNoPage(String student);

    /**
     * 根据学生查询数量
     *
     * @return
     */
    int findByStudentCount(String student);

    /**
     * 、根据荣誉类型查找
     *
     * @param Type
     * @return
     */
    List<Honour> findByType(String Type, Integer Page, Integer num);

    /**
     * 根据荣誉类型查找数量
     *
     * @param type
     * @return
     */
    int findByTypeCount(String type);

    /**
     * 根据荣誉查找
     *
     * @param prize
     * @return
     */
    List<Honour> findByPrize(String prize, Integer Page, Integer num);

    /**
     * 根据荣誉查找数量
     *
     * @param prize
     * @return
     */
    int findByPrizeCount(String prize);

    /**
     * 根据具体时间查找
     *
     * @param time
     * @return
     */
    List<Honour> findByTime(Date time, Integer Page, Integer num);

    /**
     * 根据具体时间查找数量
     *
     * @param time
     * @return
     */
    int findByTimeCount(Date time);

    /**
     * 根据年月查询
     *
     * @param time
     * @param Page
     * @param num
     * @return
     */
    List<Honour> findByTimeYearAndMonth(Date time, Integer Page, Integer num);

    /**
     * 根据年月查询数量
     *
     * @param time
     * @return
     */
    int findByTimeYearAndMonthCount(Date time);

    /**
     * 根据年查询
     *
     * @param time
     * @return
     */
    List<Honour> findByTimeYear(Date time, Integer Page, Integer num);

    /**
     * 根据年查询数量
     *
     * @param time
     * @return
     */
    int findByTimeYearCount(Date time);

    /**
     * 、
     * 多条件查找
     *
     * @param map
     * @return
     */
    List<Honour> findByConditions(Map<String, String> map, Integer Page, Integer num);

    /**
     * 插入
     *
     * @param honour
     * @return
     */
    int insertHon(Honour honour);

    /**
     * 批量插入
     *
     * @param honours
     * @return
     */
    int insertHons(List<Honour> honours);

    /**
     * 、删除
     *
     * @param id
     * @return
     */
    int deleteHon(Integer id);
}
