package com.SchoolManage.dao;

import com.SchoolManage.pojo.OriginalClass;
import com.SchoolManage.pojo.PresentClass;

import java.util.List;

public interface OriginalClassDao {
    /**
     * 根据班级查询
     * @param clazz
     * @return
     */
    OriginalClass findClazz(String clazz);

    /**
     * 查询全部
     * @return
     */
    List<OriginalClass> findAll();
}
