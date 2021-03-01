package com.SchoolManage.dao;

import com.SchoolManage.pojo.DepartMent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartMentDao {

    /**
     * 查询全部部门信息
     */
    List<DepartMent> findAll(@Param(value = "comy") String comy, @Param(value = "startPage") int startPage, @Param(value = "num") int num);

    /**
     * 查询全部部门数量
     */
    int findAllNum(@Param(value = "comy") String comy);

    /**
     * 根据部门名称查询
     */
    List<DepartMent> findByName(@Param(value = "comy") String comy, @Param(value = "name") String name, @Param(value = "startPage") int startPage, @Param(value = "num") int num);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    DepartMent findById(@Param(value = "id") Integer id);

    /**
     * 根据姓名查询的数量
     */
    int findByNameNum(@Param(value = "comy") String comy, @Param(value = "name") String name);

    /**
     * 根据部长查询
     */

    List<DepartMent> findByMinister(@Param(value = "comy") String comy, @Param(value = "minister") String minister, @Param(value = "startPage") int startPage, @Param(value = "num") int num);

    /**
     * 根据部长查询的数量
     */
    int findByMinisterNum(@Param(value = "comy") String comy, @Param(value = "minister") String minister);

    /**
     * 根据所属院系查询
     */
    List<DepartMent> findByCollege(@Param(value = "comy") String comy, @Param(value = "college") String college, @Param(value = "startPage") int startPage, @Param(value = "num") int num);

    /**
     * 根据所属院系的数量
     */
    int findByCollegeNum(@Param(value = "comy") String comy, @Param(value = "college") String college);

    /**
     * 插入一条
     */
    int insertData(@Param(value = "departMent") DepartMent departMent);

    /**
     * 批量插入
     */
    int insertDatas(@Param(value = "list") List<DepartMent> departMents);

    /**
     * 更新
     */
    int updateData(@Param(value = "departMent") DepartMent departMent);

    /**
     * 删除记录
     */
    int deleteData(@Param(value = "id") Integer id);
}
