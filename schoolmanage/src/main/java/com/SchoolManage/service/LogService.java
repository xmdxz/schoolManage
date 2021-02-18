package com.SchoolManage.service;

import com.SchoolManage.pojo.Log;

import java.util.List;

public interface LogService {
    /**
     * 插入新记录
     * @param teacher
     */
    int insertNew(String type,String message,String teacher,String student,String table);
    /**
     * 查找全部
     */
    List<Log> findAll();
}
