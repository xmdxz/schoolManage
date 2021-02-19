package com.SchoolManage.service;

import com.SchoolManage.pojo.Talk;

import java.sql.Date;
import java.util.List;

/**
 * @Author RainGoal
 * @Date 2021/2/19 11:53
 * @Description TODO
 * @Version 1.0
 */

public interface TalkService {
    /**
     * 查找全部
     *
     * @return
     */
    List<Talk> findAll(Integer Page, Integer num);

    /**
     * 查询总数
     *
     * @return
     */
    int findAllCount();

    /**
     * 插入谈话数据
     *
     * @param talk
     * @return
     */
    int insertTalk(Talk talk);

    /**
     * 根据学号查找,不分页，用于个人详细信息的展示
     *
     * @param student
     * @return
     */
    List<Talk> findByStudentNoPage(String student);

    /**
     * 根据学号查找，分页，用于整个页面展示
     *
     * @param student
     * @param Page
     * @param num
     * @return
     */
    List<Talk> findByStudentPage(String student, Integer Page, Integer num);

    /**
     * 根据学号查询总数
     *
     * @param student
     * @return
     */
    int findByStudentCount(String student);

    /**
     * 根据教师查找
     *
     * @param teacher
     * @return
     */
    List<Talk> findByTeacher(String teacher, Integer Page, Integer num);

    /**
     * 删除谈话
     *
     * @param id
     * @return
     */
    int deleteTalk(Integer id);

    /**
     * 批量插入
     *
     * @param list
     * @return
     */
    int insertAllTalk(List<Talk> list);

    /**
     * 根据具体时间查找，也就是某一天
     *
     * @param date
     * @return
     */
    List<Talk> findByTime(Date date, Integer Page, Integer num);

    /**
     * 根据具体时间查找数量，某一天
     *
     * @param date
     * @return
     */
    int findByTimeCount(Date date);

    /**
     * 根据年月查找，也就是某一月
     *
     * @param date
     * @param Page
     * @param num
     * @return
     */
    List<Talk> findByTimeYearAndMonth(Date date, Integer Page, Integer num);

    /**
     * 根据年月查找数量，也就是某一月
     *
     * @param date
     * @return
     */
    int findByTimeYearAndMonthCount(Date date);
}
