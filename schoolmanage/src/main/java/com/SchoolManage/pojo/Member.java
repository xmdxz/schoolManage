package com.SchoolManage.pojo;

import lombok.*;

import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Member)) {
            return false;
        }
        Member member = (Member) o;
        return Objects.equals(getId(), member.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
