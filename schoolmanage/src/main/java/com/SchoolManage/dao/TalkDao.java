package com.SchoolManage.dao;

import com.SchoolManage.pojo.Talk;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Mapper
@Repository
public interface TalkDao {

    /**
     * 查找全部
     *
     * @return
     */
    List<Talk> findAll(@Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num,@Param(value = "teacher") String teacher);

    /**
     * 查询总数
     *
     * @return
     */
    int findAllCount(@Param(value = "teacher") String teacher);

    /**
     * 插入谈话数据
     *
     * @param talk
     * @return
     */
    int insertTalk(@Param(value = "talk") Talk talk);

    /**
     * 根据学号查找,不分页，用于个人详细信息的展示
     *
     * @param student
     * @param teacher
     * @return
     */
    List<Talk> findByStudentNoPage(@Param(value = "student") String student,@Param(value = "teacher") String teacher);

    /**
     * 根据学号查找，分页，用于整个页面展示
     *
     * @param student
     * @param startPage
     * @param num
     * @param teacher
     * @return
     */
    List<Talk> findByStudentPage(@Param(value = "student") String student, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num,@Param(value = "teacher") String teacher);

    /**
     * 根据学号查询总数
     *
     * @param student
     * @param
     * @return
     */
    int findByStudentCount(@Param(value = "student") String student,@Param(value = "teacher") String teacher);

    /**
     * 根据教师查找
     *
     * @param teacher
     * @return
     */
    List<Talk> findByTeacher(@Param(value = "teacher") String teacher, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 删除谈话
     *
     * @param id
     * @param teacher
     * @return
     */
    int deleteTalk(@Param(value = "id") Integer id,@Param(value = "teacher") String teacher);

    /**
     * 批量插入
     *
     * @param list
     * @return
     */
    int insertAllTalk(@Param(value = "list") List<Talk> list);

    /**
     * 根据具体时间查找，也就是某一天
     *
     * @param date
     * @return
     */
    List<Talk> findByTime(@Param(value = "time") Date date, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 根据具体时间查找数量，某一天
     *
     * @param date
     * @param teacher
     * @return
     */
    int findByTimeCount(@Param(value = "time") Date date,@Param(value = "teacher") String teacher);

    /**
     * 根据年月查找，也就是某一月
     *
     * @param date
     * @param startPage
     * @param num
     * @return
     */
    List<Talk> findByTimeYearAndMonth(@Param(value = "time") Date date, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 根据年月查找数量，也就是某一月
     *
     * @param date
     * @return
     */
    int findByTimeYearAndMonthCount(@Param(value = "time") Date date);
    /**
     * 根据id查找
     * @param id
     * @return
     */
    Talk findById(@Param(value = "id")Integer id);
}
