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
    List<Talk> findAll(String comy);


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
    List<Talk> findByStudent(String student);

    /**
     * 模糊查询时间
     *
     * @param date
     * @return
     */
    List<Talk> findByDate(Date date);


    /**
     * 查询学生一共的谈话次数
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
    List<Talk> findByTeacher(String comy, String teacher);

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
    List<Talk> findByTime(String comy, Date date);

    /**
     * 根据年月查找，也就是某一月
     *
     * @param date
     * @return
     */
    List<Talk> findByTimeYearAndMonth(String comy, Date date);


    /**
     * 根据年
     *
     * @param comy
     * @param date
     * @return
     */
    List<Talk> findByTimeYear(String comy, Date date);


    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    Talk findById(Integer id);

    /**
     * 根据类型查询
     *
     * @param types
     * @return
     */
    List<Talk> findByTypes(String types);


    /**
     * 三者查询
     *
     * @param time
     * @param types
     * @param level
     * @param comy
     * @return
     */
    List<Talk> findByDateAndTypesAndLevel(Date time, String types, String level, String comy);

    /**
     * 更新
     *
     * @param talk
     * @return
     */
    int updata(Talk talk);
}
