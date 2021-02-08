package com.SchoolManage.service;

import com.SchoolManage.pojo.Dormitory;
import com.SchoolManage.pojo.Student;

import java.util.List;

/**
 * @Author RainGoal
 * @Date 2021/2/8 13:41
 * @Description TODO
 * @Version 1.0
 */

public interface DormitoryService {
    /**
     * 查询宿舍成员
     *
     * @param dormitory
     * @param Page
     * @param num
     * @return
     */
    List<Student> findDormitoryMember(Dormitory dormitory, int Page, int num);

    /**
     * 查询宿舍成员数量
     *
     * @param dormitory
     * @return
     */
    int findDormitoryMemberNum(Dormitory dormitory);

    /**
     * 查询全部宿舍
     *
     * @param Page
     * @param num
     * @return
     */
    List<Dormitory> findAll(int Page, int num);

    /**
     * 查询全部宿舍数量
     *
     * @return
     */
    int findAllNum();

    /**
     * 根据宿舍长姓名查询
     *
     * @param name
     * @param Page
     * @param num
     * @return
     */
    List<Dormitory> findByName(String name, int Page, int num);

    /**
     * 根据姓名查询宿舍的数量，重名？  以防万一
     *
     * @param name
     * @return
     */
    int findByNameNum(String name);

    /**
     * 根据学号查询，学号唯一
     *
     * @param id
     * @return
     */
    Dormitory findById(String id);

    /**
     * 根据宿舍楼查询
     *
     * @param building
     * @param Page
     * @param num
     * @return
     */
    List<Dormitory> findByBuilding(String building, int Page, int num);

    /**
     * 根据宿舍楼查询数量
     *
     * @param building
     * @return
     */
    int findByBuildingNum(String building);

    /**
     * 根据宿舍号查询全部宿舍，但我感觉应该不会用，以防万一
     *
     * @param number
     * @param Page
     * @param num
     * @return
     */
    List<Dormitory> findByNumber(String number, int Page, int num);

    /**
     * 根据宿舍号查询全部宿舍数量，但我感觉应该不会用，以防万一
     *
     * @param number
     * @return
     */
    int findByNumberNum(String number);

    /**
     * 根据具体宿舍楼宿舍号查询
     *
     * @param building
     * @param number
     * @return
     */
    Dormitory findByBuildingAndNumber(String building, String number);

    /**
     * 插入单条
     *
     * @param dormitory
     * @return
     */
    int insertData(Dormitory dormitory);

    /**
     * 批量插入
     *
     * @param list
     * @return
     */
    int insertDatas(List<Dormitory> list);

    /**
     * 删除
     *
     * @param building
     * @param number
     * @return
     */
    int deleteData(String building, String number);

    /**
     * 更新
     *
     * @param dormitory
     * @return
     */
    int updateData(Dormitory dormitory);
    /**
     * 批量添加学生
     */
    int BatchAddition(String path);
}
