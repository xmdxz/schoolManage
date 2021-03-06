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
    List<Talk> findAll(@Param(value = "comy") String comy);


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
     * @return
     */
    List<Talk> findByStudent(@Param(value = "student") String student);

    /**
     * 模糊查询时间
     *
     * @param date
     * @return
     */
    List<Talk> findByDate(@Param(value = "date") Date date);


    /**
     * 查询学生一共的谈话次数
     *
     * @param student
     * @return
     */
    int findByStudentCount(@Param(value = "student") String student);

    /**
     * 根据教师查找
     *
     * @param teacher
     * @return
     */
    List<Talk> findByTeacher(@Param(value = "comy") String comy, @Param(value = "teacher") String teacher);

    /**
     * 删除谈话
     *
     * @param id
     * @return
     */
    int deleteTalk(@Param(value = "id") Integer id);

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
    List<Talk> findByTime(@Param(value = "comy") String comy, @Param(value = "time") Date date);

    /**
     * 根据年月查找，也就是某一月
     *
     * @param date
     * @return
     */
    List<Talk> findByTimeYearAndMonth(@Param(value = "comy") String comy, @Param(value = "time") Date date);


    /**
     * 根据年
     *
     * @param comy
     * @param date
     * @return
     */
    List<Talk> findByTimeYear(@Param(value = "comy") String comy, @Param(value = "time") Date date);


    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    Talk findById(@Param(value = "id") Integer id);

    /**
     * 根据类型查询
     *
     * @param types
     * @return
     */
    List<Talk> findByTypes(@Param(value = "types") String types);


    /**
     * 三者查询
     *
     * @param time
     * @param types
     * @param level
     * @param comy
     * @return
     */
    List<Talk> findByDateAndTypesAndLevel(@Param(value = "time") Date time, @Param(value = "types") String types, @Param(value = "level") String level, @Param(value = "comy") String comy);

    /**
     * 更新
     *
     * @param talk
     * @return
     */
    int updata(@Param(value = "talk") Talk talk);
}
