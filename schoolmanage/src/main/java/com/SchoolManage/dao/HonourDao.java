package com.SchoolManage.dao;

import com.SchoolManage.pojo.Honour;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface HonourDao {

    /**
     * 查找全部
     *
     * @return
     */
    List<Honour> findAll();

    /**
     * 根据学生查找
     *
     * @param student
     * @return
     */
    List<Honour> findByStudent(@Param(value = "student") String student);

    /**
     * 、根据荣誉类型查找
     *
     * @param Type
     * @return
     */
    List<Honour> findByType(@Param(value = "type") String Type);

    /**
     * 根据荣誉查找
     *
     * @param prize
     * @return
     */
    List<Honour> findByPrize(@Param(value = "prize") String prize);

    /**
     * 根据时间查找
     *
     * @param time
     * @return
     */
    List<Honour> findByTime(@Param(value = "time") Date time);

    /**
     * 、
     * 多条件查找
     *
     * @param map
     * @return
     */
    List<Honour> findByConditions(@Param(value = "map") Map<String, String> map);

    /**
     * 插入
     *
     * @param honour
     * @return
     */
    int insertHon(@Param(value = "honour") Honour honour);

    /**
     * 批量插入
     *
     * @param honours
     * @return
     */
    int insertHons(@Param(value = "list") List<Honour> honours);

    /**
     * 、删除
     *
     * @param id
     * @return
     */
    int deleteHon(@Param(value = "id") Integer id);

}
