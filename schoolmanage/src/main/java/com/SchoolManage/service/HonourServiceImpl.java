package com.SchoolManage.service;

import com.SchoolManage.dao.HonourDao;
import com.SchoolManage.exception.FieldNotExistException;
import com.SchoolManage.pojo.Honour;
import com.SchoolManage.util.TableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.text.ParseException;
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
    public List<Honour> findByName(String comy, String name, Integer startPage, Integer num) {
        return honourDao.findByName(comy, name, startPage - 1, num);
    }

    @Override
    public int findByNameCount(String comy, String name) {
        return honourDao.findByNameCount(comy, name);
    }

    @Override
    public List<Honour> findAll(String comy, Integer Page, Integer num) {
        return honourDao.findAll(comy, (Page - 1) * num, num);
    }

    @Override
    public int findAllCount(String comy) {
        return honourDao.findAllCount(comy);
    }

    @Override
    public List<Honour> findByStudentPage(String comy, String student, Integer Page, Integer num) {
        return honourDao.findByStudentPage(comy, student, (Page - 1) * num, num);
    }

    @Override
    public List<Honour> findByStudentNoPage(String comy, String student) {
        return honourDao.findByStudentNoPage(comy, student);
    }

    @Override
    public int findByStudentCount(String comy, String student) {
        return honourDao.findByStudentCount(comy, student);
    }

    @Override
    public List<Honour> findByType(String comy, String Type, Integer Page, Integer num) {
        return honourDao.findByType(comy, Type, (Page - 1) * num, num);
    }

    @Override
    public int findByTypeCount(String comy, String type) {
        return honourDao.findByTypeCount(comy, type);
    }

    @Override
    public List<Honour> findByPrize(String comy, String prize, Integer Page, Integer num) {
        return honourDao.findByPrize(comy, prize, (Page - 1) * num, num);
    }

    @Override
    public int findByPrizeCount(String comy, String prize) {
        return honourDao.findByPrizeCount(comy, prize);
    }

    @Override
    public List<Honour> findByDate(String comy, Date date, Integer Page, Integer num) {
        return honourDao.findByDate(comy, date, (Page - 1) * num, num);
    }

    @Override
    public int findByDateCount(String comy, Date date) {
        return honourDao.findByDateCount(comy, date);
    }

    @Override
    public List<Honour> findByTime(String comy, Date time, Integer Page, Integer num) {
        return honourDao.findByTime(comy, time, (Page - 1) * num, num);
    }

    @Override
    public int findByTimeCount(String comy, Date time) {
        return honourDao.findByTimeCount(comy, time);
    }

    @Override
    public List<Honour> findByTimeYearAndMonth(String comy, Date time, Integer Page, Integer num) {
        return honourDao.findByTimeYearAndMonth(comy, time, (Page - 1) * num, num);
    }

    @Override
    public int findByTimeYearAndMonthCount(String comy, Date time) {
        return honourDao.findByTimeYearAndMonthCount(comy, time);
    }

    @Override
    public List<Honour> findByTimeYear(String comy, Date time, Integer Page, Integer num) {
        return honourDao.findByTimeYear(comy, time, (Page - 1) * num, num);
    }

    @Override
    public int findByTimeYearCount(String comy, Date time) {
        return honourDao.findByTimeYearCount(comy, time);
    }

    @Override
    public List<Honour> findByConditions(String comy, Map<String, String> map, Integer Page, Integer num) {
        return honourDao.findByConditions(comy, map, (Page - 1) * num, num);
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
    public int updateHonour(Honour honour) {
        return honourDao.updateHonour(honour);
    }

    @Override
    public Honour findById(int id) {
        return honourDao.findById(id);
    }

    @Override
    public int BatchAddition(String path, String comy) {
        int num = 0;
        try {
            //path写实际path
            TableUtil<Honour> tableUtil = new TableUtil<Honour>(path, Honour.class);

            List<Honour> list = tableUtil.GetTableRowContent(comy);
            //调用插入接口
            //批量上传，list集合
            if (list.size() != 0) {
                num = honourDao.insertHons(list);

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
