package com.SchoolManage.controller;

import com.SchoolManage.pojo.Student;
import com.SchoolManage.service.FeaturesService;
import com.SchoolManage.service.StudentService;
import com.SchoolManage.util.CreatData;
import com.SchoolManage.util.CreateExlceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
    public List<Student> findByDirection(String direction,int page,int num) {
        List<Student> byDirection = studentService.findByDirection(direction,page,num);
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
    public List<Student> findByName(String name,int page,int num) {
        System.out.println("name"+name);
        System.out.println("page"+page);
        System.out.println("num"+num);
        List<Student> byName = studentService.findByName(name,page,num);
        return byName;
    }
    @RequestMapping("findByNameCount")
    @ResponseBody
    public String findByNameCount(String name) {

        int i = studentService.findByNameCount(name);
        return Integer.toString(i);
    }

    @RequestMapping("findbyclass_or")
    @ResponseBody
    public List<Student> findByClass_or(String original_class,int page,int num) {
        List<Student> byClass_or = studentService.findByClass_or(original_class,page,num);
        return byClass_or;
    }

    @RequestMapping("findbyclass_pe")
    @ResponseBody
    public List<Student> findByClass_pe(String present_class,int page,int num) {
        List<Student> byClass_pe = studentService.findByClass_pe(present_class,page,num);
        return byClass_pe;
    }

    @RequestMapping("findbymajor")
    @ResponseBody
    public List<Student> findByMajor(String major,int page,int num) {
        List<Student> bymajor = studentService.findByMajor(major,page,num);
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

    @RequestMapping("creatdata")
    @ResponseBody
    public String creatData() {
        String name = "";
        String familyNameStr = "";
        Random random = new Random();
        int id = 10001;
        String[] banji = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18",
                "19", "20", "21", "22"};
        String[] sex = {"男", "女"};
        String[] position = {"班长", "学委", "心理委员", "副班长", "体育委员", "组织委员", "宣传委员", "团支书", "无", "无", "无", "无", "无", "无", "无", "无", "无", "无", "无", "无", "无", "无", "无", "无", "无", "无", "无", "无", "无", "无", "无", "无", "无", "无", "无", "无", "无", "无", "无", "无"};
        String[] major = {"软件工程", "大数据", "数字媒体技术", "智能科学技术"};
        int[] bedroom = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        String[] direction = {"移动互联","JavaEE","大数据","人工智能"};

        for (int i = 0; i < 20001; i++) {
            Student student = new Student();
            Boolean flag = random.nextBoolean();
            familyNameStr = CreatData.getChineseFamilyName();
            name = familyNameStr;
            if (flag) {
                name += CreatData.getChineseGivenName() + CreatData.getChineseGivenName();
            } else name += CreatData.getChineseGivenName();
            student.setName(name);
            student.setClno("软件学院");
            student.setBank("88888888888888");
            student.setComy("2019");
            student.setId(Integer.toString(id + 1));
            student.setIdcard("140987200107349988");
            student.setPresent_class("19" + banji[random.nextInt(22)]);
            student.setOriginal_class("19" + banji[random.nextInt(22)]);
            student.setReligion("佛教");
            student.setNation("汉");
            student.setSex(sex[random.nextInt(2)]);
            student.setBedroom_lou(Integer.toString(bedroom[random.nextInt(20)]) + "号楼");
            student.setPresent_post(position[random.nextInt(40)]);
            student.setOriginal_post(position[random.nextInt(40)]);
            student.setMajor(major[random.nextInt(4)]);
            student.setDirection(direction[random.nextInt(4)]);
            System.out.println(student);
            studentService.insertStudent(student);
            id = id + 1;
        }
        return "ok";
    }

    @RequestMapping(value = "Excle",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String ExcleStudent(HttpServletRequest request,String major, String direction, String present_class
            , String original_class, String present_post, String original_post) throws NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException {
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
        int i=studentService.findByMultipleConditionsCount(map);
        CreateExlceUtil<Student> createExlceUtil = new CreateExlceUtil<>(request,Student.class,"学生表");
        List<Student> list = studentService.findByMultipleConditions(map,1,i);
        return createExlceUtil.createExcle(list);
    }
    @PostMapping("upfile")
    @ResponseBody
    public String upfile(@RequestParam("file") MultipartFile file){
        if (file==null){
            return "请选择文件";
        }
        try {
            String filename = file.getOriginalFilename();
            String extFileName = filename.substring(filename.lastIndexOf("." ) +1,filename.length());
//            System.out.println("文件名:\t"+filename);
//            System.out.println("后缀名:\t"+extFileName);
            //上传到本地,模拟上传到文件服务器
            String filePath= "D:\\shixun\\";
            String path = filePath + filename;
            int i=studentService.BatchAddition(path);
            //文件存储路径
            File dest = new File(path);
            if (!dest.getParentFile().exists()){
                dest.getParentFile().mkdir();
            }
            file.transferTo(dest);
            if(i==-1||i==-2||i==-3)
                return "上传的表格不匹配,请进行修改后重先上传";
            else
                return "上传成功了";

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败了";
    }
}
