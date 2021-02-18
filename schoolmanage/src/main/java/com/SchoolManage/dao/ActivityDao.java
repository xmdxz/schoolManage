package com.SchoolManage.dao;

import com.SchoolManage.pojo.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Mapper
@Repository
public interface ActivityDao {


    /**
     * 查找全部
     *
     * @return
     */
    List<Activity> findAll(@Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 查询全部数量
     *
     * @return
     */
    int findAllCount();

    /**
     * 根据学生查询
     *
     * @param student
     * @return
     */
    List<Activity> findByStudentPage(@Param(value = "student") String student, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 根据学生查询，无分页
     *
     * @param student
     * @return
     */
    List<Activity> findByStudentNoPage(@Param(value = "student") String student);

    /**
     * 根据学生查询数量
     *
     * @param student
     * @return
     */
    int findByStudentCount(@Param(value = "student") String student);

    /**
     * 根据活动查询
     *
     * @param active
     * @return
     */
    List<Activity> findByActive(@Param(value = "active") String active, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 根据活动查询数量
     *
     * @param active
     * @return
     */
    int findByActiveCount(@Param(value = "active") String active);

    /**
     * 根据年月日时间查询,活动的话，应该不会使用
     *
     * @param date
     * @return
     */
    List<Activity> findByTime(@Param(value = "time") Date date, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 根据年月日查询数量
     *
     * @param date
     * @return
     */
    int findByTimeCount(@Param(value = "time") Date date);

    /**
     * 根据负责人查找
     *
     * @param responsible
     * @return
     */
    List<Activity> findByRes(@Param(value = "responsible") String responsible, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 根据负责人查询数量
     *
     * @param responsible
     * @return
     */
    int findByResCount(@Param(value = "responsible") String responsible);

    /**
     * 根据年月查询
     *
     * @param startPage
     * @param num
     * @return
     */
    List<Activity> findByTimeYearAndMonth(@Param(value = "time") Date time, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 根据年月查询数量
     *
     * @param time
     * @return
     */
    int findByTimeYearAndMonthCount(@Param(value = "time") Date time);

    /**
     * 根据年查询
     *
     * @param time
     * @param startPage
     * @param num
     * @return
     */
    List<Activity> findByTimeYear(@Param(value = "time") Date time, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 根据年查询数量
     *
     * @param time
     * @return
     */
    int findByTimeYearCount(@Param(value = "time") Date time);

    /**
     * 插入单挑
     *
     * @param activity
     * @return
     */
    int insertAc(@Param(value = "activity") Activity activity);

    /**
     * 批量插入
     *
     * @param list
     * @return
     */
    int insertAcs(@Param(value = "list") List<Activity> list);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteAc(@Param(value = "id") Integer id);


    /**
     * @Description: 根据id查询活动
     * @Param: [id]
     * @return: com.SchoolManage.pojo.Activity
     * @Author: RainGoal
     * @Date: 2021/2/18
     */
    Activity findById(@Param("id") int id);

}
