package com.SchoolManage.exception;

public class FieldNotExistException extends RuntimeException {

    public FieldNotExistException() {

    }

    public FieldNotExistException(String s) {
        super(s);
    }
}
