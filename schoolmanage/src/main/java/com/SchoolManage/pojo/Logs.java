package com.SchoolManage.pojo;

import lombok.*;

import java.sql.Timestamp;

/**
 * @Author RainGoal
 * @Date 2021/2/7 23:19
 * @Description TODO
 * @Version 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Logs {
    private Integer id;
    private String title;
    private Timestamp start;
    private Timestamp end;
    private String className;
    private String user;
    private Integer maid;
}
