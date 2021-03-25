package com.SchoolManage.dao;

import com.SchoolManage.pojo.TalkType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository

public interface TalkTypeDao {

    List<TalkType> findAllNoPage(@Param(value = "comy") String comy);

    /**
     * 获取类型
     *
     * @return
     */
    List<String> getType();

    /**
     * 查询全部
     *
     * @param startPage
     * @param num
     * @return
     */
    List<TalkType> findAll(@Param(value = "comy") String comy, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 查询全部数量
     *
     * @return
     */
    int findAllCount(@Param(value = "comy") String comy);

    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    TalkType findById(@Param(value = "id") Integer id);

    /**
     * 根据类型查找
     *
     * @param type
     * @param startPage
     * @param num
     * @return
     */
    List<TalkType> findByType(@Param(value = "comy") String comy, @Param(value = "type") String type, @Param(value = "startPage") Integer startPage, @Param(value = "num") Integer num);

    /**
     * 根据类型查找数量
     *
     * @param type
     * @return
     */
    int findByTypeCount(@Param(value = "comy") String comy, @Param(value = "type") String type);

    /**
     * 更新
     *
     * @param talkType
     * @return
     */
    int updateData(@Param(value = "talkType") TalkType talkType);

    /**
     * 单条插入
     *
     * @param talkType
     * @return
     */
    int insertData(@Param(value = "talkType") TalkType talkType);

    /**
     * 多条插入
     *
     * @param list
     * @return
     */
    int insertDatas(@Param(value = "list") List<TalkType> list);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteData(@Param(value = "id") Integer id);
}
