package com.SchoolManage.controller;

import com.SchoolManage.exception.NameNullException;
import com.SchoolManage.pojo.Dormitory;
import com.SchoolManage.pojo.Qingjia;
import com.SchoolManage.service.QingJiaService;
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
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author RainGoal
 * @Date 2021/2/19 17:26
 * @Description TODO
 * @Version 1.0
 */
@Controller
@RequestMapping("QingJia")
public class QingJiaController {
    @Autowired
    private QingJiaService qingJiaService;

    @RequestMapping("findall")
    @ResponseBody
    public List<Qingjia> findAll(Integer Page, Integer num) {
        return qingJiaService.findAll(Page, num);
    }

    @RequestMapping("findallcount")
    @ResponseBody
    public int findAllCount() {
        return qingJiaService.findAllCount();
    }

    @RequestMapping("findbystudentnopage")
    @ResponseBody
    public List<Qingjia> findByStudentNoPage(String student) {
        return qingJiaService.findByStudentNoPage(student);
    }

    @RequestMapping("findbystudent")
    @ResponseBody
    public List<Qingjia> findByStudentPage(String student, Integer Page, Integer num) {
        return qingJiaService.findByStudentPage(student, Page, num);
    }

    @RequestMapping("findbystudentcount")
    @ResponseBody
    public int findByStudentCount(String student) {
        return qingJiaService.findByStudentCount(student);
    }

    @RequestMapping("findbytimeyearandmonthandday")
    @ResponseBody
    public List<Qingjia> findByTimeYearAndMonthAndDay(Timestamp timestamp, Integer Page, Integer num) {
        return qingJiaService.findByTimeYearAndMonthAndDay(timestamp, Page, num);
    }

    @RequestMapping("findbytimeyearandmonthanddaycount")
    @ResponseBody
    public int findByTimeYearAndMonthAndDayCount(Timestamp timestamp) {
        return qingJiaService.findByTimeYearAndMonthAndDayCount(timestamp);
    }

    @RequestMapping("findbytimeyearandmonth")
    @ResponseBody
    public List<Qingjia> findByTimeYearAndMonth(Timestamp timestamp, Integer Page, Integer num) {
        return qingJiaService.findByTimeYearAndMonth(timestamp, Page, num);
    }

    @RequestMapping("findbytimeyearandmonthcount")
    @ResponseBody
    public int findByTimeYearAndMonthCount(Timestamp timestamp) {
        return qingJiaService.findByTimeYearAndMonthCount(timestamp);
    }

    @RequestMapping("findbytimeyear")
    @ResponseBody
    public List<Qingjia> findByTimeYear(Timestamp timestamp, Integer Page, Integer num) {
        return qingJiaService.findByTimeYear(timestamp, Page, num);
    }

    @RequestMapping("findbytimeyearcount")
    @ResponseBody
    public int findByTimeYearCount(Timestamp timestamp) {
        return qingJiaService.findByTimeYearCount(timestamp);
    }

    @RequestMapping("findbyteacher")
    @ResponseBody
    public List<Qingjia> findByTeacher(String teacher, Integer Page, Integer num) {
        return qingJiaService.findByTeacher(teacher, Page, num);
    }
    @RequestMapping("findbynamecount")
    @ResponseBody
    public int findByNameCount(String name) {
        return qingJiaService.findByNameCount(name);
    }

    @RequestMapping("findbyname")
    @ResponseBody
    public List<Qingjia> findByName(String name, Integer Page, Integer num) {
        return qingJiaService.findByName(name, Page, num);
    }

    @RequestMapping("insertqingjia")
    public String insertQingjia(Qingjia qingjia) {
        int i = qingJiaService.insertQingjia(qingjia);
        if (i != 0) {
            return "redirect:返回的页面";
        } else return "redirect:返回的页面";
    }

    @RequestMapping("delete")
    @ResponseBody
    public Map<String, Object> deleteQingJia(int id) {
        int i = qingJiaService.deleteQingjia(id);
        HashMap<String, Object> map = new HashMap<>();
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
    @PostMapping("upfile")
    @ResponseBody
    public String upfile(HttpServletRequest request, @RequestParam("file") MultipartFile file){
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
                i=qingJiaService.BatchAddition(path);
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
    @RequestMapping(value = "Excle",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String ExcleStudent(HttpServletRequest request) throws NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException, NameNullException {
        int i=qingJiaService.findAllCount();
        CreateExlceUtil<Qingjia> createExlceUtil = new CreateExlceUtil<>(request,Qingjia.class,"假期表");
        List<Qingjia> list =qingJiaService.findAll(1,i);
        return createExlceUtil.createExcle(list);
    }
}
