package com.SchoolManage.util;

import com.SchoolManage.dao.TalkTypeDao;
import com.SchoolManage.pojo.TalkType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TypeTo {

    private static TalkTypeDao talkTypeDao;

    @Autowired
    public void setTalkTypeDao(TalkTypeDao talkTypeDao) {
        TypeTo.talkTypeDao = talkTypeDao;
    }

    public static Integer getTypeTo(String typeName, String comy) {
        List<TalkType> list = talkTypeDao.findAllNoPage(comy);
        return list.get(list.indexOf(new TalkType(typeName, comy))).getId();
    }
}
