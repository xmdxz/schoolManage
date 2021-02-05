package com.SchoolManage.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Member {

    /**
     * 学号
     */
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 所属部门
     */
    private String department;

    /**
     * 部门职位
     */
    private String position;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * qq
     */
    private String qq;

    /**
     * 班级
     */
    private String clazz;

}
