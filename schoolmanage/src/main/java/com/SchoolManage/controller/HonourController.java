package com.SchoolManage.controller;

import com.SchoolManage.exception.NameNullException;
import com.SchoolManage.pojo.Honour;
import com.SchoolManage.service.HonourService;
import com.SchoolManage.util.CreateExlceUtil;
import com.SchoolManage.util.ExcleTemplate;
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
    public List<Honour> findAll(String comy, Integer Page, Integer num) {
        return honourService.findAll(comy, Page, num);
    }

    @RequestMapping("findallcount")
    @ResponseBody
    public int findAllCount(String comy) {
        return honourService.findAllCount(comy);
    }

    @RequestMapping("findbystudent")
    @ResponseBody
    public List<Honour> findByStudentPage(String comy, String student, Integer Page, Integer num) {
        return honourService.findByStudentPage(comy, student, Page, num);
    }

    @RequestMapping("findbynamecount")
    @ResponseBody
    public int findByNameCount(String comy, String name) {
        return honourService.findByNameCount(comy, name);
    }

    @RequestMapping("findbyname")
    @ResponseBody
    public List<Honour> findByName(String comy, String name, Integer Page, Integer num) {
        return honourService.findByName(comy, name, Page, num);
    }

    @RequestMapping("findbystudentnopage")
    @ResponseBody
    public List<Honour> findByStudentNoPage(String comy, String student) {
        return honourService.findByStudentNoPage(comy, student);
    }

    @RequestMapping("findbystudentcount")
    @ResponseBody
    public int findByStudentCount(String comy, String student) {
        return honourService.findByStudentCount(comy, student);
    }

    @RequestMapping("findbytype")
    @ResponseBody
    public List<Honour> findByType(String comy, String Type, Integer Page, Integer num) {
        return honourService.findByType(comy, Type, Page, num);
    }

    @RequestMapping("findbytypecount")
    @ResponseBody
    public int findByTypeCount(String comy, String type) {
        return honourService.findByTypeCount(comy, type);
    }

    @RequestMapping("findbyprize")
    @ResponseBody
    public List<Honour> findByPrize(String comy, String prize, Integer Page, Integer num) {
        return honourService.findByPrize(comy, prize, Page, num);
    }

    @RequestMapping("findbyprizecount")
    @ResponseBody
    public int findByPrizeCount(String comy, String prize) {
        return honourService.findByPrizeCount(comy, prize);
    }

    @RequestMapping("findbytime")
    @ResponseBody
    public List<Honour> findByTime(String comy, Date time, Integer Page, Integer num) {
        return honourService.findByTime(comy, time, Page, num);
    }

    @RequestMapping("findbytimecount")
    @ResponseBody
    public int findByTimeCount(String comy, Date time) {
        return honourService.findByTimeCount(comy, time);
    }

    @RequestMapping("findbytimeyearandmonth")
    @ResponseBody
    public List<Honour> findByTimeYearAndMonth(String comy, Date time, Integer Page, Integer num) {
        return honourService.findByTimeYearAndMonth(comy, time, Page, num);
    }

    @RequestMapping("findbytimeyearandmonthcount")
    @ResponseBody
    public int findByTimeYearAndMonthCount(String comy, Date time) {
        return honourService.findByTimeYearAndMonthCount(comy, time);
    }

    @RequestMapping("findbytimeyear")
    @ResponseBody
    public List<Honour> findByTimeYear(String comy, Date time, Integer Page, Integer num) {
        return honourService.findByTimeYear(comy, time, Page, num);
    }

    @RequestMapping("findbytimeyearcount")
    @ResponseBody
    public int findByTimeYearCount(String comy, Date time) {
        return honourService.findByTimeYearCount(comy, time);
    }

    @RequestMapping("findbyconditions")
    @ResponseBody
    public List<Honour> findByConditions(String comy, Map<String, String> map, Integer Page, Integer num) {
        return honourService.findByConditions(comy, map, Page, num);
    }

    @RequestMapping("inserthon")
    public String insertHon(Honour honour) {
        int i = honourService.insertHon(honour);
        if (i != 0) {
            if (honour.getComy().equals("2019"))
                return "loginp_7";
            else
                return "loginp_7-20";
        } else {
            if (honour.getComy().equals("2019"))
                return "redirect:/add-honour.html";
            else
                return "redirect:/add-honour-20.html";
        }
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
    public String updateHonour(Honour honour) {
        int i = honourService.updateHonour(honour);
        if (i != 0) {
            if (honour.getComy().equals("2019"))
                return "loginp_7";
            else
                return "loginp_7-20";
        } else {
            if (honour.getComy().equals("2019"))
                return "redirect:/add-honour.html";
            else
                return "redirect:/add-honour-20.html";
        }
    }

    @RequestMapping(value = "Excle", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String ExcleStudent(HttpServletRequest request, String comy) throws NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException, NameNullException {
        int i = honourService.findAllCount(comy);
        CreateExlceUtil<Honour> createExlceUtil = new CreateExlceUtil<>(request, Honour.class, "荣誉表");
        List<Honour> list = honourService.findAll(comy, 1, i);
        return createExlceUtil.createExcle(list);

    }

    @RequestMapping(value = "Excle2", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String ExcleStudent2(HttpServletRequest request) throws NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException, NameNullException {
        Honour honour = new Honour(1, "xxx", "xxx", "xxx", new Date(2020 - 02 - 03), "xxx", "xxx", "年级");
        return ExcleTemplate.getTemplate(request, honour, "荣誉表模板");

    }

    @PostMapping("upfile")
    @ResponseBody
    public String upfile(HttpServletRequest request, @RequestParam("file") MultipartFile file, String comy) {
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
                i = honourService.BatchAddition(path, comy);
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
