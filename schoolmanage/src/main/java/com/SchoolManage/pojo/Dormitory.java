package com.SchoolManage.pojo;

import lombok.*;

import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Dormitory {

    private String building;

    private String number;

    private String manage;

    private Integer num;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Dormitory)) {
            return false;
        }
        Dormitory dormitory = (Dormitory) o;
        return getBuilding().equals(dormitory.getBuilding()) && getNumber().equals(dormitory.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBuilding(), getNumber());
    }
}
