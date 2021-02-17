package com.SchoolManage.dao;

import com.SchoolManage.pojo.Qingjia;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QingjiaDao {

    List<Qingjia> findAll();

    List<Qingjia> findByStudent(@Param(value = "student") String student);

    List<Qingjia> findByTeacher(@Param(value = "teacher") String teacher);

    int insertQingjia(@Param(value = "qingjia") Qingjia qingjia);

    int insertQingjias(@Param(value = "list") List<Qingjia> list);

    int deleteQingjia(@Param(value = "id") Integer id);

}
