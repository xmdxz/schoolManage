package com.SchoolManage.service;

import com.SchoolManage.dao.QingJiaDao;
import com.SchoolManage.exception.FieldNotExistException;
import com.SchoolManage.pojo.Qingjia;
import com.SchoolManage.util.TableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.*;

/**
 * @Author RainGoal
 * @Date 2021/2/19 17:12
 * @Description TODO
 * @Version 1.0
 */
@Service
public class QingJiaServiceImpl implements QingJiaService {
    @Autowired
    private QingJiaDao qingJiaDao;


    @Override
    public List<Qingjia> findAll(String comy, Integer Page, Integer num) {
        return qingJiaDao.findAll(comy, (Page - 1) * num, num);
    }

    @Override
    public int findAllCount(String comy) {
        return qingJiaDao.findAllCount(comy);
    }

    @Override
    public List<Qingjia> findByStudentNoPage(String comy, String student) {
        return qingJiaDao.findByStudentNoPage(comy, student);
    }

    @Override
    public List<Qingjia> findByStudentPage(String comy, String student, Integer Page, Integer num) {
        return qingJiaDao.findByStudentPage(comy, student, (Page - 1) * num, num);
    }

    @Override
    public int findByStudentCount(String comy, String student) {
        return qingJiaDao.findByStudentCount(comy, student);
    }

    @Override
    public List<Qingjia> findByTimeYearAndMonthAndDay(String comy, Timestamp timestamp, Integer Page, Integer num) {
        return qingJiaDao.findByTimeYearAndMonthAndDay(comy, timestamp, (Page - 1) * num, num);
    }

    @Override
    public int findByTimeYearAndMonthAndDayCount(String comy, Timestamp timestamp) {
        return qingJiaDao.findByTimeYearAndMonthAndDayCount(comy, timestamp);
    }

    @Override
    public List<Qingjia> findByTimeYearAndMonth(String comy, Timestamp timestamp, Integer Page, Integer num) {
        return qingJiaDao.findByTimeYearAndMonth(comy, timestamp, (Page - 1) * num, num);
    }

    @Override
    public int findByTimeYearAndMonthCount(String comy, Timestamp timestamp) {
        return qingJiaDao.findByTimeYearAndMonthCount(comy, timestamp);
    }

    @Override
    public List<Qingjia> findByTimeYear(String comy, Timestamp timestamp, Integer Page, Integer num) {
        return qingJiaDao.findByTimeYear(comy, timestamp, (Page - 1) * num, num);
    }

    @Override
    public int findByTimeYearCount(String comy, Timestamp timestamp) {
        return qingJiaDao.findByTimeYearCount(comy, timestamp);
    }

    @Override
    public List<Qingjia> findByDate(Timestamp timestamp, String comy, Integer Page, Integer num) {
        return null;
    }

    @Override
    public int findByDateCount(Timestamp timestamp, String comy) {
        return 0;
    }

    @Override
    public List<Qingjia> findByTeacher(String comy, String teacher, Integer Page, Integer num) {
        return qingJiaDao.findByTeacher(comy, teacher, (Page - 1) * num, num);
    }

    @Override
    public int insertQingjia(Qingjia qingjia) {
        return qingJiaDao.insertQingjia(qingjia);
    }

    @Override
    public int insertQingjias(List<Qingjia> list) {
        return qingJiaDao.insertQingjias(list);
    }

    @Override
    public int deleteQingjia(Integer id) {
        return qingJiaDao.deleteQingjia(id);
    }


    @Override
    public List<Qingjia> findByName(String comy, String name, Integer Page, Integer num) {
        return qingJiaDao.findByName(comy, name, (Page - 1) * num, num);
    }

    @Override
    public int findByNameCount(String comy, String name) {
        return qingJiaDao.findByNameCount(comy, name);
    }

    @Override
    public List<Qingjia> findByClazz(String comy, String clazz, Integer Page, Integer num) {
        return qingJiaDao.findByClazz(comy, clazz, (Page - 1) * num, num);
    }

    @Override
    public int findByClazzCount(String comy, String clazz) {
        return 0;
    }

    @Override
    public int BatchAddition(String path, String comy) {
        int num = 0;
        try {
            //path写实际path
            TableUtil<Qingjia> tableUtil = new TableUtil<Qingjia>(path, Qingjia.class);

            List<Qingjia> list = tableUtil.GetTableRowContent(comy);
            //调用插入接口
            //批量上传，list集合
            if (list.size() != 0) {
                num = qingJiaDao.insertQingjias(list);

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

    @Override
    public int updateQingJia(Qingjia qingjia) {
        return qingJiaDao.updateQingJia(qingjia);
    }

    @Override
    public Qingjia findById(int id) {
        return qingJiaDao.findById(id);
    }

    @Override
    public int findByNow_time(String comy) {
        return qingJiaDao.findByNow_time(comy);
    }

    @Override
    public Map<String, List<Qingjia>> findBYweek_time(String comy) {
        List<Qingjia> qingjias = qingJiaDao.findBYweek_time(comy);
        List<Qingjia> qingjias0=new ArrayList<>();
        List<Qingjia> qingjias1=new ArrayList<>();
        List<Qingjia> qingjias2=new ArrayList<>();
        List<Qingjia> qingjias3=new ArrayList<>();
        List<Qingjia> qingjias4=new ArrayList<>();
        List<Qingjia> qingjias5=new ArrayList<>();
        List<Qingjia> qingjias6=new ArrayList<>();
        HashMap<String, List<Qingjia>> map = new HashMap<>();
        String[] weekDays = {"周日","周一","周二", "周三","周四", "周五","周六"};
        Calendar calendar = Calendar.getInstance();
        for (Qingjia q : qingjias
        ) {
            calendar.setTime(q.getStart_time());
            int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
            if (w < 0)
                w = 0;
            if(w==0)
            {
               qingjias0.add(q);
            }
            if(w==1)
            {
                qingjias1.add(q);
            }
            if(w==2)
            {
                qingjias2.add(q);
            }
            if(w==3)
            {
                qingjias3.add(q);
            }
            if(w==4)
            {
                qingjias4.add(q);
            }
            if(w==5)
            {
                qingjias5.add(q);
            }
            if(w==6)
            {
                qingjias6.add(q);
            }
        }
        map.put(weekDays[0],qingjias0);
        map.put(weekDays[1],qingjias1);
        map.put(weekDays[2],qingjias2);
        map.put(weekDays[3],qingjias3);
        map.put(weekDays[4],qingjias4);
        map.put(weekDays[5],qingjias5);
        map.put(weekDays[6],qingjias6);
        return map;
    }

    @Override
    public List<Qingjia> findBystart_time(String comy, String time,Integer Page, Integer num) {
        return qingJiaDao.findBystart_time(comy,time,Page-1,num);
    }

    @Override
    public List<Qingjia> findByend_time(String comy, String time, Integer Page, Integer num) {
        return qingJiaDao.findByend_time(comy,time,Page-1,num);
    }

    @Override
    public int findBystart_timeCount(String comy, String time) {
        return qingJiaDao.findBystart_timeCount(comy,time);
    }

    @Override
    public int findByend_timeCount(String comy, String time) {
        return qingJiaDao.findByend_timeCount(comy,time);
    }
}
