package com.SchoolManage.service;

import com.SchoolManage.dao.StudentDao;
import com.SchoolManage.exception.FieldNotExistException;
import com.SchoolManage.pojo.Student;
import com.SchoolManage.util.TableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
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
    public List<Student> findByDirection(String comy, String direction, int page, int num) {
        int startpage = (page - 1) * num;
        return studentDao.findByDirection(comy, direction, startpage, num);
    }

    @Override
    public List<Student> findPage(String comy, int page, int num) {
        int startpage = (page - 1) * num;
        List<Student> page1 = studentDao.findPage(comy, startpage, num);
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
    public List<Student> findByName(String comy, String name, int page, int num) {
        int startpage = (page - 1) * num;
        return studentDao.findByName(comy, name, startpage, num);
    }

    @Override
    public List<Student> findByClass_or(String comy, String original_class, int page, int num) {
        int startpage = (page - 1) * num;
        return studentDao.findByClass_or(comy, original_class, startpage, num);
    }

    @Override
    public List<Student> findByClass_pe(String comy, String present_class, int page, int num) {
        int startpage = (page - 1) * num;
        return studentDao.findByClass_pe(comy, present_class, startpage, num);
    }

    @Override
    public List<Student> findByMajor(String comy, String major, int page, int num) {
        int startpage = (page - 1) * num;
        return studentDao.findByMajor(comy, major, startpage, num);
    }

    @Override
    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public List<Student> findAll(String comy) {
        return studentDao.findAll(comy);
    }

    @Override
    public int deleteStudent(String id) {
        return studentDao.deleteStudent(id);
    }

    @Override
    public int selectStudentNum(String comy, String conditionName, String conditionValue) {
        return studentDao.selectStudentNum(comy, conditionName, conditionValue);
    }

    @Override
    public List<Student> findByMultipleConditions(String comy, Map<String, String> conditions, int page, int num) {
        int startpage = (page - 1) * num;
        return studentDao.findByMultipleConditions(comy, conditions, startpage, num);
    }

    @Override
    public int findByMultipleConditionsCount(String comy, Map<String, String> nconditions) {
        return studentDao.findByMultipleConditionsCount(comy, nconditions);
    }

    @Override
    public int findByNameCount(String comy, String name) {
        return studentDao.findByNameCount(comy, name);
    }

    @Override
    public int BatchAddition(String comy, String path) {
        int num = 0;
        try {
            //path写实际path
            TableUtil<Student> tableUtil = new TableUtil<Student>(path, Student.class);
            List<Student> database = studentDao.findAll(comy);
            List<Student> list = tableUtil.GetTableRowContent(database);
            //调用插入接口
            //批量上传，list集合
            num = studentDao.insertBatchStudent(list);
        } catch (IOException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchFieldException e) {
            e.printStackTrace();
            return -2;
        } catch (FieldNotExistException e) {
            //此处应处理表格问题，返回前端
            e.printStackTrace();
            return -3;
        }
        return num;
    }

    @Override
    public Map<String, Integer> findByArea(String comy, List<String> arealist) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arealist.size(); i++) {
            String area = arealist.get(i);
            int byArea = studentDao.findByArea(comy, area);
            map.put(area, byArea);
        }
        return map;
    }

    @Override
    public List<Student> findByAreaStudent(String comy, String area, int Page, int num) {
        return studentDao.findByAreaStudent(comy, area, (Page - 1) * num, num);
    }

    @Override
    public int findAllNum(String comy) {
        return studentDao.findAllNum(comy);
    }
}
