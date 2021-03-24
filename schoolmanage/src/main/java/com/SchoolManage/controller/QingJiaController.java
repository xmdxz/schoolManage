package com.SchoolManage.controller;

import com.SchoolManage.exception.NameNullException;
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
    public List<Qingjia> findAll(String comy, Integer Page, Integer num) {
        return qingJiaService.findAll(comy, Page, num);
    }

    @RequestMapping("findallcount")
    @ResponseBody
    public int findAllCount(String comy) {
        return qingJiaService.findAllCount(comy);
    }

    @RequestMapping("findbystudentnopage")
    @ResponseBody
    public List<Qingjia> findByStudentNoPage(String comy, String student) {
        return qingJiaService.findByStudentNoPage(comy, student);
    }

    @RequestMapping("findbystudent")
    @ResponseBody
    public List<Qingjia> findByStudentPage(String comy, String student, Integer Page, Integer num) {
        return qingJiaService.findByStudentPage(comy, student, Page, num);
    }

    @RequestMapping("findbystudentcount")
    @ResponseBody
    public int findByStudentCount(String comy, String student) {
        return qingJiaService.findByStudentCount(comy, student);
    }

    @RequestMapping("findbytimeyearandmonthandday")
    @ResponseBody
    public List<Qingjia> findByTimeYearAndMonthAndDay(String comy, Timestamp timestamp, Integer Page, Integer num) {
        return qingJiaService.findByTimeYearAndMonthAndDay(comy, timestamp, Page, num);
    }

    @RequestMapping("findbytimeyearandmonthanddaycount")
    @ResponseBody
    public int findByTimeYearAndMonthAndDayCount(String comy, Timestamp timestamp) {
        System.out.println(timestamp);
        return qingJiaService.findByTimeYearAndMonthAndDayCount(comy, timestamp);
    }

    @RequestMapping("findbytimeyearandmonth")
    @ResponseBody
    public List<Qingjia> findByTimeYearAndMonth(String comy, Timestamp timestamp, Integer Page, Integer num) {
        return qingJiaService.findByTimeYearAndMonth(comy, timestamp, Page, num);
    }

    @RequestMapping("findbytimeyearandmonthcount")
    @ResponseBody
    public int findByTimeYearAndMonthCount(String comy, Timestamp timestamp) {
        return qingJiaService.findByTimeYearAndMonthCount(comy, timestamp);
    }

    @RequestMapping("findbytimeyear")
    @ResponseBody
    public List<Qingjia> findByTimeYear(String comy, Timestamp timestamp, Integer Page, Integer num) {
        return qingJiaService.findByTimeYear(comy, timestamp, Page, num);
    }

    @RequestMapping("findbytimeyearcount")
    @ResponseBody
    public int findByTimeYearCount(String comy, Timestamp timestamp) {
        return qingJiaService.findByTimeYearCount(comy, timestamp);
    }

    @RequestMapping("findbyteacher")
    @ResponseBody
    public List<Qingjia> findByTeacher(String comy, String teacher, Integer Page, Integer num) {
        return qingJiaService.findByTeacher(comy, teacher, Page, num);
    }

    @RequestMapping("findbynamecount")
    @ResponseBody
    public int findByNameCount(String comy, String name) {
        return qingJiaService.findByNameCount(comy, name);
    }

    @RequestMapping("findbyname")
    @ResponseBody
    public List<Qingjia> findByName(String comy, String name, Integer Page, Integer num) {
        return qingJiaService.findByName(comy, name, Page, num);
    }
    @RequestMapping("findBystart")
    @ResponseBody
    public List<Qingjia> findBystart(String comy,String time,Integer Page, Integer num) {
        return qingJiaService.findBystart_time(comy,time,Page,num);
    }
    @RequestMapping("findByend")
    @ResponseBody
    public List<Qingjia> findByend(String comy,String time,Integer Page, Integer num) {
        return qingJiaService.findByend_time(comy,time,Page,num);
    }
    @RequestMapping("findBystartcount")
    @ResponseBody
    public int findBystartCount(String comy, String time) {
        return qingJiaService.findBystart_timeCount(comy,time);
    }

    @RequestMapping("findByendcount")
    @ResponseBody
    public int findByendCount(String comy, String time) {
        return qingJiaService.findByend_timeCount(comy,time);
    }
    @RequestMapping("findByNow_time")
    @ResponseBody
    public int findByNow_time(String comy) {
        return qingJiaService.findByNow_time(comy);
    }

    @RequestMapping("insertqingjia")
    public String insertQingjia(Qingjia qingjia) {
        int i = qingJiaService.insertQingjia(qingjia);
        if (i != 0) {
            if (qingjia.getComy().equals("2019"))
                return "loginp_6";
            else
                return "loginp_6-20";
        } else {
            if (qingjia.getComy().equals("2019"))
                return "redirect:/edit-holiday.html";
            else
                return "redirect:/edit-holiday-20.html";

        }
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
                i = qingJiaService.BatchAddition(path, comy);
                dest.delete();
                return "上传成功了";
            } catch (Exception e) {
                dest.delete();
                return "上传的表格不匹配,请进行修改后重先上传";
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败了";
    }

    @RequestMapping(value = "Excle", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String ExcleStudent(HttpServletRequest request, String comy,String time,String time1) throws NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException, NameNullException {
        CreateExlceUtil<Qingjia> createExlceUtil;
        List<Qingjia> list;
        if (time != null && "".equals(time)) {
            int i = qingJiaService.findBystart_timeCount(comy,time);
            createExlceUtil = new CreateExlceUtil<>(request, Qingjia.class, "假期表");
            list = qingJiaService.findBystart_time(comy,time, 1, i);
        }
        else if(time1 != null && "".equals(time1)){
            int i = qingJiaService.findByend_timeCount(comy,time1);
            createExlceUtil = new CreateExlceUtil<>(request, Qingjia.class, "假期表");
            list = qingJiaService.findByend_time(comy,time1, 1, i);
        }
        else {
            int i = qingJiaService.findAllCount(comy);
            createExlceUtil = new CreateExlceUtil<>(request, Qingjia.class, "假期表");
            list = qingJiaService.findAll(comy, 1, i);
        }
        return createExlceUtil.createExcle(list);
    }

    @RequestMapping("update")
    public String updateQingJia(Qingjia qingjia) {
        int i = qingJiaService.updateQingJia(qingjia);
        if (i != 0) {
            if (qingjia.getComy().equals("2019"))
                return "loginp_6";
            else
                return "loginp_6-20";
        } else {
            if (qingjia.getComy().equals("2019"))
                return "redirect:/edit-holiday.html";
            else
                return "redirect:/edit-holiday-20.html";

        }
    }

    @RequestMapping("findbyid")
    @ResponseBody
    public Qingjia findById(int id) {
        return qingJiaService.findById(id);
    }

    @RequestMapping("findBYweek")
    @ResponseBody
    public Map<String, List<Qingjia>> findBYweek(String comy) {


        Map<String, List<Qingjia>> byArea = qingJiaService.findBYweek_time(comy);
        return byArea;
    }

}
