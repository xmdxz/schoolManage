package com.SchoolManage.controller;

import com.SchoolManage.dao.StudentDao;
import com.SchoolManage.pojo.Student;
import com.SchoolManage.service.FeaturesService;
import com.SchoolManage.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private FeaturesService featuresService;

    @RequestMapping("add")
    public String addStudent(Student student) {
//        Map<String, Object> map = new HashMap<>();
        int i = studentService.insertStudent(student);
        if (i != 0) {
//            map.put("msg", "添加成功");
//            map.put("code", 200);
            return "loginp";
        } else {
//            map.put("msg", "添加失败");
//            map.put("code", 500);
            return "students";
        }
    }

    @RequestMapping("findall")
    @ResponseBody
    public List<Student> findAll() {
        List<Student> all = studentService.findAll();
        return all;
    }

    @RequestMapping("findbypage")
    @ResponseBody
    public List<Student> findByPage(int page, int num) {
        List<Student> page1 = studentService.findPage(page, num);
        return page1;
    }

    @RequestMapping("findbydirection")
    @ResponseBody
    public List<Student> findByDirection(String direction) {
        List<Student> byDirection = studentService.findByDirection(direction);
        return byDirection;
    }

    @RequestMapping("findbyid")
    @ResponseBody
    public Student findById(String id) {
        Student stu = studentService.findById(id);
        return stu;
    }

    @RequestMapping("findbyname")
    @ResponseBody
    public List<Student> findByName(String name) {
        List<Student> byName = studentService.findByName(name);
        return byName;
    }

    @RequestMapping("findbyclass_or")
    @ResponseBody
    public List<Student> findByClass_or(String original_class) {
        List<Student> byClass_or = studentService.findByClass_or(original_class);
        return byClass_or;
    }

    @RequestMapping("findbyclass_pe")
    @ResponseBody
    public List<Student> findByClass_pe(String present_class) {
        List<Student> byClass_pe = studentService.findByClass_pe(present_class);
        return byClass_pe;
    }

    @RequestMapping("findbymajor")
    @ResponseBody
    public List<Student> findByMajor(String major) {
        List<Student> bymajor = studentService.findByMajor(major);
        return bymajor;
    }

    @RequestMapping("update")
    public String updateStudent(Student student) {
//        Map<String, Object> map = new HashMap<>();
        int i = studentService.updateStudent(student);
        if (i != 0) {
//            map.put("msg", "修改成功");
//            map.put("code", 200);
            return "loginp";
        } else {
//            map.put("msg", "修改失败");
//            map.put("code", 500);
            return "students";
        }
    }

    @RequestMapping("delete")
    @ResponseBody
    public Map<String, Object> deleteStudent(String id) {
        Map<String, Object> map = new HashMap<>();
        int i = studentService.deleteStudent(id);
        if (i != 0) {
            map.put("msg", "删除成功");
            map.put("code", 200);
            return map;
        } else {
            map.put("msg", "删除失败");
            map.put("code", 500);
            return map;
        }
    }

    @RequestMapping("getcount")
    @ResponseBody
    public String getCount(String conditionName, String conditionValue) {
        int i = studentService.selectStudentNum(conditionName, conditionValue);
        return Integer.toString(i);
    }

    @RequestMapping("getdirectionbymajor")
    @ResponseBody
    public List<String> findDirectionByMajor(String major) {
        List<String> directionByMajor = featuresService.findDirectionByMajor(major);
        return directionByMajor;
    }

    @RequestMapping("findByMultipleConditions")
    @ResponseBody
    public List<Student> findByMultipleConditions(String major, String direction, String present_class
            , String original_class, String present_post, String original_post,int page, int num) {

        Map<String, String> map = new HashMap<>();
        if (major != null){
            map.put("major", major);
        }
        if (direction != null) {
            map.put("direction", direction);
        }
        if (present_class != null){
            map.put("present_class", present_class);
        }
        if (original_class != null){
            map.put("original_class", original_class);
        }
        if (present_post != null){
            map.put("present_post", present_post);
        }
        if (original_post != null){
            map.put("original_post", original_post);
        }
        System.out.println(map);
        return studentService.findByMultipleConditions(map,page,num);
    }
    @RequestMapping("findByMultipleConditionsCount")
    @ResponseBody
    public String findByMultipleConditionsCount(String major, String direction, String present_class
            , String original_class, String present_post, String original_post) {

        Map<String, String> map = new HashMap<>();
        if (major != null){
            map.put("major", major);
        }
        if (direction != null) {
            map.put("direction", direction);
        }
        if (present_class != null){
            map.put("present_class", present_class);
        }
        if (original_class != null){
            map.put("original_class", original_class);
        }
        if (present_post != null){
            map.put("present_post", present_post);
        }
        if (original_post != null){
            map.put("original_post", original_post);
        }
        int i = studentService.findByMultipleConditionsCount(map);
        return Integer.toString(i);
    }
}
