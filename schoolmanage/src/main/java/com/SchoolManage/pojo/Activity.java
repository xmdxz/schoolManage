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
     * 负责
     */
    private String responsible;

    /**
     * 备注
     */
    private String remarks;


    /**
     * 参加的活动
     */
    private String active;

    /**
     * 时间
     */
    private Date time;

    /**
     * 参加活动总人数
     */
    private Integer number;
}
