package com.SchoolManage.pojo;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Log {
    //操作时间
    private Timestamp time;

    //操作类型
    private String type;

    //备注，也就是具体操作内容
    private String message;

    //操作教师
    private String operation_teacher;

    //操作学生
    private String operation_student;

    //操作表
    private String operation_table;

    //年级
    private String comy;
}
