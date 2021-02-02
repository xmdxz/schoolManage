package com.SchoolManage.service;

import com.SchoolManage.dao.StudentDao;
import com.SchoolManage.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author RainGoal
 * @Date 2021/1/29 16:41
 * @Description TODO
 * @Version 1.0
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> findByDirection(String direction) {
        return studentDao.findByDirection(direction);
    }

    @Override
    public List<Student> findPage(int page, int num) {
        int startpage = (page-1)*num;
        List<Student> page1 = studentDao.findPage(startpage, num);
        return page1;
    }

    @Override
    public int insertStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public Student findById(String id) {
        return studentDao.findById(id);
    }

    @Override
    public List<Student> findByName(String name) {
        return studentDao.findByName(name);
    }

    @Override
    public List<Student> findByClass_or(String original_class) {
        return studentDao.findByClass_or(original_class);
    }

    @Override
    public List<Student> findByClass_pe(String present_class) {
        return studentDao.findByClass_pe(present_class);
    }

    @Override
    public List<Student> findByMajor(String major) {
        return studentDao.findByMajor(major);
    }

    @Override
    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public int deleteStudent(String id) {
        return studentDao.deleteStudent(id);
    }

    @Override
    public int selectStudentNum(String conditionName, String conditionValue) {
        return studentDao.selectStudentNum(conditionName, conditionValue);
    }

    @Override
    public List<Student> findByMultipleConditions(Map<String, String> conditions) {
        return studentDao.findByMultipleConditions(conditions);
    }
}
