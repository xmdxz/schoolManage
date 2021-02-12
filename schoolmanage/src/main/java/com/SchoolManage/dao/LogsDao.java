package com.SchoolManage.dao;

import com.SchoolManage.pojo.Logs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LogsDao {

    /**
     * 插入
     *
     * @param logs
     * @return
     */
    int insertData(@Param(value = "logs") Logs logs);

    /**
     * 批量
     *
     * @param list
     * @return
     */
    int insertDatas(@Param(value = "list") List<Logs> list);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteData(@Param(value = "id") Integer id);

    /**
     * 查找
     *
     * @return
     */
    List<Logs> findAll();

    /**
     * 查找数量
     *
     * @return
     */
    int findAllNum();

    /**
     * 更新记录
     *
     * @param logs
     * @return
     */
    int updateData(@Param(value = "logs")Logs logs);
    /**
     * 通过主键查找
     * @param  id
     * @return
     */
    Logs findbyId(@Param(value = "id") Integer id);
}
