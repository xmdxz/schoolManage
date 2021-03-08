package com.SchoolManage.service;

import com.SchoolManage.dao.DormitoryDao;
import com.SchoolManage.exception.FieldNotExistException;
import com.SchoolManage.pojo.Dormitory;
import com.SchoolManage.pojo.Student;
import com.SchoolManage.util.TableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;

/**
 * @Author RainGoal
 * @Date 2021/2/8 13:49
 * @Description TODO
 * @Version 1.0
 */
@Service
public class DormitoryServiceImpl implements DormitoryService {
    @Autowired
    private DormitoryDao dormitoryDao;

    @Override
    public List<Student> findDormitoryMember(Dormitory dormitory, int Page, int num) {
        return dormitoryDao.findDormitoryMember(dormitory, (Page - 1) * num, num);
    }

    @Override
    public int findDormitoryMemberNum(Dormitory dormitory) {
        return dormitoryDao.findDormitoryMemberNum(dormitory);
    }

    @Override
    public List<Dormitory> findAll(String comy, int Page, int num) {
        return dormitoryDao.findAll(comy, (Page - 1) * num, num);
    }

    @Override
    public int findAllNum(String comy) {
        return dormitoryDao.findAllNum(comy);
    }

    @Override
    public List<Dormitory> findByName(String comy, String name, int Page, int num) {
        return dormitoryDao.findByName(comy, name, (Page - 1) * num, num);
    }

    @Override
    public int findByNameNum(String comy, String name) {
        return dormitoryDao.findByNameNum(comy, name);
    }

    @Override
    public Dormitory findById(String id) {
        return dormitoryDao.findById(id);
    }

    @Override
    public List<Dormitory> findByBuilding(String comy, String building, int Page, int num) {
        return dormitoryDao.findByBuilding(comy, building, (Page - 1) * num, num);
    }

    @Override
    public int findByBuildingNum(String comy, String building) {
        return dormitoryDao.findByBuildingNum(comy, building);
    }

    @Override
    public List<Dormitory> findByNumber(String comy, String number, int Page, int num) {
        return dormitoryDao.findByNumber(comy, number, (Page - 1) * num, num);
    }

    @Override
    public int findByNumberNum(String comy, String number) {
        return dormitoryDao.findByNumberNum(comy, number);
    }

    @Override
    public Dormitory findByBuildingAndNumber(String building, String number) {
        return dormitoryDao.findByBuildingAndNumber(building, number);
    }

    @Override
    public int insertData(Dormitory dormitory) {
        return dormitoryDao.insertData(dormitory);
    }

    @Override
    public int insertDatas(List<Dormitory> list) {
        return dormitoryDao.insertDatas(list);
    }

    @Override
    public int deleteData(String building, String number) {
        return dormitoryDao.deleteData(building, number);
    }

    @Override
    public int updateData(Dormitory dormitory) {
        return dormitoryDao.updateData(dormitory);
    }

    @Override
    public int BatchAddition(String comy, String path) {
        int num = 0;
        try {
            //path写实际path
            TableUtil<Dormitory> tableUtil = new TableUtil<Dormitory>(path, Dormitory.class);
            List<Dormitory> database = dormitoryDao.findAllNoPage(comy);
            List<Dormitory> list = tableUtil.GetTableRowContent(database, comy);
            //调用插入接口
            //批量上传，list集合
            if (list.size() != 0) {
                num = dormitoryDao.insertDatas(list);
            }
        } catch (IOException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchFieldException e) {
            e.printStackTrace();
            return -2;
        } catch (FieldNotExistException e) {
            //此处应处理表格问题，返回前端
            e.printStackTrace();
            return -3;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return num;
    }
}
