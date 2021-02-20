package com.SchoolManage.pojo;

import lombok.*;

import java.sql.Timestamp;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Qingjia {

    /**
     * 自增主键
     */
    private Integer id;
    /**
     * 学生
     */
    private String student;
    /**
     * 开始时间
     */
    private Timestamp start_time;
    /**
     * 批准教师
     */
    private String teacher;
    /**
     * 请假原因
     */
    private String cause;
    /**
     * 结束时间
     */
    private Timestamp end_time;

    /**
     * 姓名
     */
    private String name;

    /**
     * 班级
     */
    private String clazz;

}
