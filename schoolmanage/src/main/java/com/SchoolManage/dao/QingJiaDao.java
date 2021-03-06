package com.SchoolManage.dao;

import com.SchoolManage.pojo.Qingjia;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Mapper
@Repository
public interface QingJiaDao {

    /**
     * 根据姓名查找
     *
     * @param name
     * @param startPage
     * @param num
     * @return
     */
    List<Qingjia> findByName(@Param(value = "comy") String comy, @Param(value = "name") String name, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 姓名查找数量
     *
     * @param name
     * @return
     */
    int findByNameCount(@Param(value = "comy") String comy, @Param(value = "name") String name);

    /**
     * 根据班级查找
     *
     * @param clazz
     * @param startPage
     * @param num
     * @return
     */
    List<Qingjia> findByClazz(@Param(value = "comy") String comy, @Param(value = "clazz") String clazz, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 根据班级查找数量
     *
     * @param clazz
     * @return
     */
    int findByClazzCount(@Param(value = "comy") String comy, @Param(value = "clazz") String clazz);

    /**
     * 查询全部
     *
     * @param startPage
     * @param num
     * @return
     */
    List<Qingjia> findAll(@Param(value = "comy") String comy, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 查询全部数量
     *
     * @return
     */
    int findAllCount(@Param(value = "comy") String comy);

    /**
     * 根据学生查询，不分页，用于个人详情
     *
     * @param student
     * @return
     */
    List<Qingjia> findByStudentNoPage(@Param(value = "comy") String comy, @Param(value = "student") String student);

    /**
     * 根据学生查询 分页
     *
     * @param student
     * @param startPage
     * @param num
     * @return
     */
    List<Qingjia> findByStudentPage(@Param(value = "comy") String comy, @Param(value = "student") String student, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 根据学生查询总数
     *
     * @param student
     * @return
     */
    int findByStudentCount(@Param(value = "comy") String comy, @Param(value = "student") String student);

    /**
     * 根据年月日查询当天请假学生
     *
     * @param timestamp
     * @param startPage
     * @param num
     * @return
     */
    List<Qingjia> findByTimeYearAndMonthAndDay(@Param(value = "comy") String comy, @Param(value = "time") Timestamp timestamp, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 根据年月日查询当天请假学生总数
     *
     * @param timestamp
     * @return
     */
    int findByTimeYearAndMonthAndDayCount(@Param(value = "comy") String comy, @Param(value = "time") Timestamp timestamp);

    /**
     * 根据年月查询当月请假学生
     *
     * @param timestamp
     * @param startPage
     * @param num
     * @return
     */
    List<Qingjia> findByTimeYearAndMonth(@Param(value = "comy") String comy, @Param(value = "time") Timestamp timestamp, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 根据年月查询当月
     *
     * @param timestamp
     * @return
     */
    int findByTimeYearAndMonthCount(@Param(value = "comy") String comy, @Param(value = "time") Timestamp timestamp);

    /**
     * 根据年查询当年
     *
     * @param timestamp
     * @param startPage
     * @param num
     * @return
     */
    List<Qingjia> findByTimeYear(@Param(value = "comy") String comy, @Param(value = "time") Timestamp timestamp, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 根据年查询当年总数
     *
     * @param timestamp
     * @return
     */
    int findByTimeYearCount(@Param(value = "comy") String comy, @Param(value = "time") Timestamp timestamp);


    /**
     * 时间模糊查询
     *
     * @param timestamp
     * @param comy
     * @param startPage
     * @param num
     * @return
     */
    List<Qingjia> findByDate(@Param(value = "date") Timestamp timestamp, @Param(value = "comy") String comy, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 时间模糊查询
     *
     * @param timestamp
     * @param comy
     * @return
     */
    int findByDateCount(@Param(value = "date") Timestamp timestamp, @Param(value = "comy") String comy);

    /**
     * 根据教师查询
     *
     * @param teacher
     * @param startPage
     * @param num
     * @return
     */
    List<Qingjia> findByTeacher(@Param(value = "comy") String comy, @Param(value = "teacher") String teacher, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 插入
     *
     * @param qingjia
     * @return
     */
    int insertQingjia(@Param(value = "qingjia") Qingjia qingjia);

    /**
     * 批量插入
     *
     * @param list
     * @return
     */
    int insertQingjias(@Param(value = "list") List<Qingjia> list);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteQingjia(@Param(value = "id") Integer id);

    /**
     * @Author RainGoal
     * @Description
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
