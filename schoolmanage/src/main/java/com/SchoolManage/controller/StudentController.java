package com.SchoolManage.controller;

import com.SchoolManage.exception.NameNullException;
import com.SchoolManage.pojo.AdminUser;
import com.SchoolManage.pojo.Student;
import com.SchoolManage.service.FeaturesService;
import com.SchoolManage.service.LogService;
import com.SchoolManage.service.StudentService;
import com.SchoolManage.util.CreatData;
import com.SchoolManage.util.CreateExlceUtil;
import com.SchoolManage.util.ExcleTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

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
    private LogService logService;

    @Autowired
    private FeaturesService featuresService;

    @RequestMapping("add")
    public String addStudent(Student student, HttpServletRequest request) {
//        Map<String, Object> map = new HashMap<>();
        AdminUser a = (AdminUser) request.getSession().getAttribute("administer");

//        if (i != 0) {
//            map.put("msg", "添加成功");
//            map.put("code", 200);
        //判断管理员是否有权限添加学生
        String responsible = a.getResponsible();
        String[] split = responsible.split(",");
        int flag = 0;
        for (int j = 0; j < split.length; j++) {
            if (split[j].equals(student.getComy())) {
                flag = 1;
            }
        }
        System.out.println(flag);
        if (flag == 1) {
            int i = studentService.insertStudent(student);
            if (i != 0) {
                logService.insertNew("添加", "的学生信息 ", a.getName(), "学号为" + student.getId(), "学生表", student.getComy());
                if (student.getComy().equals("2019"))
                    return "loginp";
                else
                    return "loginp-20";
            } else {
//            map.put("msg", "添加失败");
//            map.put("code", 500);
                if (student.getComy().equals("2019"))
                    return "studentsp";
                else
                    return "students-20";
            }

        } else return "index";
    }


    @RequestMapping("findall")
    @ResponseBody
    public List<Student> findAll(String comy) {
        List<Student> all = studentService.findAll(comy);
        return all;
    }

    @RequestMapping("findallnum")
    @ResponseBody
    public int findAllNum(String comy) {
        int all = studentService.findAllNum(comy);
        return all;
    }

    @RequestMapping("findbypage")
    @ResponseBody
    public List<Student> findByPage(String comy, int page, int num) {
        List<Student> page1 = studentService.findPage(comy, page, num);
        return page1;
    }

    @RequestMapping("findbydirection")
    @ResponseBody
    public List<Student> findByDirection(String comy, String direction, int page, int num) {
        List<Student> byDirection = studentService.findByDirection(comy, direction, page, num);
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
    public List<Student> findByName(String comy, String name, int page, int num) {
        List<Student> byName = studentService.findByName(comy, name, page, num);
        return byName;
    }

    @RequestMapping("findByNameCount")
    @ResponseBody
    public String findByNameCount(String comy, String name) {

        int i = studentService.findByNameCount(comy, name);
        return Integer.toString(i);
    }

    @RequestMapping("findbyclass_or")
    @ResponseBody
    public List<Student> findByClass_or(String comy, String original_class, int page, int num) {
        List<Student> byClass_or = studentService.findByClass_or(comy, original_class, page, num);
        return byClass_or;
    }

    @RequestMapping("findbyclass_pe")
    @ResponseBody
    public List<Student> findByClass_pe(String comy, String present_class, int page, int num) {
        List<Student> byClass_pe = studentService.findByClass_pe(comy, present_class, page, num);
        return byClass_pe;
    }

    @RequestMapping("findbymajor")
    @ResponseBody
    public List<Student> findByMajor(String comy, String major, int page, int num) {
        List<Student> bymajor = studentService.findByMajor(comy, major, page, num);
        return bymajor;
    }

    @RequestMapping("update")
    public String updateStudent(Student student, HttpServletRequest request) {
        AdminUser a = (AdminUser) request.getSession().getAttribute("administer");
//        Map<String, Object> map = new HashMap<>();
        int i = studentService.updateStudent(student);
        if (i != 0) {
            logService.insertNew("更新", "的学生信息", a.getName(), "学号为" + student.getId(), "学生表", student.getComy());
//            map.put("msg", "修改成功");
//            map.put("code", 200);
            if (student.getComy().equals("2019"))
                return "loginp";
            else
                return "loginp-20";
        } else {
//            map.put("msg", "添加失败");
//            map.put("code", 500);
            if (student.getComy().equals("2019"))
                return "studentsp";
            else
                return "students-20";
        }
    }

    @RequestMapping("delete")
    @ResponseBody
    public Map<String, Object> deleteStudent(String id, String comy, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        int i = studentService.deleteStudent(id);
        AdminUser a = (AdminUser) request.getSession().getAttribute("administer");
        if (i != 0) {
            logService.insertNew("删除", "的学生信息", a.getName(), "学号为" + id, "学生表", comy);
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
    public String getCount(String comy, String conditionName, String conditionValue) {
        int i = studentService.selectStudentNum(comy, conditionName, conditionValue);
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
    public List<Student> findByMultipleConditions(String comy, String major, String direction, String present_class
            , String original_class, String present_post, String original_post, int page, int num) {

        Map<String, String> map = new HashMap<>();
        if (major != null) {
            map.put("major", major);
        }
        if (direction != null) {
            map.put("direction", direction);
        }
        if (present_class != null) {
            map.put("present_class", present_class);
        }
        if (original_class != null) {
            map.put("original_class", original_class);
        }
        if (present_post != null) {
            map.put("present_post", present_post);
        }
        if (original_post != null) {
            map.put("original_post", original_post);
        }
        return studentService.findByMultipleConditions(comy, map, page, num);
    }

    @RequestMapping("findByMultipleConditionsCount")
    @ResponseBody
    public String findByMultipleConditionsCount(String comy, String major, String direction, String present_class
            , String original_class, String present_post, String original_post) {

        Map<String, String> map = new HashMap<>();
        if (major != null && "".equals(major)) {
            map.put("major", major);
        }
        if (direction != null && "".equals(direction)) {
            map.put("direction", direction);
        }
        if (present_class != null && "".equals(present_class)) {
            map.put("present_class", present_class);
        }
        if (original_class != null && "".equals(original_class)) {
            map.put("original_class", original_class);
        }
        if (present_post != null && "".equals(present_post)) {
            map.put("present_post", present_post);
        }
        if (original_post != null && "".equals(original_post)) {
            map.put("original_post", original_post);
        }
        int i = studentService.findByMultipleConditionsCount(comy, map);
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
        String[] direction = {"移动互联", "JavaEE", "大数据", "人工智能"};

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

    @RequestMapping(value = "Excle", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String ExcleStudent(String comy, HttpServletRequest request, String major, String direction, String present_class
            , String original_class, String present_post, String original_post, String nativeplace) throws NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException, NameNullException {
        CreateExlceUtil<Student> createExlceUtil;
        List<Student> list;
        if (nativeplace != null && !"".equals(nativeplace)) {
            ArrayList<String> arealist = new ArrayList<>();
            arealist.add(nativeplace);
            Map<String, Integer> a = studentService.findByArea(comy, arealist);
            int i = a.get(nativeplace);
            createExlceUtil = new CreateExlceUtil<>(request, Student.class, "学生表");
            list = studentService.findByAreaStudent(comy, nativeplace, 1, i);
        } else {
            Map<String, String> map = new HashMap<>();
            if (major != null && "".equals(major)) {
                map.put("major", major);
            }
            if (direction != null && "".equals(direction)) {
                map.put("direction", direction);
            }
            if (present_class != null && "".equals(present_class)) {
                map.put("present_class", present_class);
            }
            if (original_class != null && "".equals(original_class)) {
                map.put("original_class", original_class);
            }
            if (present_post != null && "".equals(present_post)) {
                map.put("present_post", present_post);
            }
            if (original_post != null && "".equals(original_post)) {
                map.put("original_post", original_post);
            }
            int i = studentService.findByMultipleConditionsCount(comy, map);
            createExlceUtil = new CreateExlceUtil<>(request, Student.class, "学生表");
            list = studentService.findByMultipleConditions(comy, map, 1, i);
        }
        return createExlceUtil.createExcle(list);
    }

    @RequestMapping(value = "Excle2", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String ExcleStudent2(HttpServletRequest request) throws NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException, NameNullException {
        Student student = new Student("xxx", "xxx", "xxx", "例如:2020", "xxx",
                "例：软件工程，智能科学与技术，数字媒体艺术,数据科学与大数据技术", "例如:软件1901", "xxx", "例如:11号楼", "xxx", "xxx", "例：JavaEE，移动互联，人工智能，大数据,嵌入式", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx",
                "无", "例如:软件1901", "例如:班长，团支书，学习委员", "例如:班长，团支，学习委员", "xxx", "xxx", "例如:302", "xxx", "xxx");
        return ExcleTemplate.getTemplate(request, student, "学生表模板");
    }

    @PostMapping("upfile")
    @ResponseBody
    public String upfile(HttpServletRequest request, String comy, @RequestParam("file") MultipartFile file) {
        if (file == null) {
            return "请选择文件";
        }
        try {
            String filename = file.getOriginalFilename();
            String extFileName = filename.substring(filename.lastIndexOf(".") + 1, filename.length());
//            System.out.println("文件名:\t"+filename);
//            System.out.println("后缀名:\t"+extFileName);
            //上传到本地,模拟上传到文件服务器
            String filePath = request.getServletContext().getRealPath("/") + "File\\";
            String path = filePath + filename;
            //文件存储路径
            File dest = new File(path);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdir();
            }
            file.transferTo(dest);
            int i = 66;
            try {
                System.out.println(path);
                i = studentService.BatchAddition(comy, path);
                dest.delete();
                AdminUser a = (AdminUser) request.getSession().getAttribute("administer");
                logService.insertNew("上传", "学生信息", a.getName(), "多条", "学生表", comy);
                return "上传成功了";
            } catch (Exception e) {
                e.printStackTrace();
                dest.delete();
                return "上传的表格不匹配,请进行修改后重先上传";
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败了";
    }

    @RequestMapping("findbyarea")
    @ResponseBody
    public Map<String, Integer> findByArea(String comy,
                                           String area1,
                                           String area2,
                                           String area3,
                                           String area4,
                                           String area5,
                                           String area6,
                                           String area7,
                                           String area8,
                                           String area9,
                                           String area10,
                                           String area11,
                                           String area12,
                                           String area13,
                                           String area14,
                                           String area15,
                                           String area16
    ) {
        //这里想获取哪些区域的数目就写几个参数 area  记得把这些area加入到这个arraylist中
        ArrayList<String> arealist = new ArrayList<>();
        arealist.add(area1);
        arealist.add(area2);
        arealist.add(area3);
        arealist.add(area4);
        arealist.add(area5);
        arealist.add(area6);
        arealist.add(area7);
        arealist.add(area8);
        arealist.add(area9);
        arealist.add(area10);
        arealist.add(area11);
        arealist.add(area12);
        arealist.add(area13);
        arealist.add(area14);
        arealist.add(area15);
        arealist.add(area16);
        Map<String, Integer> byArea = studentService.findByArea(comy, arealist);
        return byArea;
    }

    @RequestMapping("findbyareastudent")
    @ResponseBody
    public List<Student> findByAreaStudent(String comy, String area, int page, int num) {
        System.out.println("打印" + area);
        System.out.println(page);
        System.out.println(num);
        List<Student> byAreaStudent = studentService.findByAreaStudent(comy, area, page, num);
        return byAreaStudent;
    }

    @RequestMapping("findbyareastudentNum")
    @ResponseBody
    public Integer findByAreaStudent(String comy, String area) {
        ArrayList<String> arealist = new ArrayList<>();
        arealist.add(area);
        Map<String, Integer> a = studentService.findByArea(comy, arealist);
        int i = a.get(area);
        return i;
    }

    @RequestMapping("getimg")
    public void getImg(HttpServletResponse response, String id) throws IOException {
        String path = "C:\\Users\\QYZ\\Desktop\\image\\";
        BufferedImage read = ImageIO.read(new File(path + id + ".jpg"));
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(read, "jpg", outputStream);
        outputStream.close();
    }
}
