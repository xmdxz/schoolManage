package com.SchoolManage.dao;

import com.SchoolManage.pojo.AdminUser;
import com.SchoolManage.pojo.Log;
import com.SchoolManage.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface LogDao {
    /**
     * 更新日志
     * @param log
     * @return
     */
    int insertLog(Log log);

    /**
     * 查找全部操作记录
     * @return
     */
    List<Log> findLog();

    /**
     * 根据时间查找日志
     * @param time
     * @return
     */
    List<Log> findLogByTime(String time);

    /**
     * 根据操作员即教师查询
     * @param adminUser
     * @return
     */
    List<Log> findLogByTeacher(AdminUser adminUser);

    /**
     * 根据学生查找
     * @param student
     * @return
     */
    List<Log> findLogByStudent(Student student);

    /**
     * 根据表查询，不知道有没有用，万一呢
     * @param table
     * @return
     */
    List<Log> findLogByTable(String table);
}
