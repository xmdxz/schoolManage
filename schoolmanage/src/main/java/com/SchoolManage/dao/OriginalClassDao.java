package com.SchoolManage.dao;

import com.SchoolManage.pojo.OriginalClass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OriginalClassDao {
    /**
     * 根据班级查询
     *
     * @param clazz
     * @return
     */
    OriginalClass findClazz(@Param(value = "clazz") String clazz);

    /**
     * 查询全部
     *
     * @return
     */
    List<OriginalClass> findAll(@Param(value = "comy") String comy, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);
}
