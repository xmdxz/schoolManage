package com.SchoolManage.Enum;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 此类用于表格上传时，表头的识别，当添加实体类时，枚举也要添加，而无需改动工具类
 */
public enum Eneity {
    /**
     * 学生实体类
     */
    STUDENT(new LinkedHashMap<String, String>() {
        private static final long serialVersionUID = 3508718881037453751L;

        {
            put("学号", "id");
            put("姓名", "name");
            put("性别", "sex");
            put("民族", "nation");
            put("入学年份", "comy");
            put("学院", "clno");
            put("专业", "major");
            put("方向", "direction");
            put("现班级", "present_class");
            put("现职务", "present_post");
            put("原班级", "original_class");
            put("原职务", "original_post");
            put("手机号", "phone");
            put("宿舍楼", "bedroom_lou");
            put("生日", "birth");
            put("籍贯", "nativeplace");
            put("住址", "address");
            put("父亲手机号", "father_phone");
            put("母亲手机号", "mother_phone");
            put("一寸照片", "photo");
            put("宗教信仰", "bedroom_hao");
            put("身份证", "idcard");
            put("银行卡号", "bank");
            put("父亲姓名", "father_name");
            put("母亲姓名", "mother_name");
            put("父亲职务", "father_profession");
            put("母亲职务", "mother_profession");
        }
    }),

    DEPARTMENT(new LinkedHashMap<String, String>() {
        private static final long serialVersionUID = 4145320302396363757L;

        {
            put("部门名称", "name");
            put("所属学院", "college");
            put("部长姓名", "minister");
            put("部长电话", "phone");
            put("人数", "num");
        }
    }),

    MEMBER(new LinkedHashMap<String, String>() {
        private static final long serialVersionUID = 6800232138994455618L;

        {
            put("学号", "id");
            put("姓名", "name");
            put("所属部门", "department");
            put("部门职位", "position");
            put("联系方式", "phone");
            put("QQ", "qq");
            put("班级", "clazz");
        }
    }),

    DORMITORY(new LinkedHashMap<String, String>() {
        private static final long serialVersionUID = 4194398228678130187L;

        {
            put("宿舍楼", "building");
            put("宿舍号", "number");
            put("宿舍长", "manage");
            put("人数", "num");
        }
    }),

    ACTIVITY(new LinkedHashMap<String, String>() {
        private static final long serialVersionUID = -4167670706477524067L;

        {
            put("活动名称", "active");
            put("开始时间", "time");
            put("负责部门(人)", "responsible");
            put("备注", "remarks");
        }
    }),

    ACTIVEMEMBER(new LinkedHashMap<String, String>() {
        private static final long serialVersionUID = -1054486841028023585L;

        {
            put("学号", "student");
            put("姓名", "name");
            put("班级", "clazz");
            put("参与活动名称", "activeName");
            put("联系方式", "phone");
        }
    });


    private Map<String, String> pojo;

    Eneity(Map<String, String> pojo) {
        this.pojo = pojo;
    }

    public Map<String, String> getPojo() {
        return pojo;
    }
}
