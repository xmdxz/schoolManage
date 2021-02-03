package com.SchoolManage.service;

import com.SchoolManage.dao.StudentDao;
import com.SchoolManage.exception.FieldNotExistException;
import com.SchoolManage.pojo.Student;
import com.SchoolManage.util.TableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
    public List<Student> findByDirection(String direction,int page, int num) {
        int startpage = (page - 1) * num;
        return studentDao.findByDirection(direction,startpage,num);
    }

    @Override
    public List<Student> findPage(int page, int num) {
        int startpage = (page - 1) * num;
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
    public List<Student> findByName(String name,int page, int num) {
        int startpage = (page - 1) * num;
        return studentDao.findByName(name,startpage,num);
    }

    @Override
    public List<Student> findByClass_or(String original_class,int page, int num) {
        int startpage = (page - 1) * num;
        return studentDao.findByClass_or(original_class,startpage,num);
    }

    @Override
    public List<Student> findByClass_pe(String present_class,int page,int num) {
        int startpage = (page - 1) * num;
        return studentDao.findByClass_pe(present_class,startpage,num);
    }

    @Override
    public List<Student> findByMajor(String major,int page,int num) {
        int startpage = (page - 1) * num;
        return studentDao.findByMajor(major,startpage,num);
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
    public List<Student> findByMultipleConditions(Map<String, String> conditions, int page, int num) {
        int startpage = (page - 1) * num;
        return studentDao.findByMultipleConditions(conditions, startpage, num);
    }

    @Override
    public int findByMultipleConditionsCount(Map<String, String> nconditions) {
        System.out.println("service层实现" + nconditions);
        return studentDao.findByMultipleConditionsCount(nconditions);
    }

    @Override
    public int BatchAddition(String path) {
        int num=0;
        try {
            //path写实际path
            String Path=path;
            TableUtil<Student> tableUtil = new TableUtil<Student>("Path", Student.class);
            List<Student> list = tableUtil.GetTableRowContent();
            //调用插入接口
            //批量上传，list集合过大，不知是否成功，如果有问题，转变为单一插入
            num=studentDao.insertBatchStudent(list);
            //单一插入（二选一）
            for (int i = 0; i < list.size(); i++) {
                num=studentDao.insertStudent(list.get(i));
            }
        } catch (IOException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchFieldException e) {
            e.printStackTrace();
            return  -2;
        } catch (FieldNotExistException e) {
            //此处应处理表格问题，返回前端
            e.printStackTrace();
            return  -3;
        }
        return num;
    }
}