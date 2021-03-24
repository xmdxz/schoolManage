package com.SchoolManage.service;

import com.SchoolManage.dao.TalkMemberDao;
import com.SchoolManage.pojo.TalkMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author RainGoal
 * @Description DOTO
 * @Date 2021/3/24
 * @Version 1.0
 */
@Service
public class TalkMemberServiceImpl implements TalkMemberService {
    @Autowired
    private TalkMemberDao talkMemberDao;


    @Override
    public List<TalkMember> findAll(String type, Integer Page, Integer num) {
        return talkMemberDao.findAll(type, (Page - 1) * num, num);
    }

    @Override
    public int findAllCount(String type) {
        return talkMemberDao.findAllCount(type);
    }

    @Override
    public TalkMember findById(Integer id) {
        return talkMemberDao.findById(id);
    }

    @Override
    public List<TalkMember> findByCodeAndType(String type, String code, Integer Page, Integer num) {
        return talkMemberDao.findByCodeAndType(type, code, (Page - 1) * num, num);
    }

    @Override
    public int findByCodeAndTypeCount(String type, String code) {
        return talkMemberDao.findByCodeAndTypeCount(type, code);
    }

    @Override
    public List<TalkMember> findByCode(String code, Integer Page, Integer num) {
        return talkMemberDao.findByCode(code, (Page - 1) * num, num);
    }

    @Override
    public int findByCodeCount(String code) {
        return talkMemberDao.findByCodeCount(code);
    }

    @Override
    public List<TalkMember> findByName(String type, String name, Integer Page, Integer num) {
        return talkMemberDao.findByName(type, name, (Page - 1) * num, num);
    }

    @Override
    public int findByNameCount(String type, String name) {
        return talkMemberDao.findByNameCount(type, name);
    }

    @Override
    public int updateData(TalkMember talkMember) {
        return talkMemberDao.updateData(talkMember);
    }

    @Override
    public int insertData(TalkMember talkMember) {
        return talkMemberDao.insertData(talkMember);
    }

    @Override
    public int insertDatas(List<TalkMember> list) {
        return talkMemberDao.insertDatas(list);
    }

    @Override
    public int deleteData(Integer id) {
        return talkMemberDao.deleteData(id);
    }
}
