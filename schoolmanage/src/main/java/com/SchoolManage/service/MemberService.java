package com.SchoolManage.service;

import com.SchoolManage.pojo.Member;

import java.util.List;
import java.util.Map;

/**
 * @Author RainGoal
 * @Date 2021/2/5 21:55
 * @Description TODO
 * @Version 1.0
 */

public interface MemberService {

    /**
     * 查询全部成员，这里的全部只得是，无论哪个部门
     */
    List<Member> findAll( int Page, int num);

    /**
     * 查询全部成员数量
     */
    int findAllNum();

    /**
     * 根据部门查询成员
     */
    List<Member> findByDepartment( String department, int Page,int num);

    /**
     * 根据部门查询成员数量
     */
    int findByDepartmentNum( String department);

    /**
     * 根据学号查询
     */
    Member findById(String id);

    /**
     * 根据姓名查找
     */
    List<Member> findByName( String name, int Page, int num);

    /**
     * 根据姓名查询数量
     */
    int findByNameNum( String name);

    /**
     * 根据职位查找
     */
    List<Member> findByPosition( String position,int Page,int num);

    /**
     * 根据职位查找数量
     */
    int findByPositionNum(String position);

    /**
     * 多条件查询
     */
    List<Member> findByConditions(Map<String, String> map);

    /**
     * 根据多条件查询的数量
     */
    int findByConditionsNum(Map<String,String> map);
    /**
     * 单条插入
     */
    int insertData(Member member);

    /**
     * 批量插入
     */
    int insertDatas(List<Member> members);

    /**
     *更新
     */
    int updateData(Member member);

    /**
     * 删除
     */
    int deleteData(String id);

}
