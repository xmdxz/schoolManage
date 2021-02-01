package com.SchoolManage.dao;

import com.SchoolManage.pojo.PresentClass;

import java.util.List;

public interface PresentClassDao {
    /**
     * 根据班级查询
     * @param clazz
     * @return
     */
    PresentClass findClazz(String clazz);

    /**
     * 查询全部
     * @return
     */
    List<PresentClass> findAll();
}
