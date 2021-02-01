package com.SchoolManage.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OriginalClass {
    /**
     * 班级号
     */
    private String className;
    /**
     * 班长
     */
    private Student monitor;
    /**
     * 学委
     */
    private Student study;
    /**
     * 团支书
     */
    private Student league;
    /**
     * 副班长
     */
    private Student vice_monitor;
    /**
     * 心理委员
     */
    private Student mentality;
    /**
     * 文体委员
     */
    private Student style;
    /**
     * 组织委员
     */
    private Student organization;
    /**
     * 宣传委员
     */
    private Student publicize;

}
