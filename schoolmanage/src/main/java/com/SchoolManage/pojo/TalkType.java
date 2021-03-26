package com.SchoolManage.pojo;

import lombok.*;

import java.util.Objects;

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

    public TalkType(String typeName, String comy) {
        this.type = typeName;
        this.comy = comy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TalkType)) return false;
        TalkType talkType = (TalkType) o;
        return Objects.equals(getType(), talkType.getType()) && Objects.equals(getComy(), talkType.getComy());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType());
    }
}
