package com.SchoolManage.service;

import com.SchoolManage.pojo.AdminUser;
import com.SchoolManage.pojo.Log;
import com.SchoolManage.pojo.Student;

import java.sql.Timestamp;
import java.util.List;

public interface LogService {
    /**
     * 插入新记录
     *
     * @param teacher
     */
    int insertNew(String type, String message, String teacher, String student, String table);

    /**
     * 查找全部操作记录,并根据时间排序
     * 顺带分页
     *
     * @param page
     * @return
     */
    List<Log> findAll(String comy, Integer page);

    /**
     * 根据年月日时间查找日志
     *
     * @param time
     * @return
     */
    List<Log> findLogByTime(String comy, Timestamp time);

    /**
     * 根据年月查询
     *
     * @param time
     * @return
     */
    List<Log> findLogByTimeYearAndMonth(String comy, Timestamp time);

    /**
     * 根据年查询
     *
     * @param time
     * @return
     */
    List<Log> findLogByTimeYear(String comy, Timestamp time);

    /**
     * 时间模糊查询
     *
     * @param comy
     * @param date
     * @return
     */
    List<Log> findLogByDate(String comy, Timestamp date);

    /**
     * 根据操作员即教师查询
     *
     * @param adminUser
     * @return
     */
    List<Log> findLogByTeacher(String comy, AdminUser adminUser);

    /**
     * 根据学生查找
     *
     * @param student
     * @return
     */
    List<Log> findLogByStudent(String comy, Student student);

    /**
     * 根据表查询，不知道有没有用，万一呢
     *
     * @param table
     * @return
     */
    List<Log> findLogByTable(String comy, String table);
}
