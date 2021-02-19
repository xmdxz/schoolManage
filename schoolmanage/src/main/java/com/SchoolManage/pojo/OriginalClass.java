package com.SchoolManage.pojo;

import lombok.*;

import java.util.Objects;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OriginalClass {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OriginalClass)) {
            return false;
        }
        OriginalClass that = (OriginalClass) o;
        return Objects.equals(getClassName(), that.getClassName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClassName());
    }
}
