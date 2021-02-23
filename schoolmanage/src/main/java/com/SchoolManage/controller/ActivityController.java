package com.SchoolManage.controller;

import com.SchoolManage.exception.NameNullException;
import com.SchoolManage.pojo.Activity;
import com.SchoolManage.pojo.AdminUser;
import com.SchoolManage.service.ActivityService;
import com.SchoolManage.service.LogService;
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
 * @Date 2021/2/17 16:48
 * @Description TODO
 * @Version 1.0
 */
@Controller
@RequestMapping("activity")
public class ActivityController {
    @Autowired
    private LogService logService;

    @Autowired
    private ActivityService activityService;

    @RequestMapping("findall")
    @ResponseBody
    public List<Activity> findAll(int page, int num) {
        List<Activity> list = activityService.findAll(page, num);
        return list;
    }

    @RequestMapping("findallcount")
    @ResponseBody
    public int findAllCount() {
        int allCount = activityService.findAllCount();
        return allCount;
    }

    @RequestMapping("findbystudentpage")
    @ResponseBody
    public List<Activity> findByStudentPage(String student,
                                            int page,
                                            int num) {
        List<Activity> byStudentPage = activityService.findByStudentPage(student, page, num);
        return byStudentPage;
    }

    @RequestMapping("findByStudentNoPage")
    @ResponseBody
    public List<Activity> findByStudentNoPage(String student) {
        return activityService.findByStudentNoPage(student);
    }

    @RequestMapping("findbystudentcount")
    @ResponseBody
    public int findByStudentCount(String student) {
        return activityService.findByStudentCount(student);
    }

    @RequestMapping("findbyactive")
    @ResponseBody
    public List<Activity> findByActive(String active, Integer Page, Integer num) {
        return activityService.findByActive(active, Page, num);
    }

    @RequestMapping("findbyactivecount")
    @ResponseBody
    public Integer findByActiveCount(String active) {
        return activityService.findByActiveCount(active);
    }

    @RequestMapping("findbytime")
    @ResponseBody
    public List<Activity> findByTime(Date date, Integer Page, Integer num) {
        return activityService.findByTime(date, Page, num);
    }

    @RequestMapping("findbytimecount")
    @ResponseBody
    public int findByTimeCount(Date date) {
        return activityService.findByTimeCount(date);
    }

    @RequestMapping("findbytimeyearandmonthcount")
    @ResponseBody
    public List<Activity> findByTimeYearAndMonth(Date time, Integer Page, Integer num) {
        return activityService.findByTimeYearAndMonth(time, Page, num);
    }

    @RequestMapping("findbyres")
    @ResponseBody
    public List<Activity> findByRes(String responsible, Integer Page, Integer num) {
        return activityService.findByRes(responsible, Page, num);
    }

    @RequestMapping("findbyrescount")
    @ResponseBody
    public int findByResCount(String responsible) {
        return activityService.findByResCount(responsible);
    }

    @RequestMapping("findbytimeyear")
    @ResponseBody
    public List<Activity> findByTimeYear(Date time, Integer Page, Integer num) {
        return findByTimeYear(time, Page, num);
    }

    @RequestMapping("findbytimeyearcount")
    @ResponseBody
    public int findByTimeYearCount(Date time) {
        return activityService.findByTimeYearCount(time);
    }

    @RequestMapping("insertac")
    public String insertAc(Activity activity,HttpServletRequest request) {
        int i = activityService.insertAc(activity);
        if (i != 0) {
            AdminUser a =(AdminUser) request.getSession().getAttribute("administer");
            logService.insertNew("更新","的 "+activity.getActive(),a.getName(),"编号为"+activity.getId(),"活动表");
            return "loginp_3";
        } else return "redirect:/activity.html";
    }

    @RequestMapping("deleteac")
    @ResponseBody
    public Map<String, Object> deleteAc(int id,HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        int i = activityService.deleteAc(id);
        if (i != 0) {
            AdminUser a =(AdminUser) request.getSession().getAttribute("administer");
            logService.insertNew("删除","的活动信息 ",a.getName(),"编号为"+id,"活动表");
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
    public Activity findById(int id) {
        return activityService.findById(id);
    }

    @RequestMapping("update")
    public String update(Activity activity,HttpServletRequest request) {
        int i = activityService.updateData(activity);
        if (i != 0) {
            AdminUser a =(AdminUser) request.getSession().getAttribute("administer");
            logService.insertNew("更新","的 "+activity.getActive(),a.getName(),"编号为"+activity.getId(),"活动表");
            return "loginp_3";
        } else return "redirect:/activity.html";
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
                i = activityService.BatchAddition(path);
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
    public String ExcleStudent(HttpServletRequest request,String responsible) throws
            NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException, NameNullException {
        CreateExlceUtil<Activity>createExlceUtil;
        List<Activity> list;
        if(responsible!=null)
        {
            int i=activityService.findByResCount(responsible);
            createExlceUtil = new CreateExlceUtil<>(request, Activity.class, "活动表");
            list = activityService.findByRes(responsible,1, i);
        }
        else {
            int i = activityService.findAllCount();
            createExlceUtil = new CreateExlceUtil<>(request, Activity.class, "活动表");
            list = activityService.findAll(1, i);
        }

        return createExlceUtil.createExcle(list);

    }
}

