package com.SchoolManage.dao;

import com.SchoolManage.pojo.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MemberDao {

    /**
     * 查询全部成员，这里的全部只得是，无论哪个部门
     */
    List<Member> findAll(int startPage,int num);

    /**
     * 查询全部成员数量
     */
    int findAllNum();

    /**
     * 根据部门查询成员
     */
    List<Member> findByDepartment(String department,int startPage,int num);

    /**
     * 根据部门查询成员数量
     */
    int findByDepartmentNum(String department);

    /**
     * 根据学号查询
     */
    Member findById(String id);

    /**
     * 根据姓名查找
     */
    List<Member> findByName(String name,int startPage,int num);

    /**
     * 根据姓名查询数量
     */
    int findByNameNum(String name);

    /**
     * 根据职位查找
     */
    List<Member> findByPosition(String position,int startPage,int num);

    /**
     * 根据职位查找数量
     */
    int findByPositionNum(String position);

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
    int insertData(Member member);

    /**
     * 批量插入
     */
    int insertDatas(@Param(value = "list") List<Member> members);

    /**
     *更新
     */
    int updateData(Member member);

    /**
     * 删除
     */
    int deleteData(String id);
}
