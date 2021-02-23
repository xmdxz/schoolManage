package com.SchoolManage.dao;

import com.SchoolManage.pojo.Activemember;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ActiveMemberDao {

    /**
     * 根据id
     *
     * @param id
     * @return
     */
    Activemember findById(@Param(value = "id") Integer id);

    /**
     * 获取全部
     *
     * @param startPage
     * @param num
     * @return
     */
    List<Activemember> findAll(@Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);
    
    /**
     * 获取总数
     *
     * @return
     */
    int findAllCount();


    /**
     * 根据活动查询
     *
     * @param id
     * @return
     */
    List<Activemember> findByActive(@Param(value = "id") Integer id, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 根据活动查询总数
     *
     * @param id
     * @return
     */
    int findByActiveCount(@Param(value = "id") Integer id);

    /**
     * 根据班级查询
     *
     * @param clazz
     * @return
     */
    List<Activemember> findByClazz(@Param(value = "clazz") String clazz, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 根据班级查询
     *
     * @param clazz
     * @return
     */
    int findByClazzCount(@Param(value = "clazz") String clazz);

    /**
     * 根据活动和班级
     *
     * @param id
     * @param clazz
     * @param startPage
     * @param num
     * @return
     */
    List<Activemember> findByActiveAndClazz(@Param(value = "id") Integer id, @Param(value = "clazz") String clazz, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 根据活动和班级查询数量
     *
     * @param id
     * @param clazz
     * @return
     */
    int findByActiveAndClazzCount(@Param(value = "id") Integer id, @Param(value = "clazz") String clazz);

    /**
     * 插入
     *
     * @param activemember
     * @return
     */
    int insertData(@Param(value = "activemember") Activemember activemember);

    /**
     * 批量插入
     *
     * @param list
     * @return
     */
    int insertDatas(@Param(value = "list") List<Activemember> list);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteData(@Param(value = "id") Integer id);

    /**
     * 更新
     *
     * @param activemember
     * @return
     */
    int updateDara(@Param(value = "activemember") Activemember activemember);

    /**
     * 通过学号查找
     *
     * @param student
     * @return
     */
    Activemember findByStudent(@Param(value = "student") String student, @Param(value = "activity") Integer activity);

    /**
     * 通过姓名查找
     *
     * @param name
     * @param startPage
     * @param num
     * @return 不排除同名学生，所以返回list
     */
    List<Activemember> findByName(@Param(value = "name") String name, @Param(value = "activity") Integer activity, @Param(value = "startPage") int startPage, @Param(value = "num") int num);

    /**
     * 通过姓名查找数量
     *
     * @param name
     * @return
     */
    int findByNameCount(@Param(value = "name") String name, @Param(value = "activity") Integer activity);
}
