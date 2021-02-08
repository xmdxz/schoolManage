package com.SchoolManage.controller;

import com.SchoolManage.exception.NameNullException;
import com.SchoolManage.pojo.DepartMent;
import com.SchoolManage.pojo.Dormitory;
import com.SchoolManage.pojo.Student;
import com.SchoolManage.service.DormitoryService;
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

/**
 * @Author RainGoal
 * @Date 2021/2/8 13:54
 * @Description TODO
 * @Version 1.0
 */
@Controller
@RequestMapping("dormitory")
public class DormitoryController {
    @Autowired
    private DormitoryService dormitoryService;

    @RequestMapping("findDormitoryMember")
    @ResponseBody
    public List<Student> findDormitoryMember(Dormitory dormitory, int Page, int num) {
        return dormitoryService.findDormitoryMember(dormitory, Page, num);
    }

    @RequestMapping("findDormitoryMemberNum")
    @ResponseBody
    public int findDormitoryMemberNum(Dormitory dormitory) {
        return dormitoryService.findDormitoryMemberNum(dormitory);
    }

    @RequestMapping("findAll")
    @ResponseBody
    public List<Dormitory> findAll(int Page, int num) {

        return dormitoryService.findAll(Page, num);
    }

    @RequestMapping("findAllNum")
    @ResponseBody
    public int findAllNum() {
        return dormitoryService.findAllNum();
    }

    @RequestMapping("findByName")
    @ResponseBody
    public List<Dormitory> findByName(String name, int Page, int num) {
        return dormitoryService.findByName(name, Page, num);
    }

    @RequestMapping("findByNameNum")
    @ResponseBody
    public int findByNameNum(String name) {
        return dormitoryService.findByNameNum(name);
    }

    @RequestMapping("findById")
    @ResponseBody
    public Dormitory findById(String id) {
        return dormitoryService.findById(id);
    }

    @RequestMapping("findByBuilding")
    @ResponseBody
    public List<Dormitory> findByBuilding(String building, int Page, int num) {
        return dormitoryService.findByBuilding(building, Page, num);
    }

    @RequestMapping("findByBuildingNum")
    @ResponseBody
    public int findByBuildingNum(String building) {
        return dormitoryService.findByBuildingNum(building);
    }

    @RequestMapping("findByNumber")
    @ResponseBody
    public List<Dormitory> findByNumber(String number, int Page, int num) {
        return dormitoryService.findByNumber(number, Page, num);
    }

    @RequestMapping("findByNumberNum")
    @ResponseBody
    public int findByNumberNum(String number) {
        return dormitoryService.findByNumberNum(number);
    }

    @RequestMapping("findByBuildingAndNumber")
    @ResponseBody
    public Dormitory findByBuildingAndNumber(String building, String number) {
        return dormitoryService.findByBuildingAndNumber(building, number);
    }

    @RequestMapping("insertData")
    public String insertData(Dormitory dormitory) {
        int i = dormitoryService.insertData(dormitory);
        if (i!=0){
            return  "loginp_2";
        }else return "redirect:/hostel.html";
    }

    @RequestMapping("deleteData")
    @ResponseBody
    public Map<String, Object> deleteData(String building, String number) {
        int i = dormitoryService.deleteData(building, number);
        Map<String, Object> map = new HashMap<>();
        if (i != 0) {
            map.put("msg", "success");
            map.put("code", 200);
            return map;
        } else {
            map.put("msg", "failed");
            map.put("code", 500);
            return map;
        }
    }

    @RequestMapping("updateData")
    public String updateData(Dormitory dormitory) {
        int i = dormitoryService.updateData(dormitory);
        if (i!=0){
            return  "loginp_2";
        }else return "redirect:/hostel.html";
    }
    @RequestMapping(value = "Excle",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String ExcleStudent(HttpServletRequest request) throws NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException, NameNullException {
        int i=dormitoryService.findAllNum();
        CreateExlceUtil<Dormitory> createExlceUtil = new CreateExlceUtil<>(request,Dormitory.class,"宿舍表");
        List<Dormitory> list =dormitoryService.findAll(1,i);
        return createExlceUtil.createExcle(list);
    }
    @PostMapping("upfile")
    @ResponseBody
    public String upfile(HttpServletRequest request,@RequestParam("file") MultipartFile file){
        if (file==null){
            return "请选择文件";
        }
        try {
            String filename = file.getOriginalFilename();
            String extFileName = filename.substring(filename.lastIndexOf("." ) +1,filename.length());
//            System.out.println("文件名:\t"+filename);
//            System.out.println("后缀名:\t"+extFileName);
            //上传到本地,模拟上传到文件服务器
            String filePath = request.getServletContext().getRealPath("/") + "File\\" ;
            String path = filePath + filename;
            //文件存储路径
            File dest = new File(path);
            if (!dest.getParentFile().exists()){
                dest.getParentFile().mkdir();
            }
            file.transferTo(dest);
            int i=66;
            try {
                System.out.println(path);
                i=dormitoryService.BatchAddition(path);
                dest.delete();
                return "上传成功了";
            }catch (Exception e)
            {
                dest.delete();
                return "上传的表格不匹配,请进行修改后重先上传";
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败了";
    }
}
