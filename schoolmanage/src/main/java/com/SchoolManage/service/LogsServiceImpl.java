package com.SchoolManage.service;

import com.SchoolManage.dao.LogsDao;
import com.SchoolManage.pojo.Logs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LogsServiceImpl implements LogsService {
    @Autowired
    private LogsDao logsDao;

    @Override
    public int findAllNum() {
        return logsDao.findAllNum();
    }

    @Override
    public List<Logs> findAll() {
        return logsDao.findAll();
    }

    @Override
    public int insertLogs(Logs logs) {
        return logsDao.insertData(logs);
    }

    @Override
    public int delectLogs(Integer id) {
        return logsDao.deleteData(id);
    }

    @Override
    public int updataLogs(Logs logs) {
        return logsDao.updateData(logs);
    }
}
