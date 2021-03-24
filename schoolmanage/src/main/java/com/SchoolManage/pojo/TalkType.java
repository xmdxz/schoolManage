package com.SchoolManage.pojo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TalkType {
    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 类型
     */
    private String type;

    /**
     * 所属学院
     */
    private String college;

    /**
     * 权限
     */
    private String comy;

    /**
     * 人数
     */
    private Integer number;
}
