package com.SchoolManage.dao;

import com.SchoolManage.pojo.Dormitory;
import com.SchoolManage.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DormitoryDao {

    /**
     * 查询宿舍成员
     *
     * @param dormitory
     * @param startPage
     * @param num
     * @return
     */
    List<Student> findDormitoryMember(@Param(value = "dormitory") Dormitory dormitory, @Param(value = "startPage") int startPage, @Param(value = "num") int num);

    /**
     * 查询宿舍成员数量
     *
     * @param dormitory
     * @return
     */
    int findDormitoryMemberNum(@Param(value = "dormitory") Dormitory dormitory);

    /**
     * 查询全部宿舍
     *
     * @param startPage
     * @param num
     * @return
     */
    List<Dormitory> findAll(@Param(value = "startPage") int startPage, @Param(value = "num") int num);

    /**
     * 查询全部宿舍数量
     *
     * @return
     */
    int findAllNum();

    List<Dormitory> findAllNoPage();

    /**
     * 根据宿舍长姓名查询
     *
     * @param name
     * @param startPage
     * @param num
     * @return
     */
    List<Dormitory> findByName(@Param(value = "name") String name, @Param(value = "startPage") int startPage, @Param(value = "num") int num);

    /**
     * 根据姓名查询宿舍的数量，重名？  以防万一
     *
     * @param name
     * @return
     */
    int findByNameNum(@Param(value = "name") String name);

    /**
     * 根据学号查询，学号唯一
     *
     * @param id
     * @return
     */
    Dormitory findById(@Param(value = "id") String id);

    /**
     * 根据宿舍楼查询
     *
     * @param building
     * @param startPage
     * @param num
     * @return
     */
    List<Dormitory> findByBuilding(@Param(value = "building") String building, @Param(value = "startPage") int startPage, @Param(value = "num") int num);

    /**
     * 根据宿舍楼查询数量
     *
     * @param building
     * @return
     */
    int findByBuildingNum(@Param(value = "building") String building);

    /**
     * 根据宿舍号查询全部宿舍，但我感觉应该不会用，以防万一
     *
     * @param number
     * @param startPage
     * @param num
     * @return
     */
    List<Dormitory> findByNumber(@Param(value = "number") String number, @Param(value = "startPage") int startPage, @Param(value = "num") int num);

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
    Dormitory findByBuildingAndNumber(@Param(value = "building") String building, @Param(value = "number") String number);

    /**
     * 插入单条
     *
     * @param dormitory
     * @return
     */
    int insertData(@Param(value = "dormitory") Dormitory dormitory);

    /**
     * 批量插入
     *
     * @param list
     * @return
     */
    int insertDatas(@Param(value = "list") List<Dormitory> list);

    /**
     * 删除
     *
     * @param building
     * @param number
     * @return
     */
    int deleteData(@Param(value = "building") String building, @Param(value = "number") String number);

    /**
     * 更新
     *
     * @param dormitory
     * @return
     */
    int updateData(@Param(value = "dormitory") Dormitory dormitory);

}
