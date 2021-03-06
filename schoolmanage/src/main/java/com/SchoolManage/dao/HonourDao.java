package com.SchoolManage.dao;

import com.SchoolManage.pojo.Honour;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface HonourDao {

    /**
     * 根据姓名查找
     *
     * @param name
     * @param startPage
     * @param num
     * @return
     */
    List<Honour> findByName(@Param(value = "comy") String comy, @Param(value = "name") String name, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 姓名查找数量
     *
     * @param name
     * @return
     */
    int findByNameCount(@Param(value = "comy") String comy, @Param(value = "name") String name);

    /**
     * 查找全部
     *
     * @return
     */
    List<Honour> findAll(@Param(value = "comy") String comy, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 查找全部数量
     *
     * @return
     */
    int findAllCount(@Param(value = "comy") String comy);

    /**
     * 根据学生查找
     *
     * @param student
     * @return
     */
    List<Honour> findByStudentPage(@Param(value = "comy") String comy, @Param(value = "student") String student, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 根据学生查找 用于个人信息
     *
     * @param student
     * @return
     */
    List<Honour> findByStudentNoPage(@Param(value = "comy") String comy, @Param(value = "student") String student);

    /**
     * 根据学生查询数量
     *
     * @return
     */
    int findByStudentCount(@Param(value = "comy") String comy, @Param(value = "student") String student);

    /**
     * 、根据荣誉类型查找
     *
     * @param Type
     * @return
     */
    List<Honour> findByType(@Param(value = "comy") String comy, @Param(value = "type") String Type, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 根据荣誉类型查找数量
     *
     * @param type
     * @return
     */
    int findByTypeCount(@Param(value = "comy") String comy, @Param(value = "type") String type);

    /**
     * 根据荣誉查找
     *
     * @param prize
     * @return
     */
    List<Honour> findByPrize(@Param(value = "comy") String comy, @Param(value = "prize") String prize, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 根据荣誉查找数量
     *
     * @param prize
     * @return
     */
    int findByPrizeCount(@Param(value = "comy") String comy, @Param(value = "prize") String prize);

    /**
     * 根据日期模糊查询
     *
     * @param comy
     * @param date
     * @param startPage
     * @param num
     * @return
     */
    List<Honour> findByDate(@Param(value = "comy") String comy, @Param(value = "date") Date date, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    int findByDateCount(@Param(value = "comy") String comy, @Param(value = "date") Date date);

    /**
     * 根据具体时间查找
     *
     * @param time
     * @return
     */
    List<Honour> findByTime(@Param(value = "comy") String comy, @Param(value = "time") Date time, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 根据具体时间查找数量
     *
     * @param time
     * @return
     */
    int findByTimeCount(@Param(value = "comy") String comy, @Param(value = "time") Date time);

    /**
     * 根据年月查询
     *
     * @param time
     * @param startPage
     * @param num
     * @return
     */
    List<Honour> findByTimeYearAndMonth(@Param(value = "comy") String comy, @Param(value = "time") Date time, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 根据年月查询数量
     *
     * @param time
     * @return
     */
    int findByTimeYearAndMonthCount(@Param(value = "comy") String comy, @Param(value = "time") Date time);

    /**
     * 根据年查询
     *
     * @param time
     * @return
     */
    List<Honour> findByTimeYear(@Param(value = "comy") String comy, @Param(value = "time") Date time, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 根据年查询数量
     *
     * @param time
     * @return
     */
    int findByTimeYearCount(@Param(value = "comy") String comy, @Param(value = "time") Date time);

    /**
     * 、
     * 多条件查找
     *
     * @param map
     * @return
     */
    List<Honour> findByConditions(@Param(value = "comy") String comy, @Param(value = "map") Map<String, String> map, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 插入
     *
     * @param honour
     * @return
     */
    int insertHon(@Param(value = "honour") Honour honour);

    /**
     * 批量插入
     *
     * @param honours
     * @return
     */
    int insertHons(@Param(value = "list") List<Honour> honours);

    /**
     * 、删除
     *
     * @param id
     * @return
     */
    int deleteHon(@Param(value = "id") Integer id);

    /**
     * @Author RainGoal
     * @Description 更新荣誉
     * @Param [honour]
     * @Return int
     * @Date 2021/2/23
     */
    int updateHonour(@Param(value = "honour") Honour honour);

    /**
     * @Author RainGoal
     * @Description 根据ID查询
     * @Param [id]
     * @Return com.SchoolManage.pojo.Honour
     * @Date 2021/2/23
     */
    Honour findById(int id);
}
