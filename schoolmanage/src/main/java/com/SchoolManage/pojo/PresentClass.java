package com.SchoolManage.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PresentClass {
    /**
     * 班级号
     */
    private String className;
    /**
     * 班长
     */
    private String monitor;
    /**
     * 学委
     */
    private String study;
    /**
     * 团支书
     */
    private String league;
    /**
     * 副班长
     */
    private String vice_monitor;
    /**
     * 心理委员
     */
    private String mentality;
    /**
     * 文体委员
     */
    private String style;
    /**
     * 组织委员
     */
    private String organization;
    /**
     * 宣传委员
     */
    private String publicize;

}
