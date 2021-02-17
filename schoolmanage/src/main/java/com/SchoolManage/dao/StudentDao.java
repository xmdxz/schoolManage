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
     *
     * @param conditions
     * @return
     */
    List<Student> findByMultipleConditions(@Param(value = "map") Map<String, String> conditions, @Param(value = "startPage") int startPage, @Param(value = "num") int num);

    /**
     * 多条件查询结果数量
     *
     * @param nconditions
     * @return
     */
    int findByMultipleConditionsCount(@Param(value = "maps") Map<String, String> nconditions);

    /**
     * 查询方向分类
     *
     * @return
     */
    List<String> findDirection();

    /**
     * 根据现班级查询班干部
     *
     * @param clazz
     * @return
     */
    List<Student> findPresentCadre(@Param(value = "clazz") String clazz, @Param(value = "startPage") int startPage, @Param(value = "num") int num);

    /**
     * 根据现班级职务查询数量
     *
     * @param clazz
     * @return
     */
    int findPresentCadreCount(@Param(value = "clazz") String clazz);

    /**
     * 根据原班级查询班干部
     *
     * @return
     */
    List<Student> findOriginalCadre(@Param(value = "clazz") String clazz, @Param(value = "startPage") int startPage, @Param(value = "num") int num);

    /**
     * 根据原班级查询干部数量
     *
     * @param clazz
     * @return
     */
    int findOriginalCadreCount(@Param(value = "clazz") String clazz);

    /**
     * 根据方向查找
     *
     * @param direction
     * @return
     */
    List<Student> findByDirection(@Param(value = "direction") String direction, @Param(value = "startPage") int startPage, @Param(value = "num") int num);

    /**
     * 根据方向查找数量
     *
     * @param direction
     * @return
     */
    int findByDirectionCount(@Param(value = "direction") String direction);

    /**
     * 分页查询，需service计算startPage
     *
     * @param startPage 从第几条开始 计算方法：(页数-1)*num
     * @param num       需要拿多少条数据
     * @return
     */
    List<Student> findPage(@Param(value = "startPage") int startPage, @Param(value = "num") int num);

    /**
     * 删除学生
     *
     * @param id
     * @return
     */
    int deleteStudent(@Param(value = "id") String id);

    /**
     * 根据条件查询学生的人数,当无查询条件时，传入参数两个为空即可
     *
     * @param conditionName
     * @param conditionValue
     * @return
     */
    int selectStudentNum(@Param(value = "conditionName") String conditionName, @Param(value = "conditionValue") String conditionValue);

    /**
     * 批量插入学生
     *
     * @param list 参数为list集合
     * @return
     */
    int insertBatchStudent(@Param(value = "list") List<Student> list);

    /**
     * 添加学生
     *
     * @param student
     * @return
     */
    int insertStudent(@Param(value = "student") Student student);

    /**
     * 通过学号查找
     *
     * @param id
     * @return
     */
    Student findById(@Param(value = "id") String id);

    /**
     * 通过姓名查找
     *
     * @param name
     * @param startPage
     * @param num
     * @return 不排除同名学生，所以返回list
     */
    List<Student> findByName(@Param(value = "name") String name, @Param(value = "startPage") int startPage, @Param(value = "num") int num);

    /**
     * 通过姓名查找数量
     *
     * @param name
     * @return
     */
    int findByNameCount(@Param(value = "name") String name);


    /**
     * 以原班级为单位查询
     *
     * @param original_class
     * @param startPage
     * @param num
     * @return
     */
    List<Student> findByClass_or(@Param(value = "original_class") String original_class, @Param(value = "startPage") int startPage, @Param(value = "num") int num);

    /**
     * 根据原班级查询数量
     *
     * @param original_class
     * @return
     */
    int findByClass_orCount(@Param(value = "original_class") String original_class);

    /**
     * 以现班级为单位查询
     *
     * @param present_class
     * @return
     */
    List<Student> findByClass_pe(@Param(value = "present_class") String present_class, @Param(value = "startPage") int startPage, @Param(value = "num") int num);

    /**
     * 根据现班级查询数量
     *
     * @param present_class
     * @return
     */
    int findByClass_peCount(@Param(value = "present_class") String present_class);

    /**
     * 以专业为单位查询，应该很少用
     *
     * @param major
     * @return
     */
    List<Student> findByMajor(@Param(value = "major") String major, @Param(value = "startPage") int startPage, @Param(value = "num") int num);

    /**
     * 根据专业查询数量
     *
     * @param major
     * @return
     */
    int findByMajorCount(@Param(value = "major") String major);

    /**
     * 更新信息
     *
     * @param student
     * @return
     */
    int updateStudent(@Param(value = "student") Student student);

    /**
     * @Description: 查询所有的学生
     * @Param: []
     * @return: java.util.List<com.SchoolManage.pojo.Student>
     * @Author: RainGoal
     * @Date: 2021/1/30
     */
    List<Student> findAll();

    /**
     * @Description: 查询指定地区的数目
     * @Param: [area]
     * @return: int
     * @Author: RainGoal
     * @Date: 2021/2/17
     */
    int findByArea(@Param(value = "area") String area);

    /**
     * @Description: 根据地区模糊查询学生
     * @Param: [area]
     * @return: java.util.List<com.SchoolManage.pojo.Student>
     * @Author: RainGoal
     * @Date: 2021/2/17
     */
    List<Student> findByAreaStudent(@Param("area") String area, @Param("startPage") int startPage, @Param("num") int num);

    /**
     * 查找总数
     *
     * @return
     */
    int findAllNum();
}
