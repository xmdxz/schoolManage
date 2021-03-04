package com.SchoolManage.service;

import com.SchoolManage.dao.ActiveMemberDao;
import com.SchoolManage.exception.FieldNotExistException;
import com.SchoolManage.pojo.Activemember;
import com.SchoolManage.util.TableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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

    @Override
    public int findByNameCount(String name, Integer activity) {
        return activeMemberDao.findByNameCount(name, activity);
    }

    @Override
    public List<Activemember> findByName(String name, Integer activity, int startPage, int num) {
        return activeMemberDao.findByName(name, activity, startPage - 1, num);
    }

    @Override
    public Activemember findByStudent(String student, Integer activity) {
        return activeMemberDao.findByStudent(student, activity);
    }

    @Override
    public int updateDara(Activemember activemember) {
        return activeMemberDao.updateDara(activemember);
    }

    @Override
    public int BatchAddition(String path) {
        int num = 0;
        try {
            //path写实际path
            TableUtil<Activemember> tableUtil = new TableUtil<Activemember>(path, Activemember.class);
            System.out.println(tableUtil);
            List<Activemember> list = tableUtil.GetTableRowContent();
            System.out.println(list);
            //调用插入接口
            //批量上传，list集合
            if (list.size() != 0) {
                num = activeMemberDao.insertDatas(list);

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
