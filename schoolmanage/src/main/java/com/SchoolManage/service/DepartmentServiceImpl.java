package com.SchoolManage.service;

import com.SchoolManage.pojo.DepartMent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author RainGoal
 * @Date 2021/2/5 16:52
 * @Description TODO
 * @Version 1.0
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentService departmentService;

    @Override
    public List<DepartMent> findAll(int Page, int num) {
        int startPage = (Page-1)*num;
        return departmentService.findAll(startPage, num);
    }

    @Override
    public int findAllNum() {
        return departmentService.findAllNum();
    }

    @Override
    public List<DepartMent> findByName(String name, int Page, int num) {
        int startPage = (Page-1)*num;
        return departmentService.findByName(name,startPage,num);
    }

    @Override
    public DepartMent findById(Integer id) {
        return departmentService.findById(id);
    }

    @Override
    public int findByNameNum(String name) {
        return departmentService.findByNameNum(name);
    }

    @Override
    public List<DepartMent> findByMinister(String Minister, int Page, int num) {
        int startPage = (Page-1)*num;
        return departmentService.findByMinister(Minister,startPage,num);
    }

    @Override
    public int findByMinisterNum(String minister) {
        return departmentService.findByMinisterNum(minister);
    }

    @Override
    public List<DepartMent> findByCollege(String college, int Page, int num) {
        int startPage = (Page-1)*num;
        return departmentService.findByCollege(college,startPage,num);
    }

    @Override
    public int findByCollegeNum(String college) {
        return departmentService.findByCollegeNum(college);
    }

    @Override
    public int insertData(DepartMent departMent) {
        return departmentService.insertData(departMent);
    }

    @Override
    public int insertDatas(List<DepartMent> departMents) {
        return departmentService.insertDatas(departMents);
    }

    @Override
    public int updateData(DepartMent departMent) {
        return departmentService.updateData(departMent);
    }

    @Override
    public int deleteData(Integer id) {
        return departmentService.deleteData(id);
    }
}
