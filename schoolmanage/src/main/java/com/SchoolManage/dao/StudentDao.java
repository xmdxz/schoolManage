package com.SchoolManage.dao;

import com.SchoolManage.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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
     * 根据多条条件查询
     * @param conditions
     * @return
     */
    List<Student> findByMultipleConditions(@Param(value = "map") Map<String, String> conditions,int startPage,int num);

    /**
     * 查询方向分类
     * @return
     */
    List<String> findDirection();

    /**
     * 根据现班级查询
     * @param clazz
     * @return
     */
    List<Student> findPresentCadre(String clazz);

    /**
     * 根据原班级查询班干部
     * @return
     */
    List<Student> findOriginalCadre(String clazz);

    /**
     * 根据方向查找
     * @param direction
     * @return
     */
    List<Student> findByDirection(String direction);

    /**
     * 分页查询，需service计算startPage
     * @param startPage 从第几条开始 计算方法：(页数-1)*num
     * @param num 需要拿多少条数据
     * @return
     */
    List<Student> findPage(int startPage,int num);

    /**
     * 删除学生
     * @param id
     * @return
     */
    int deleteStudent(String id);
    /**
     * 根据条件查询学生的人数,当无查询条件时，传入参数两个为空即可
     * @param conditionName
     * @param conditionValue
     * @return
     */
    int selectStudentNum(String conditionName,String conditionValue);
    /**
     * 批量插入学生
     * @param list 参数为list集合
     * @return
     */
    int insertBatchStudent(@Param(value = "list") List<Student> list);
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
