package com.SchoolManage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SchoolManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolManageApplication.class, args);
    }

}
