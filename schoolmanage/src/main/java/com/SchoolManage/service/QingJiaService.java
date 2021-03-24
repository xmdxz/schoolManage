package com.SchoolManage.service;

import com.SchoolManage.pojo.Qingjia;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * @Author RainGoal
 * @Date 2021/2/19 17:10
 * @Description TODO
 * @Version 1.0
 */

public interface QingJiaService {


    /**
     * 根据班级查找
     *
     * @param clazz
     * @param Page
     * @param num
     * @return
     */
    List<Qingjia> findByClazz(String comy, String clazz, Integer Page, Integer num);

    /**
     * 根据班级查找数量
     *
     * @param clazz
     * @return
     */
    int findByClazzCount(String comy, String clazz);


    /**
     * 查询全部
     *
     * @param Page
     * @param num
     * @return
     */
    List<Qingjia> findAll(String comy, Integer Page, Integer num);

    /**
     * 查询全部数量
     *
     * @return
     */
    int findAllCount(String comy);

    /**
     * 根据学生查询，不分页，用于个人详情
     *
     * @param student
     * @return
     */
    List<Qingjia> findByStudentNoPage(String comy, String student);

    /**
     * 根据学生查询 分页
     *
     * @param student
     * @param Page
     * @param num
     * @return
     */
    List<Qingjia> findByStudentPage(String comy, String student, Integer Page, Integer num);

    /**
     * 根据学生查询总数
     *
     * @param student
     * @return
     */
    int findByStudentCount(String comy, String student);

    /**
     * 根据年月日查询当天请假学生
     *
     * @param timestamp
     * @param Page
     * @param num
     * @return
     */
    List<Qingjia> findByTimeYearAndMonthAndDay(String comy, Timestamp timestamp, Integer Page, Integer num);

    /**
     * 根据年月日查询当天请假学生总数
     *
     * @param timestamp
     * @return
     */
    int findByTimeYearAndMonthAndDayCount(String comy, Timestamp timestamp);

    /**
     * 根据年月查询当月请假学生
     *
     * @param timestamp
     * @param Page
     * @param num
     * @return
     */
    List<Qingjia> findByTimeYearAndMonth(String comy, Timestamp timestamp, Integer Page, Integer num);

    /**
     * 根据年月查询当月
     *
     * @param timestamp
     * @return
     */
    int findByTimeYearAndMonthCount(String comy, Timestamp timestamp);

    /**
     * 根据年查询当年
     *
     * @param timestamp
     * @param Page
     * @param num
     * @return
     */
    List<Qingjia> findByTimeYear(String comy, Timestamp timestamp, Integer Page, Integer num);

    /**
     * 根据年查询当年总数
     *
     * @param timestamp
     * @return
     */
    int findByTimeYearCount(String comy, Timestamp timestamp);

    /**
     * 时间模糊查询
     *
     * @param timestamp
     * @param comy
     * @param Page
     * @param num
     * @return
     */
    List<Qingjia> findByDate(Timestamp timestamp, String comy, Integer Page, Integer num);

    /**
     * 时间模糊查询
     *
     * @param timestamp
     * @param comy
     * @return
     */
    int findByDateCount(Timestamp timestamp, String comy);


    /**
     * 根据教师查询
     *
     * @param teacher
     * @param Page
     * @param num
     * @return
     */
    List<Qingjia> findByTeacher(String comy, String teacher, Integer Page, Integer num);

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
     * @param Page
     * @param num
     * @return
     */
    List<Qingjia> findByName(String comy, String name, Integer Page, Integer num);

    /**
     * 姓名查找数量
     *
     * @param name
     * @return
     */
    int findByNameCount(String comy, String name);

    /**
     * 批量添加学生
     */
    int BatchAddition(String path, String comy);

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
    int findByNow_time(String comy);
    Map<String, List<Qingjia>> findBYweek_time(String comy);
    List<Qingjia> findBystart_time(String comy, String time,String time1,Integer Page, Integer num);
    List<Qingjia> findByend_time(String comy, String time,Integer Page, Integer num);
    int findBystart_timeCount(String comy, String time,String time1);
    int findByend_timeCount(String comy, String time);

}
