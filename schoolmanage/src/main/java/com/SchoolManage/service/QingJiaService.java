package com.SchoolManage.service;

import com.SchoolManage.pojo.Qingjia;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author RainGoal
 * @Date 2021/2/19 17:10
 * @Description TODO
 * @Version 1.0
 */

public interface QingJiaService {
    /**
     * 查询全部
     *
     * @param Page
     * @param num
     * @return
     */
    List<Qingjia> findAll(Integer Page, Integer num);

    /**
     * 查询全部数量
     *
     * @return
     */
    int findAllCount();

    /**
     * 根据学生查询，不分页，用于个人详情
     *
     * @param student
     * @return
     */
    List<Qingjia> findByStudentNoPage(String student);

    /**
     * 根据学生查询 分页
     *
     * @param student
     * @param Page
     * @param num
     * @return
     */
    List<Qingjia> findByStudentPage(String student, Integer Page, Integer num);

    /**
     * 根据学生查询总数
     *
     * @param student
     * @return
     */
    int findByStudentCount(String student);

    /**
     * 根据年月日查询当天请假学生
     *
     * @param timestamp
     * @param Page
     * @param num
     * @return
     */
    List<Qingjia> findByTimeYearAndMonthAndDay(Timestamp timestamp, Integer Page, Integer num);

    /**
     * 根据年月日查询当天请假学生总数
     *
     * @param timestamp
     * @return
     */
    int findByTimeYearAndMonthAndDayCount(Timestamp timestamp);

    /**
     * 根据年月查询当月请假学生
     *
     * @param timestamp
     * @param Page
     * @param num
     * @return
     */
    List<Qingjia> findByTimeYearAndMonth(Timestamp timestamp, Integer Page, Integer num);

    /**
     * 根据年月查询当月
     *
     * @param timestamp
     * @return
     */
    int findByTimeYearAndMonthCount(Timestamp timestamp);

    /**
     * 根据年查询当年
     *
     * @param timestamp
     * @param Page
     * @param num
     * @return
     */
    List<Qingjia> findByTimeYear(Timestamp timestamp, Integer Page, Integer num);

    /**
     * 根据年查询当年总数
     *
     * @param timestamp
     * @return
     */
    int findByTimeYearCount(Timestamp timestamp);

    /**
     * 根据教师查询
     *
     * @param teacher
     * @param Page
     * @param num
     * @return
     */
    List<Qingjia> findByTeacher(String teacher, Integer Page, Integer num);

    /**
     * 插入
     *
     * @param qingjia
     * @return
     */
    int insertQingjia(Qingjia qingjia);

    /**
     * 批量插入
     *
     * @param list
     * @return
     */
    int insertQingjias(List<Qingjia> list);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteQingjia(Integer id);

    /**
     * 根据姓名查找
     *
     * @param name
     * @param startPage
     * @param num
     * @return
     */
    List<Qingjia> findByName(String name, Integer startPage, Integer num);

    /**
     * 姓名查找数量
     *
     * @param name
     * @return
     */
    int findByNameCount(String name);

    /**
     * 批量添加学生
     */
    int BatchAddition(String path);

    /**
     * @Author RainGoal
     * @Description 更新请假
     * @Param [qingjia]
     * @Return int
     * @Date 2021/2/22
     */
    int updateQingJia(Qingjia qingjia);

    /**
     * @Author RainGoal
     * @Description 根据id查询
     * @Param [id]
     * @Return com.SchoolManage.pojo.Qingjia
     * @Date 2021/2/23
     */
    Qingjia findById(int id);
}
