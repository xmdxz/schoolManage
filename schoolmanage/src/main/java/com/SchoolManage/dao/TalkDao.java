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
    List<Talk> findAll();

    /**
     * 插入谈话数据
     *
     * @param talk
     * @return
     */
    int insertTalk(@Param(value = "talk") Talk talk);

    /**
     * 根据学号查找
     *
     * @param student
     * @return
     */
    List<Talk> findByStudent(String student);

    /**
     * 根据教师查找
     *
     * @param teacher
     * @return
     */
    List<Talk> findByTeacher(String teacher);

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
     * 根据时间查找
     *
     * @param date
     * @return
     */
    List<Talk> findByTime(@Param(value = "time") Date date);
}
