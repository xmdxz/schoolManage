package com.SchoolManage.controller;

import com.SchoolManage.exception.NameNullException;
import com.SchoolManage.pojo.Honour;
import com.SchoolManage.service.HonourService;
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
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author RainGoal
 * @Date 2021/2/18 16:55
 * @Description TODO
 * @Version 1.0
 */
@Controller
@RequestMapping("honour")
public class HonourController {
    @Autowired
    private HonourService honourService;

    @RequestMapping("findall")
    @ResponseBody
    public List<Honour> findAll(Integer Page, Integer num) {
        return honourService.findAll(Page, num);
    }

    @RequestMapping("findallcount")
    @ResponseBody
    public int findAllCount() {
        return honourService.findAllCount();
    }

    @RequestMapping("findbystudent")
    @ResponseBody
    public List<Honour> findByStudentPage(String student, Integer Page, Integer num) {
        return honourService.findByStudentPage(student, Page, num);
    }

    @RequestMapping("findbynamecount")
    @ResponseBody
    public int findByNameCount(String name) {
        return honourService.findByNameCount(name);
    }

    @RequestMapping("findbyname")
    @ResponseBody
    public List<Honour> findByName(String name, Integer Page, Integer num) {
        return honourService.findByName(name, Page, num);
    }

    @RequestMapping("findbystudentnopage")
    @ResponseBody
    public List<Honour> findByStudentNoPage(String student) {
        return honourService.findByStudentNoPage(student);
    }

    @RequestMapping("findbystudentcount")
    @ResponseBody
    public int findByStudentCount(String student) {
        return honourService.findByStudentCount(student);
    }

    @RequestMapping("findbytype")
    @ResponseBody
    public List<Honour> findByType(String Type, Integer Page, Integer num) {
        return honourService.findByType(Type, Page, num);
    }

    @RequestMapping("findbytypecount")
    @ResponseBody
    public int findByTypeCount(String type) {
        return honourService.findByTypeCount(type);
    }

    @RequestMapping("findbyprize")
    @ResponseBody
    public List<Honour> findByPrize(String prize, Integer Page, Integer num) {
        return honourService.findByPrize(prize, Page, num);
    }

    @RequestMapping("findbyprizecount")
    @ResponseBody
    public int findByPrizeCount(String prize) {
        return honourService.findByPrizeCount(prize);
    }

    @RequestMapping("findbytime")
    @ResponseBody
    public List<Honour> findByTime(Date time, Integer Page, Integer num) {
        return honourService.findByTime(time, Page, num);
    }

    @RequestMapping("findbytimecount")
    @ResponseBody
    public int findByTimeCount(Date time) {
        return honourService.findByTimeCount(time);
    }

    @RequestMapping("findbytimeyearandmonth")
    @ResponseBody
    public List<Honour> findByTimeYearAndMonth(Date time, Integer Page, Integer num) {
        return honourService.findByTimeYearAndMonth(time, Page, num);
    }

    @RequestMapping("findbytimeyearandmonthcount")
    @ResponseBody
    public int findByTimeYearAndMonthCount(Date time) {
        return honourService.findByTimeYearAndMonthCount(time);
    }

    @RequestMapping("findbytimeyear")
    @ResponseBody
    public List<Honour> findByTimeYear(Date time, Integer Page, Integer num) {
        return honourService.findByTimeYear(time, Page, num);
    }

    @RequestMapping("findbytimeyearcount")
    @ResponseBody
    public int findByTimeYearCount(Date time) {
        return honourService.findByTimeYearCount(time);
    }

    @RequestMapping("findbyconditions")
    @ResponseBody
    public List<Honour> findByConditions(Map<String, String> map, Integer Page, Integer num) {
        return honourService.findByConditions(map, Page, num);
    }

    @RequestMapping("inserthon")
    public String insertHon(Honour honour) {
        int i = honourService.insertHon(honour);
        if (i != 0) {
            return "loginp_7";
        } else return "redirect:/add-honour.html";
    }

    @RequestMapping("deletehon")
    @ResponseBody
    public Map<String, Object> deleteHon(int id) {
        Map<String, Object> map = new HashMap<>();
        int i = honourService.deleteHon(id);
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


    @RequestMapping("findbyid")
    @ResponseBody
    public Honour findById(int id) {
        return honourService.findById(id);
    }

    @RequestMapping("update")
    @ResponseBody
    public String updateHonour(Honour honour) {
        int i = honourService.updateHonour(honour);
        if (i != 0) {
            return "1";
        } else return "0";
    }

    @RequestMapping(value = "Excle", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String ExcleStudent(HttpServletRequest request) throws NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException, NameNullException {
        int i = honourService.findAllCount();
        CreateExlceUtil<Honour> createExlceUtil = new CreateExlceUtil<>(request, Honour.class, "荣誉表");
        List<Honour> list = honourService.findAll(1, i);
        return createExlceUtil.createExcle(list);

    }

    @PostMapping("upfile")
    @ResponseBody
    public String upfile(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
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
                i = honourService.BatchAddition(path);
                System.out.println(new File(path).delete());
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
}
