package com.SchoolManage.dao;

import com.SchoolManage.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author RainGoal
 * @Date 2021/1/28 9:07
 * @Description TODO
 * @Version 1.0
 */
@Mapper
@Repository
public interface StudentDao {
    /**
     * 添加学生
     * @param student
     * @return
     */
    int insertStudent(Student student);
    /**
     * 通过学号查找
     * @param id
     * @return
     */
    Student findById(String id);

    /**
     * 通过姓名查找
     * @param name
     * @return 不排除同名学生，所以返回list
     */
    List<Student> findByName(String name);

    /**
     * 以原班级为单位查询
     * @param original_class
     * @return
     */
    List<Student> findByClass_or(String original_class);

    /**
     * 以现班级为单位查询
     * @param present_class
     * @return
     */
    List<Student> findByClass_pe(String present_class);
    /**
     * 以专业为单位查询，应该很少用
     * @param major
     * @return
     */
    List<Student> findByMajor(String major);

    /**
     * 更新信息
     * @param student
     * @return
     */
    int updateStudent(Student student);

    /**
       * @Description: 查询所有的学生
       * @Param: []
       * @return: java.util.List<com.SchoolManage.pojo.Student>
       * @Author: RainGoal
       * @Date: 2021/1/30
    */
    List<Student> findAll();

}
