package com.SchoolManage.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class DepartMent {

    /**
     * 部门名称
     */
    private String name;

    /**
     * 所属学院
     */
    private String college;

    /**
     * 部长姓名
     */
    private String minister;

    /**
     *  部长电话
     */
    private String phone;

    /**
     * 部门成员数量
     */
    private int num;
}
