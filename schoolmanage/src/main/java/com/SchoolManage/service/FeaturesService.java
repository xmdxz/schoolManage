package com.SchoolManage.service;

import java.util.List;

/**
 * @Author RainGoal
 * @Date 2021/2/2 19:05
 * @Description TODO
 * @Version 1.0
 */

public interface FeaturesService {
    /**
     * 根据专业返回方向
     * @param major
     * @return
     */
    List<String> findDirectionByMajor(String major);
}
