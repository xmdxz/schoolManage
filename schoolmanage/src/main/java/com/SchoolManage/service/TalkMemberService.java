package com.SchoolManage.service;

import com.SchoolManage.pojo.TalkMember;

import java.util.List;

/**
 * @Author RainGoal
 * @Description DOTO
 * @Date 2021/3/24
 * @Version 1.0
 */

public interface TalkMemberService {

    /**
     * 根据类型id查找
     *
     * @param type
     * @param Page
     * @param num
     * @return
     */
    List<TalkMember> findAll(String type, Integer Page, Integer num);

    /**
     * 查找数量
     *
     * @param id
     * @return
     */
    int findAllCount(String type);

    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    TalkMember findById(Integer id);

    /**
     * 学号
     *
     * @param type
     * @param code
     * @return
     */
    List<TalkMember> findByCodeAndType(String type, String code, Integer Page, Integer num);

    int findByCodeAndTypeCount(String type, String code);

    /**
     * 根据学号查找
     *
     * @param code
     * @return
     */
    List<TalkMember> findByCode(String code, Integer Page, Integer num);

    int findByCodeCount(String code);

    /**
     * 根据姓名
     *
     * @param type
     * @param name
     * @return
     */
    List<TalkMember> findByName(String type, String name, Integer Page, Integer num);

    int findByNameCount(String type, String name);

    /**
     * 更新
     *
     * @param talkMember
     * @return
     */
    int updateData(TalkMember talkMember);

    /**
     * 插入数据
     *
     * @param talkMember
     * @return
     */
    int insertData(TalkMember talkMember);

    /**
     * 批量插入数据
     *
     * @param list
     * @return
     */
    int insertDatas(List<TalkMember> list);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteData(Integer id);
}
