package com.SchoolManage.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface FeaturesDao {

    /**
     * 根据专业返回方向
     * @param major
     * @return
     */
    List<String> findDirectionByMajor(@Param(value = "major") String major);


}
