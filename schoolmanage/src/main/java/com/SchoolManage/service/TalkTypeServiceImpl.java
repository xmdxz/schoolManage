package com.SchoolManage.service;

import com.SchoolManage.dao.TalkTypeDao;
import com.SchoolManage.pojo.TalkType;
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
public class TalkTypeServiceImpl implements TalkTypeService {
    @Autowired
    private TalkTypeDao talkTypeDao;

    @Override
    public List<String> getType() {
        return talkTypeDao.getType();
    }

    @Override
    public List<TalkType> findAll(String comy, Integer Page, Integer num) {
        return talkTypeDao.findAll(comy, (Page - 1) * num, num);
    }

    @Override
    public int findAllCount(String comy) {
        return talkTypeDao.findAllCount(comy);
    }

    @Override
    public TalkType findById(Integer id) {
        return talkTypeDao.findById(id);
    }

    @Override
    public List<TalkType> findByType(String comy, String type, Integer Page, Integer num) {
        return talkTypeDao.findByType(comy, type, (Page - 1) * num, num);
    }

    @Override
    public int findByTypeCount(String comy, String type) {
        return talkTypeDao.findByTypeCount(comy, type);
    }

    @Override
    public int updateData(TalkType talkType) {
        return talkTypeDao.updateData(talkType);
    }

    @Override
    public int insertData(TalkType talkType) {
        return talkTypeDao.insertData(talkType);
    }

    @Override
    public int insertDatas(List<TalkType> list) {
        return talkTypeDao.insertDatas(list);
    }

    @Override
    public int deleteData(Integer id) {
        return talkTypeDao.deleteData(id);
    }
}
