package com.SchoolManage.service;

import com.SchoolManage.dao.TalkDao;
import com.SchoolManage.dao.TalkService;
import com.SchoolManage.pojo.Talk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * @Author RainGoal
 * @Date 2021/2/19 11:56
 * @Description TODO
 * @Version 1.0
 */
@Service
public class TalkServiceImpl implements TalkService {
    @Autowired
    private TalkDao talkDao;


    @Override
    public List<Talk> findAll(String comy) {
        return talkDao.findAll(comy);
    }

    @Override
    public int findAllCount(String comy) {
        return talkDao.findAllCount(comy);
    }

    @Override
    public List<Talk> findAllPage(String comy, Integer Page, Integer num) {
        return talkDao.findAllPage(comy, (Page - 1) * num, num);
    }

    @Override
    public int insertTalk(Talk talk) {
        return talkDao.insertTalk(talk);
    }

    @Override
    public List<Talk> findByStudent(String comy, String student, Integer Page, Integer num) {
        return talkDao.findByStudent(comy, student, (Page - 1) * num, num);
    }

    @Override
    public List<Talk> findByDate(String comy, Date date, Integer Page, Integer num) {
        return talkDao.findByDate(comy, date, (Page - 1) * num, num);
    }

    @Override
    public int findByDateCount(String comy, Date date) {
        return talkDao.findByDateCount(comy, date);
    }

    @Override
    public int findByStudentCount(String student) {
        return talkDao.findByStudentCount(student);
    }

    @Override
    public List<Talk> findByTeacher(String comy, String teacher, Integer Page, Integer num) {
        return talkDao.findByTeacher(comy, teacher, (Page - 1) * num, num);
    }

    @Override
    public int findByTeacherCount(String comy, String teacher) {
        return talkDao.findByTeacherCount(comy, teacher);
    }

    @Override
    public int deleteTalk(Integer id) {
        return talkDao.deleteTalk(id);
    }

    @Override
    public int insertAllTalk(List<Talk> list) {
        return talkDao.insertAllTalk(list);
    }

    @Override
    public List<Talk> findByTime(String comy, Date date, Integer Page, Integer num) {
        return talkDao.findByTime(comy, date, (Page - 1) * num, num);
    }

    @Override
    public int findByTimeCount(String comy, Date date) {
        return talkDao.findByTimeCount(comy, date);
    }

    @Override
    public List<Talk> findByTimeYearAndMonth(String comy, Date date, Integer Page, Integer num) {
        return talkDao.findByTimeYearAndMonth(comy, date, (Page - 1) * num, num);
    }

    @Override
    public int findByTimeYearAndMonthCount(String comy, Date date) {
        return talkDao.findByTimeYearAndMonthCount(comy, date);
    }

    @Override
    public List<Talk> findByTimeYear(String comy, Date date, String name, Integer Page, Integer num) {
        return talkDao.findByTimeYear(comy, date, name, (Page - 1) * num, num);
    }

    @Override
    public int findByTimeYearCount(String comy, Date date) {
        return talkDao.findByTimeYearCount(comy, date);
    }

    @Override
    public Talk findById(Integer id, String comy) {
        return talkDao.findById(id, comy);
    }

    @Override
    public List<Talk> findByTypes(String types, String comy, Integer Page, Integer num) {
        return talkDao.findByTypes(types, comy, (Page - 1) * num, num);
    }

    @Override
    public int findByTypesCount(String types, String comy) {
        return talkDao.findByTypesCount(types, comy);
    }

    @Override
    public List<Talk> findByDateAndTypesAndLevel(Date time, String types, String level, String comy, Integer Page, Integer num) {
        return talkDao.findByDateAndTypesAndLevel(time, types, level, comy, (Page - 1) * num, num);
    }

    @Override
    public int findByDateAndTypesAndLevelCount(Date time, String types, String level, String comy) {
        return talkDao.findByDateAndTypesAndLevelCount(time, types, level, comy);
    }

    @Override
    public int updata(Talk talk) {
        return talkDao.updata(talk);
    }
}
