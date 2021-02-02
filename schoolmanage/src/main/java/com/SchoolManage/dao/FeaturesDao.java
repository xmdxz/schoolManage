package com.SchoolManage.dao;

import java.util.List;

public interface FeaturesDao {

    /**
     * 根据专业返回方向
     * @param major
     * @return
     */
    List<String> findDirectionByMajor(String major);


}
