package com.SchoolManage.dao;

import com.SchoolManage.pojo.PresentClass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PresentClassDao {
    /**
     * 根据班级查询
     * @param clazz
     * @return
     */
    PresentClass findClazz(@Param(value = "clazz") String clazz);

    /**
     * 查询全部
     * @return
     */
    List<PresentClass> findAll();
}
