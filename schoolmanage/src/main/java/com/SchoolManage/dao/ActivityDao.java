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
    List<Activity> findAll();

    /**
     * 根据学生查询
     *
     * @param student
     * @return
     */
    List<Activity> findByStudent(@Param(value = "student") String student);

    /**
     * 根据活动查询
     *
     * @param active
     * @return
     */
    List<Activity> findByActive(@Param(value = "active") String active);

    /**
     * 根据时间查询
     *
     * @param date
     * @return
     */
    List<Activity> findByTime(@Param(value = "time") Date date);

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
}
