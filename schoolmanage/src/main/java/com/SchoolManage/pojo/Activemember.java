package com.SchoolManage.pojo;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Activemember {

    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 活动
     */
    private Integer activity;

    /**
     * 学生
     */
    private String student;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 班级
     */
    private String clazz;

}
