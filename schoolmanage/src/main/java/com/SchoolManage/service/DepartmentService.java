package com.SchoolManage.service;

import com.SchoolManage.pojo.DepartMent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author RainGoal
 * @Date 2021/2/5 16:51
 * @Description TODO
 * @Version 1.0
 */

public interface DepartmentService {

    /**
     * 查询全部部门信息
     */
    List<DepartMent> findAll(int Page, int num);

    /**
     * 查询全部部门数量
     */
    int findAllNum();

    /**
     * 根据部门名称查询
     */
    List<DepartMent> findByName(String name, int Page, int num);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    DepartMent findById(Integer id);

    /**
     * 根据姓名查询的数量
     */
    int findByNameNum(String name);

    /**
     * 根据部长查询
     */

    List<DepartMent> findByMinister(String Minister, int Page, int num);

    /**
     * 根据部长查询的数量
     */
    int findByMinisterNum(String minister);

    /**
     * 根据所属院系查询
     */
    List<DepartMent> findByCollege(String college, int Page, int num);

    /**
     * 根据所属院系的数量
     */
    int findByCollegeNum(String college);

    /**
     * 插入一条
     */
    int insertData(DepartMent departMent);

    /**
     * 批量插入
     */
    int insertDatas(@Param(value = "list") List<DepartMent> departMents);

    /**
     * 更新
     */
    int updateData(DepartMent departMent);

    /**
     * 删除记录
     */
    int deleteData(Integer id);

    /**
     * 批量添加学生
     */
    int BatchAddition(String path);
}
