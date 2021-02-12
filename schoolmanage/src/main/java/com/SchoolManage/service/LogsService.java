package com.SchoolManage.service;

import com.SchoolManage.pojo.Logs;

import java.util.List;

public interface LogsService {
    /**
     * 查询事件总数
     */
    int findAllNum();
    /**
     * 查询全部
     */
    List<Logs> findAll();
    /**
     * 插入
     * @param logs
     */
    int insertLogs(Logs logs);
    /**
     * 删除
     * @param id
     */
    int delectLogs(Integer id);
    /**
     * 更新
     * @param logs
     */
    int updataLogs(Logs logs);
    /**
     * 查找
     * @param id
     */
    Logs findById(Integer id);
}
