package com.SchoolManage.pojo;

import lombok.*;

import java.sql.Date;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Honour {

    /**
     * 自增主键
     */
    private Integer id;
    /**
     * 学生
     */
    private String student;

    /**
     * 荣誉类型
     */
    private String type;
    /**
     * 荣誉
     */
    private String prize;
    /**
     * 获得时间
     */
    private Date time;


}
