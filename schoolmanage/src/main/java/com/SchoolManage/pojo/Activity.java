package com.SchoolManage.pojo;

import lombok.*;

import java.sql.Date;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Activity {

    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 学生
     */
    private String student;

    /**
     * 参加的活动
     */
    private String active;

    /**
     * 时间
     */
    private Date time;
}
