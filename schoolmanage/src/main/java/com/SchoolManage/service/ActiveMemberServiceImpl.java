package com.SchoolManage.service;

import com.SchoolManage.dao.ActiveMemberDao;
import com.SchoolManage.pojo.Activemember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author RainGoal
 * @Date 2021/2/19 9:09
 * @Description TODO
 * @Version 1.0
 */
@Service
public class ActiveMemberServiceImpl implements ActiveMemberService {
    @Autowired
    private ActiveMemberDao activeMemberDao;


    @Override
    public List<Activemember> findAll(Integer Page, Integer num) {
        return activeMemberDao.findAll((Page - 1) * num, num);
    }

    @Override
    public int findAllCount() {
        return activeMemberDao.findAllCount();
    }

    @Override
    public List<Activemember> findByActive(Integer id, Integer Page, Integer num) {
        return activeMemberDao.findByActive(id, (Page - 1) * num, num);
    }

    @Override
    public int findByActiveCount(Integer id) {
        return activeMemberDao.findByActiveCount(id);
    }

    @Override
    public List<Activemember> findByClazz(String clazz, Integer Page, Integer num) {
        return activeMemberDao.findByClazz(clazz, (Page - 1) * num, num);
    }

    @Override
    public int findByClazzCount(String clazz) {
        return activeMemberDao.findByClazzCount(clazz);
    }

    @Override
    public List<Activemember> findByActiveAndClazz(Integer id, String clazz, Integer Page, Integer num) {
        return activeMemberDao.findByActiveAndClazz(id, clazz, (Page - 1) * num, num);
    }

    @Override
    public int findByActiveAndClazzCount(Integer id, String clazz) {
        return activeMemberDao.findByActiveAndClazzCount(id, clazz);
    }

    @Override
    public int insertData(Activemember activemember) {
        return activeMemberDao.insertData(activemember);
    }

    @Override
    public int insertDatas(List<Activemember> list) {
        return activeMemberDao.insertDatas(list);
    }

    @Override
    public int deleteData(Integer id) {
        return activeMemberDao.deleteData(id);
    }
}
