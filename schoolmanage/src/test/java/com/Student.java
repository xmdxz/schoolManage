package com;

import lombok.*;

/**
 * @Author RainGoal
 * @Date 2021/1/28 8:41
 * @Description TODO
 * @Version 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    //学号
    private String id;
    //姓名
    private String name;
    //性别
    private String sex;
    //入学年份
    private String comy;
    //学院
    private String clno;
    //专业
    private String major;
    //现班级
    private String present_class;
    //联系方式
    private String phone;
    //宿舍楼
    private String bedroom_lou;
    //生日
    private String birth;
    //籍贯
    private String nativeplace;
    //方向
    private String direction;
    //住址
    private String address;
    //母亲姓名
    private String mother_name;
    //父亲姓名
    private String father_name;
    //父亲联系方式
    private String father_phone;
    //母亲联系方式
    private String mother_phone;
    //父亲的职业
    private String father_profession;
    //母亲的职业
    private String mother_profession;
    //一寸照
    private String photo;
    //原班级
    private String original_class;
    //原职务
    private String original_post;
    //现职务
    private String present_post;
    //民族
    private String nation;
    //宗教信仰
    private String religion;
    //宿舍号
    private String bedroom_hao;
    //身份证
    private String idcard;
    //银行卡号
    private String bank;
}
