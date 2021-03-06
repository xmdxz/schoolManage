package com.SchoolManage.dao;

import com.SchoolManage.pojo.AdminUser;
import com.SchoolManage.pojo.Log;
import com.SchoolManage.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Mapper
@Repository
public interface LogDao {
    /**
     * 更新日志
     *
     * @param log
     * @return
     */
    int insertLog(@Param(value = "log") Log log);

    /**
     * 查找全部操作记录,并根据时间排序
     * 顺带分页
     *
     * @param page
     * @return
     */
    List<Log> findLog(@Param(value = "comy") String comy, @Param(value = "page") Integer page);

    /**
     * 根据年月日时间查找日志
     *
     * @param time
     * @return
     */
    List<Log> findLogByTime(@Param(value = "comy") String comy, @Param(value = "time") Timestamp time);

    /**
     * 根据年月查询
     *
     * @param time
     * @return
     */
    List<Log> findLogByTimeYearAndMonth(@Param(value = "comy") String comy, @Param(value = "time") Timestamp time);

    /**
     * 根据年查询
     *
     * @param time
     * @return
     */
    List<Log> findLogByTimeYear(@Param(value = "comy") String comy, @Param(value = "time") Timestamp time);

    /**
     * 时间模糊查询
     *
     * @param comy
     * @param date
     * @return
     */
    List<Log> findLogByDate(@Param(value = "comy") String comy, @Param(value = "date") Timestamp date);

    /**
     * 根据操作员即教师查询
     *
     * @param adminUser
     * @return
     */
    List<Log> findLogByTeacher(@Param(value = "comy") String comy, @Param(value = "adminUser") AdminUser adminUser);

    /**
     * 根据学生查找
     *
     * @param student
     * @return
     */
    List<Log> findLogByStudent(@Param(value = "comy") String comy, @Param(value = "student") Student student);

    /**
     * 根据表查询，不知道有没有用，万一呢
     *
     * @param table
     * @return
     */
    List<Log> findLogByTable(@Param(value = "comy") String comy, @Param(value = "table") String table);
}
