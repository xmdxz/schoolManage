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
    public List<Talk> findAll(String comy) {
        return talkDao.findAll(comy);
    }

//    @Override
//    public int findAllCount(String comy,String teacher) {
//        return talkDao.findAllCount(comy,teacher);
//    }

    @Override
    public int insertTalk(Talk talk) {
        return talkDao.insertTalk(talk);
    }

    @Override
    public List<Talk> findByStudent(String student) {
        return null;
    }

    @Override
    public List<Talk> findByDate(Date date) {
        return null;
    }

//    @Override
//    public List<Talk> findByStudentNoPage(String comy,String student,String teacher) {
//        return talkDao.findByStudentNoPage(comy,student,teacher);
//    }


    @Override
    public int findByStudentCount(String student) {
        return talkDao.findByStudentCount(student);
    }

    @Override
    public List<Talk> findByTeacher(String comy, String teacher) {
        return talkDao.findByTeacher(comy, teacher);
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
    public List<Talk> findByTime(String comy, Date date) {
        return talkDao.findByTime(comy, date);
    }


    @Override
    public List<Talk> findByTimeYearAndMonth(String comy, Date date) {
        return talkDao.findByTimeYearAndMonth(comy, date);
    }

    @Override
    public List<Talk> findByTimeYear(String comy, Date date) {
        return null;
    }

    @Override
    public Talk findById(Integer id) {
        return talkDao.findById(id);
    }

    @Override
    public List<Talk> findByTypes(String types) {
        return talkDao.findByTypes(types);
    }

    @Override
    public List<Talk> findByDateAndTypesAndLevel(Date time, String types, String level, String comy) {
        return talkDao.findByDateAndTypesAndLevel(time, types, level, comy);
    }

    @Override
    public int updata(Talk talk) {
        return talkDao.updata(talk);
    }
}
