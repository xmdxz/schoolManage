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
     * 根据姓名查找
     *
     * @param name
     * @param startPage
     * @param num
     * @return
     */
    List<Honour> findByName(String comy, String name, Integer startPage, Integer num);

    /**
     * 姓名查找数量
     *
     * @param name
     * @return
     */
    int findByNameCount(String comy, String name);

    /**
     * 查找全部
     *
     * @return
     */
    List<Honour> findAll(String comy, Integer Page, Integer num);

    /**
     * 查找全部数量
     *
     * @return
     */
    int findAllCount(String comy);

    /**
     * 批量添加学生
     */
    int BatchAddition(String path);

    /**
     * 根据学生查找
     *
     * @param student
     * @return
     */

    List<Honour> findByStudentPage(String comy, String student, Integer Page, Integer num);

    /**
     * 根据学生查找 用于个人信息
     *
     * @param student
     * @return
     */
    List<Honour> findByStudentNoPage(String comy, String student);

    /**
     * 根据学生查询数量
     *
     * @return
     */
    int findByStudentCount(String comy, String student);

    /**
     * 、根据荣誉类型查找
     *
     * @param Type
     * @return
     */
    List<Honour> findByType(String comy, String Type, Integer Page, Integer num);

    /**
     * 根据荣誉类型查找数量
     *
     * @param type
     * @return
     */
    int findByTypeCount(String comy, String type);

    /**
     * 根据荣誉查找
     *
     * @param prize
     * @return
     */
    List<Honour> findByPrize(String comy, String prize, Integer Page, Integer num);

    /**
     * 根据荣誉查找数量
     *
     * @param prize
     * @return
     */
    int findByPrizeCount(String comy, String prize);

    /**
     * 根据日期模糊查询
     *
     * @param comy
     * @param date
     * @param startPage
     * @param num
     * @return
     */
    List<Honour> findByDate(String comy, Date date, Integer Page, Integer num);

    int findByDateCount(String comy, Date date);

    /**
     * 根据具体时间查找
     *
     * @param time
     * @return
     */
    List<Honour> findByTime(String comy, Date time, Integer Page, Integer num);

    /**
     * 根据具体时间查找数量
     *
     * @param time
     * @return
     */
    int findByTimeCount(String comy, Date time);

    /**
     * 根据年月查询
     *
     * @param time
     * @param Page
     * @param num
     * @return
     */
    List<Honour> findByTimeYearAndMonth(String comy, Date time, Integer Page, Integer num);

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
     * @return
     */
    List<Honour> findByTimeYear(String comy, Date time, Integer Page, Integer num);

    /**
     * 根据年查询数量
     *
     * @param time
     * @return
     */
    int findByTimeYearCount(String comy, Date time);

    /**
     * 、
     * 多条件查找
     *
     * @param map
     * @return
     */
    List<Honour> findByConditions(String comy, Map<String, String> map, Integer Page, Integer num);

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

    /**
     * @Author RainGoal
     * @Description 更新荣誉
     * @Param [honour]
     * @Return int
     * @Date 2021/2/23
     */
    int updateHonour(Honour honour);

    /**
     * @Author RainGoal
     * @Description 根据ID查询
     * @Param [id]
     * @Return com.SchoolManage.pojo.Honour
     * @Date 2021/2/23
     */
    Honour findById(int id);
}
