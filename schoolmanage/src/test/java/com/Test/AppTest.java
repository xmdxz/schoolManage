package com.Test;

import com.SchoolManage.dao.StudentDao;
import com.SchoolManage.exception.FieldNotExistException;
import com.SchoolManage.pojo.Student;
import com.SchoolManage.util.TableUtil;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class AppTest {
    @Test
    public void Test1(){
        try {
            //path写实际path
            TableUtil<Student> tableUtil = new TableUtil<Student>("path",Student.class);
            List<Student> list = tableUtil.GetTableRowContent();
            //调用插入接口
            //批量上传，list集合过大，不知是否成功，如果有问题，转变为单一插入
//            StudentDao.insertBatchStudent(list);
            //单一插入（二选一）
//            for (int i = 0 ;i <list.size();i++){
////                StudentDao.insertStudent(list.get(i));
//            }
        } catch (IOException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchFieldException e) {
            e.printStackTrace();
        } catch (FieldNotExistException e) {
            //此处应处理表格问题，返回前端
            e.printStackTrace();
        }
    }
}
