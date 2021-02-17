package com.SchoolManage.pojo;

import java.sql.Date;

public class Talk {

    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 学号
     */
    private String student;

    /**
     * 教师
     */
    private String teacher;

    /**
     * 谈话内容
     */
    private String content;

    /**
     * 谈话时间
     */
    private Date time;
}
