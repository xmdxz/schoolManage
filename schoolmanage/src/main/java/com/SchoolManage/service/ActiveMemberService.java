package com.SchoolManage.service;

import com.SchoolManage.pojo.Activemember;

import java.util.List;

/**
 * @Author RainGoal
 * @Date 2021/2/19 9:07
 * @Description TODO
 * @Version 1.0
 */

public interface ActiveMemberService {

    /**
     * 获取全部
     *
     * @param Page
     * @param num
     * @return
     */
    List<Activemember> findAll(Integer Page, Integer num);

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
    List<Activemember> findByActive(Integer id, Integer Page, Integer num);

    /**
     * 根据活动查询总数
     *
     * @param id
     * @return
     */
    int findByActiveCount(Integer id);

    /**
     * 根据班级查询
     *
     * @param clazz
     * @return
     */
    List<Activemember> findByClazz(String clazz, Integer Page, Integer num);

    /**
     * 根据班级查询
     *
     * @param clazz
     * @return
     */
    int findByClazzCount(String clazz);

    /**
     * 根据活动和班级
     *
     * @param id
     * @param clazz
     * @param Page
     * @param num
     * @return
     */
    List<Activemember> findByActiveAndClazz(Integer id, String clazz, Integer Page, Integer num);

    /**
     * 根据活动和班级查询数量
     *
     * @param id
     * @param clazz
     * @return
     */
    int findByActiveAndClazzCount(Integer id, String clazz);

    /**
     * 插入
     *
     * @param activemember
     * @return
     */
    int insertData(Activemember activemember);

    /**
     * 批量插入
     *
     * @param list
     * @return
     */
    int insertDatas(List<Activemember> list);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteData(Integer id);
}
