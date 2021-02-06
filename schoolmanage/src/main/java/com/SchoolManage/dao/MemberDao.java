package com.SchoolManage.dao;

import com.SchoolManage.pojo.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface MemberDao {

    /**
     * 查询全部成员，这里的全部只得是，无论哪个部门
     */
    List<Member> findAll(@Param(value = "startPage") int startPage,@Param(value = "num") int num);

    /**
     * 查询全部成员数量
     */
    int findAllNum();

    /**
     * 根据部门查询成员
     */
    List<Member> findByDepartment(@Param(value = "department") String department,@Param(value = "startPage") int startPage,@Param(value = "num") int num);

    /**
     * 根据部门查询成员数量
     */
    int findByDepartmentNum(@Param(value = "department") String department);

    /**
     * 根据部门和id查询成员
     * @param department
     * @param id
     * @return
     */
    Member findByDepartmentAndId(@Param(value = "department")String department,@Param(value = "id") String id);

    /**
     * 根据部门和姓名查询成员
     * @param department
     * @param name
     * @return
     */
    List<Member> findByDepartmenrAndName(@Param(value = "department")String department,@Param(value = "name") String name,@Param(value = "startPage")int startPage,@Param(value = "num")int num);

    /**
     * 根据部门和姓名查询成员数量
     * @param department
     * @param name
     * @return
     */
    int findByDepartmentAndNameNum(@Param(value = "department")String department,@Param(value = "name") String name);

    /**
     * 根据部门和职位查询成员
     * @param department
     * @param position
     * @return
     */
    List<Member> findByDepartmentAndPosition(@Param(value = "department")String department,@Param(value = "position") String position,@Param(value = "startPage") int startPage,@Param(value = "num")int num);

    /**
     * 根据部门和职位查询数量
     * @param department
     * @param position
     * @return
     */
    int findByDepartmentAndPositionNum(@Param(value = "department")String department,@Param(value = "position") String position);
    /**
     * 根据部门和班级查询成员
     * @param department
     * @param clazz
     * @return
     */
    List<Member> findByDepartmentAndClazz(@Param(value = "department")String department,@Param(value = "clazz") String clazz,@Param(value = "startPage") int startPage,@Param(value = "num")int num);

    /**
     * 根据部门和班级查询数量
     * @param department
     * @param clazz
     * @return
     */
    int findByDepartmentAndClazzNum(@Param(value = "department")String department,@Param(value = "clazz") String clazz);
    /**
     * 根据部门和多条件查询成员
     * @param department
     * @param map
     * @return
     */
    List<Member> findByDepartmentAndConditions(@Param(value = "department")String department,@Param(value = "map")Map<String,String> map,@Param(value = "startPage") int startPage,@Param(value = "num")int num);

    /**
     * 根据部门和多条件查询数量
     * @param department
     * @param map
     * @return
     */
    int findByDepartmentAndConditionsNum(@Param(value = "department")String department,@Param(value = "map")Map<String,String> map);
    /**
     * 根据学号查询
     */
    Member findById(@Param(value = "id") String id);

    /**
     * 根据姓名查找
     */
    List<Member> findByName(@Param(value = "name") String name,@Param(value = "startPage") int startPage,@Param(value = "num") int num);

    /**
     * 根据姓名查询数量
     */
    int findByNameNum(@Param(value = "name") String name);

    /**
     * 根据职位查找
     */
    List<Member> findByPosition(@Param(value = "position") String position,@Param(value = "startPage") int startPage,@Param(value = "num") int num);

    /**
     * 根据职位查找数量
     */
    int findByPositionNum(@Param(value = "position") String position);

    /**
     * 多条件查询
     */
    List<Member> findByConditions(@Param(value = "map") Map<String, String> map);

    /**
     * 根据多条件查询的数量
     */
    int findByConditionsNum(@Param(value = "map") Map<String,String> map);
    /**
     * 单条插入
     */
    int insertData(@Param(value = "member") Member member);

    /**
     * 批量插入
     */
    int insertDatas(@Param(value = "list") List<Member> members);

    /**
     *更新
     */
    int updateData(@Param(value = "member") Member member);

    /**
     * 删除
     */
    int deleteData(@Param(value = "id") String id);
}
