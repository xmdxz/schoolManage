package com.SchoolManage.service;

import com.SchoolManage.pojo.Student;

import java.util.List;
import java.util.Map;

/**
 * @Author RainGoal
 * @Date 2021/1/29 16:41
 * @Description TODO
 * @Version 1.0
 */

public interface StudentService {

    /**
     * 根据方向查找
     *
     * @param direction
     * @return
     */
    List<Student> findByDirection(String comy, String direction, int page, int num);

    /**
     * 分页查询，需service计算startPage
     *
     * @param page 从第几条开始 计算方法：(页数-1)*num
     * @param num  需要拿多少条数据
     * @return
     */
    List<Student> findPage(String comy, int page, int num);

    /**
     * 添加学生
     *
     * @param student
     * @return
     */
    int insertStudent(Student student);

    /**
     * 通过学号查找
     *
     * @param id
     * @return
     */
    Student findById(String id);

    /**
     * 通过姓名查找
     *
     * @param name
     * @return 不排除同名学生，所以返回list
     */
    List<Student> findByName(String comy, String name, int page, int num);

    /**
     * 以原班级为单位查询
     *
     * @param original_class
     * @return
     */
    List<Student> findByClass_or(String comy, String original_class, int page, int num);

    /**
     * 以现班级为单位查询
     *
     * @param present_class
     * @return
     */
    List<Student> findByClass_pe(String comy, String present_class, int page, int num);

    /**
     * 以专业为单位查询，应该很少用
     *
     * @param major
     * @return
     */
    List<Student> findByMajor(String comy, String major, int page, int num);

    /**
     * 更新信息
     *
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
    List<Student> findAll(String comy);

    /**
     * @Description: 根据学号删除
     * @Param: [id]
     * @return: int
     * @Author: RainGoal
     * @Date: 2021/1/30
     */
    int deleteStudent(String id);

    /**
     * 根据条件查询学生的人数,当无查询条件时，传入参数两个为空即可
     *
     * @param conditionName
     * @param conditionValue
     * @return
     */
    int selectStudentNum(String comy, String conditionName, String conditionValue);

    /**
     * 根据多条件筛选
     *
     * @param conditions
     */
    List<Student> findByMultipleConditions(String comy, Map<String, String> conditions, int page, int num);

    /**
     * 多条件查询结果数量
     */
    int findByMultipleConditionsCount(String comy, Map<String, String> nconditions);

    /**
     * 查询姓名结果数量
     */
    int findByNameCount(String comy, String name);

    /**
     * 批量添加学生
     */
    int BatchAddition(String comy, String path);

    /**
     * @Description: 查询指定地区的数目
     * @Param: [area]
     * @return: int
     * @Author: RainGoal
     * @Date: 2021/2/17
     */
    Map<String, Integer> findByArea(String comy, List<String> arealist);

    /**
     * @Description: 根据地区模糊查询学生
     * @Param: [area]
     * @return: java.util.List<com.SchoolManage.pojo.Student>
     * @Author: RainGoal
     * @Date: 2021/2/17
     */
    List<Student> findByAreaStudent(String comy, String area, int Page, int num);

    /**
     * 查询总数
     */
    int findAllNum(String comy);
}
