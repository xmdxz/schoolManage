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
    public List<Talk> findAll(String comy, Integer Page, String teacher) {
        return talkDao.findAll(comy, (Page - 1) * 20, 20, teacher);
    }

//    @Override
//    public int findAllCount(String comy,String teacher) {
//        return talkDao.findAllCount(comy,teacher);
//    }

    @Override
    public int insertTalk(Talk talk) {
        return talkDao.insertTalk(talk);
    }

//    @Override
//    public List<Talk> findByStudentNoPage(String comy,String student,String teacher) {
//        return talkDao.findByStudentNoPage(comy,student,teacher);
//    }

    @Override
    public List<Talk> findByStudentPage(String student, Integer Page, String teacher) {
        return talkDao.findByStudentPage(student, (Page - 1) * 20, 20, teacher);
    }

    @Override
    public int findByStudentCount(String student, String teacher) {
        return talkDao.findByStudentCount(student, teacher);
    }

    @Override
    public List<Talk> findByTeacher(String teacher, Integer Page, Integer num) {
        return talkDao.findByTeacher(teacher, (Page - 1) * num, num);
    }

    @Override
    public int deleteTalk(Integer id, String teacher) {
        return talkDao.deleteTalk(id, teacher);
    }

    @Override
    public int insertAllTalk(List<Talk> list) {
        return talkDao.insertAllTalk(list);
    }

    @Override
    public List<Talk> findByTime(Date date, Integer Page, Integer num) {
        return talkDao.findByTime(date, (Page - 1) * 50, 50);
    }

    @Override
    public int findByTimeCount(Date date, String teacher) {
        return talkDao.findByTimeCount(date, teacher);
    }

    @Override
    public List<Talk> findByTimeYearAndMonth(Date date, Integer Page, Integer num) {
        return talkDao.findByTimeYearAndMonth(date, (Page - 1) * num, num);
    }

    @Override
    public int findByTimeYearAndMonthCount(Date date) {
        return talkDao.findByTimeYearAndMonthCount(date);
    }

    @Override
    public Talk findById(Integer id) {
        return talkDao.findById(id);
    }

    @Override
    public int updata(Talk talk) {
        return talkDao.updata(talk);
    }
}
