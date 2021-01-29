package com.SchoolManage.controller;

import com.SchoolManage.pojo.Student;
import com.SchoolManage.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author RainGoal
 * @Date 2021/1/29 15:51
 * @Description TODO
 * @Version 1.0
 */
@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("add")
    @ResponseBody
    public Map<String,Object> addStudent(Student student){
        Map<String, Object> map = new HashMap<>();
        int i = studentService.insertStudent(student);
        if (i!=0){
            map.put("msg", "添加成功");
            map.put("code", 200);
            return map;
        }else {
            map.put("msg", "添加失败");
            map.put("code", 500);
            return map;
        }
    }

    @RequestMapping("findbyid")
    @ResponseBody
    public Student findById(String id){
        Student stu = studentService.findById(id);
        return stu;
    }

    @RequestMapping("findbyname")
    @ResponseBody
    public List<Student> findByName(String name){
        List<Student> byName = studentService.findByName(name);
        return byName;
    }

    @RequestMapping("findbyclass_or")
    @ResponseBody
    public List<Student> findByClass_or(String original_class){
        List<Student> byClass_or = studentService.findByClass_or(original_class);
        return byClass_or;
    }

    @RequestMapping("findbyclass_pe")
    @ResponseBody
    public List<Student> findByClass_pe(String present_class){
        List<Student> byClass_pe = studentService.findByClass_pe(present_class);
        return byClass_pe;
    }

    @RequestMapping("findbymajor")
    @ResponseBody
    public List<Student> findByMajor(String major){
        List<Student> bymajor = studentService.findByMajor(major);
        return bymajor;
    }

    @RequestMapping("update")
    @ResponseBody
    public Map<String,Object> updateStudent(Student student){
        Map<String, Object> map = new HashMap<>();
        int i = studentService.updateStudent(student);
        if (i!=0){
            map.put("msg", "修改成功");
            map.put("code", 200);
            return map;
        }else {
            map.put("msg", "修改失败");
            map.put("code", 500);
            return map;
        }
    }
}
