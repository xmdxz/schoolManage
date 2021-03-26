package com.SchoolManage.pojo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TalkMember {

    /**
     * 自增主键
     */
    private Integer id;
    /**
     * 类型
     */
    private String type;

    /**
     * 班级
     */
    private String clazz;

    /**
     * 学号
     */
    private String code;

    /**
     * 姓名
     */
    private String name;



    /**
     * 心里状态
     */
    private String status;

    /**
     * 本人手机号
     */
    private String own_phone;

    /**
     * 家庭手机号
     */
    private String family_phone;
    /**
     * 解决办法
     */
    private String solution;

    /**
     * 备注
     */
    private String remarks;

    private String comy;
}
