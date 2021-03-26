package com.SchoolManage.dao;

import com.SchoolManage.pojo.TalkMember;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TalkMemberDao {

    /**
     * 通过前端输入type获取对应数据库具体id
     *
     * @param type
     * @param comy
     * @return
     */
    Integer findByTypeDatabase(@Param(value = "type") String type, @Param(value = "comy") String comy);

    /**
     * 根据类型id查找
     *
     * @param type
     * @param startPage
     * @param num
     * @return
     */
    List<TalkMember> findAll(@Param(value = "type") Integer type, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 查找数量
     *
     * @param id
     * @return
     */
    int findAllCount(@Param(value = "type") Integer type);

    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    TalkMember findById(@Param(value = "id") Integer id);

    int findBytypeCount(@Param(value = "type") Integer type);

    List<TalkMember> findBytype(@Param(value = "type") Integer type, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 学号
     *
     * @param type
     * @param code
     * @return
     */
    List<TalkMember> findByCodeAndType(@Param(value = "type") Integer type, @Param(value = "code") String code, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    int findByCodeAndTypeCount(@Param(value = "type") Integer type, @Param(value = "code") String code);

    /**
     * 根据学号查找
     *
     * @param code
     * @return
     */
    List<TalkMember> findByCode(@Param(value = "code") String code, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    int findByCodeCount(@Param(value = "code") String code);

    /**
     * 根据姓名
     *
     * @param type
     * @param name
     * @return
     */
    List<TalkMember> findByName(@Param(value = "type") Integer type, @Param(value = "name") String name, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    int findByNameCount(@Param(value = "type") Integer type, @Param(value = "name") String name);

    /**
     * 更新
     *
     * @param talkMember
     * @return
     */
    int updateData(@Param(value = "talkMember") TalkMember talkMember);

    /**
     * 插入数据
     *
     * @param talkMember
     * @return
     */
    int insertData(@Param(value = "talkMember") TalkMember talkMember);

    /**
     * 批量插入数据
     *
     * @param list
     * @return
     */
    int insertDatas(@Param(value = "list") List<TalkMember> list);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteData(@Param(value = "id") Integer id);
}
