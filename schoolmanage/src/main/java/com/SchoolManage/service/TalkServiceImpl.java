package com.SchoolManage.service;

import com.SchoolManage.dao.TalkDao;
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
    public List<Talk> findAll(Integer Page, Integer num) {
        return talkDao.findAll((Page - 1) * num, num);
    }

    @Override
    public int findAllCount() {
        return talkDao.findAllCount();
    }

    @Override
    public int insertTalk(Talk talk) {
        return talkDao.insertTalk(talk);
    }

    @Override
    public List<Talk> findByStudentNoPage(String student) {
        return talkDao.findByStudentNoPage(student);
    }

    @Override
    public List<Talk> findByStudentPage(String student, Integer Page, Integer num) {
        return talkDao.findByStudentPage(student, (Page - 1) * num, num);
    }

    @Override
    public int findByStudentCount(String student) {
        return talkDao.findByStudentCount(student);
    }

    @Override
    public List<Talk> findByTeacher(String teacher, Integer Page, Integer num) {
        return talkDao.findByTeacher(teacher, (Page - 1) * num, num);
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
    public List<Talk> findByTime(Date date, Integer Page, Integer num) {
        return talkDao.findByTime(date, (Page - 1) * num, num);
    }

    @Override
    public int findByTimeCount(Date date) {
        return talkDao.findByTimeCount(date);
    }

    @Override
    public List<Talk> findByTimeYearAndMonth(Date date, Integer Page, Integer num) {
        return talkDao.findByTimeYearAndMonth(date, (Page - 1) * num, num);
    }

    @Override
    public int findByTimeYearAndMonthCount(Date date) {
        return talkDao.findByTimeYearAndMonthCount(date);
    }
}
