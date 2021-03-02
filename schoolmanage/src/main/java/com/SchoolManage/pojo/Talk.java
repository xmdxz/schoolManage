package com.SchoolManage.pojo;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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

    /**
     * 年级
     */
    private String comy;

    /**
     * 类型
     */
    private String types;

    /**
     * 级别
     */
    private String level;
}
