package com.SchoolManage.pojo;

import lombok.*;

/**
 * @Author RainGoal
 * @Date 2021/1/26 16:10
 * @Description TODO
 * @Version 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AdminUser {
    private int id;
    private String username;
    private String password;
    private String phone;
    private String department;
    private String position;
    private String name;
    private String responsible;
}
