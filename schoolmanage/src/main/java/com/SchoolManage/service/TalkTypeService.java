package com.SchoolManage.service;

import com.SchoolManage.pojo.TalkType;

import java.util.List;

/**
 * @Author RainGoal
 * @Description DOTO
 * @Date 2021/3/24
 * @Version 1.0
 */

public interface TalkTypeService {

    /**
     * 获取类型
     *
     * @return
     */
    List<String> getType();

    /**
     * 查询全部
     *
     * @param Page
     * @param num
     * @return
     */
    List<TalkType> findAll(String comy, Integer Page, Integer num);

    /**
     * 查询全部数量
     *
     * @return
     */
    int findAllCount(String comy);

    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    TalkType findById(Integer id);

    /**
     * 根据类型查找
     *
     * @param type
     * @param Page
     * @param num
     * @return
     */
    List<TalkType> findByType(String comy, String type, Integer Page, Integer num);

    /**
     * 根据类型查找数量
     *
     * @param type
     * @return
     */
    int findByTypeCount(String comy, String type);

    /**
     * 更新
     *
     * @param talkType
     * @return
     */
    int updateData(TalkType talkType);

    /**
     * 单条插入
     *
     * @param talkType
     * @return
     */
    int insertData(TalkType talkType);

    /**
     * 多条插入
     *
     * @param list
     * @return
     */
    int insertDatas(List<TalkType> list);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteData(Integer id);
}
