package com.SchoolManage.service;

import com.SchoolManage.dao.TalkMemberDao;
import com.SchoolManage.exception.FieldNotExistException;
import com.SchoolManage.pojo.TalkMember;
import com.SchoolManage.pojo.TalkType;
import com.SchoolManage.util.TableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
    public List<TalkMember> findByCodeAndType(String type, String code, String comy,Integer Page, Integer num) {
        return talkMemberDao.findByCodeAndType(type, code, comy,(Page - 1) * num, num);
    }

    @Override
    public int findByCodeAndTypeCount(String type, String code,String comy) {
        return talkMemberDao.findByCodeAndTypeCount(type, code,comy);
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
    public List<TalkMember> findByName(String type, String name,String comy, Integer Page, Integer num) {
        return talkMemberDao.findByName(type, name, comy,(Page - 1) * num, num);
    }

    @Override
    public int findByNameCount(String type, String name,String comy) {
        return talkMemberDao.findByNameCount(type, name,comy);
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

    @Override
    public int findBytypeCount(String type, String comy) {
        return talkMemberDao.findBytypeCount(type,comy);
    }

    @Override
    public int BatchAddition(String path,String type, String comy) {
        int num = 0;
        try {
            //path写实际path
            TableUtil<TalkMember> tableUtil = new TableUtil<TalkMember>(path,TalkMember.class);
            int i=talkMemberDao.findBytypeCount(type,comy);
            List<TalkMember> database = talkMemberDao.findBytype(type,comy,1,i);
            List<TalkMember> list = tableUtil.GetTableRowContent(database, comy);
            //调用插入接口
            //批量上传，list集合
            if (list.size() != 0) {
                num = talkMemberDao.insertDatas(list);

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
    public List<TalkMember> findBytype(String type, String comy, Integer Page, Integer num) {
        return talkMemberDao.findBytype(type,comy,(Page-1),num);
    }
}
