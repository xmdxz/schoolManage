package com.SchoolManage.service;

import com.SchoolManage.dao.HonourDao;
import com.SchoolManage.exception.FieldNotExistException;
import com.SchoolManage.pojo.Honour;
import com.SchoolManage.pojo.Qingjia;
import com.SchoolManage.util.TableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author RainGoal
 * @Date 2021/2/18 11:23
 * @Description TODO
 * @Version 1.0
 */
@Service
public class HonourServiceImpl implements HonourService {
    @Autowired
    private HonourDao honourDao;

    @Override
    public List<Honour> findByName(String name, Integer startPage, Integer num) {
        return honourDao.findByName(name,startPage-1,num);
    }

    @Override
    public int findByNameCount(String name) {
        return honourDao.findByNameCount(name);
    }

    @Override
    public List<Honour> findAll(Integer Page, Integer num) {
        return honourDao.findAll((Page - 1) * num, num);
    }

    @Override
    public int findAllCount() {
        return honourDao.findAllCount();
    }

    @Override
    public List<Honour> findByStudentPage(String student, Integer Page, Integer num) {
        return honourDao.findByStudentPage(student, (Page - 1) * num, num);
    }

    @Override
    public List<Honour> findByStudentNoPage(String student) {
        return honourDao.findByStudentNoPage(student);
    }

    @Override
    public int findByStudentCount(String student) {
        return honourDao.findByStudentCount(student);
    }

    @Override
    public List<Honour> findByType(String Type, Integer Page, Integer num) {
        return honourDao.findByType(Type, (Page - 1) * num, num);
    }

    @Override
    public int findByTypeCount(String type) {
        return honourDao.findByTypeCount(type);
    }

    @Override
    public List<Honour> findByPrize(String prize, Integer Page, Integer num) {
        return honourDao.findByPrize(prize, (Page - 1) * num, num);
    }

    @Override
    public int findByPrizeCount(String prize) {
        return honourDao.findByPrizeCount(prize);
    }

    @Override
    public List<Honour> findByTime(Date time, Integer Page, Integer num) {
        return honourDao.findByTime(time, (Page - 1) * num, num);
    }

    @Override
    public int findByTimeCount(Date time) {
        return honourDao.findByTimeCount(time);
    }

    @Override
    public List<Honour> findByTimeYearAndMonth(Date time, Integer Page, Integer num) {
        return honourDao.findByTimeYearAndMonth(time, (Page - 1) * num, num);
    }

    @Override
    public int findByTimeYearAndMonthCount(Date time) {
        return honourDao.findByTimeYearAndMonthCount(time);
    }

    @Override
    public List<Honour> findByTimeYear(Date time, Integer Page, Integer num) {
        return honourDao.findByTimeYear(time, (Page - 1) * num, num);
    }

    @Override
    public int findByTimeYearCount(Date time) {
        return honourDao.findByTimeYearCount(time);
    }

    @Override
    public List<Honour> findByConditions(Map<String, String> map, Integer Page, Integer num) {
        return honourDao.findByConditions(map, (Page - 1) * num, num);
    }

    @Override
    public int insertHon(Honour honour) {
        return honourDao.insertHon(honour);
    }

    @Override
    public int insertHons(List<Honour> honours) {
        return honourDao.insertHons(honours);
    }

    @Override
    public int deleteHon(Integer id) {
        return honourDao.deleteHon(id);
    }
    @Override
    public int BatchAddition(String path) {
        int num = 0;
        try {
            //path写实际path
            TableUtil<Honour> tableUtil = new TableUtil<Honour>(path, Honour.class);

            List<Honour> list = tableUtil.GetTableRowContent();
            //调用插入接口
            //批量上传，list集合
            num = honourDao.insertHons(list);
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
