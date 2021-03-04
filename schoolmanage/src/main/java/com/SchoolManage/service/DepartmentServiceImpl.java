package com.SchoolManage.service;

import com.SchoolManage.dao.DepartMentDao;
import com.SchoolManage.exception.FieldNotExistException;
import com.SchoolManage.pojo.DepartMent;
import com.SchoolManage.util.TableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
    private DepartMentDao departMentDao;

    @Override
    public List<DepartMent> findAll(int Page, int num) {
        int startPage = (Page - 1) * num;
        return departMentDao.findAll(startPage, num);
    }

    @Override
    public int findAllNum() {
        return departMentDao.findAllNum();
    }

    @Override
    public List<DepartMent> findByName(String name, int Page, int num) {
        int startPage = (Page - 1) * num;
        return departMentDao.findByName(name, startPage, num);
    }

    @Override
    public DepartMent findById(Integer id) {
        return departMentDao.findById(id);
    }

    @Override
    public int findByNameNum(String name) {
        return departMentDao.findByNameNum(name);
    }

    @Override
    public List<DepartMent> findByMinister(String Minister, int Page, int num) {
        int startPage = (Page - 1) * num;
        return departMentDao.findByMinister(Minister, startPage, num);
    }

    @Override
    public int findByMinisterNum(String minister) {
        return departMentDao.findByMinisterNum(minister);
    }

    @Override
    public List<DepartMent> findByCollege(String college, int Page, int num) {
        int startPage = (Page - 1) * num;
        return departMentDao.findByCollege(college, startPage, num);
    }

    @Override
    public int findByCollegeNum(String college) {
        return departMentDao.findByCollegeNum(college);
    }

    @Override
    public int insertData(DepartMent departMent) {
        return departMentDao.insertData(departMent);
    }

    @Override
    public int insertDatas(List<DepartMent> departMents) {
        return departMentDao.insertDatas(departMents);
    }

    @Override
    public int updateData(DepartMent departMent) {
        return departMentDao.updateData(departMent);
    }

    @Override
    public int deleteData(Integer id) {
        return departMentDao.deleteData(id);
    }

    @Override
    public int BatchAddition(String path) {
        int num = 0;
        try {
            //path写实际path
            TableUtil<DepartMent> tableUtil = new TableUtil<DepartMent>(path, DepartMent.class);
            List<DepartMent> list = tableUtil.GetTableRowContent();
            //调用插入接口
            //批量上传，list集合
            if (list.size() != 0) {
                num = departMentDao.insertDatas(list);

            }
        } catch (IOException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchFieldException e) {
            e.printStackTrace();
            return -2;
        } catch (FieldNotExistException e) {
            //此处应处理表格问题，返回前端
            e.printStackTrace();
            return -3;
        }
        return num;
    }
}
