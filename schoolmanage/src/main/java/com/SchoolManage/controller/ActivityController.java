package com.SchoolManage.controller;

import com.SchoolManage.exception.NameNullException;
import com.SchoolManage.pojo.Activemember;
import com.SchoolManage.pojo.Activity;
import com.SchoolManage.pojo.AdminUser;
import com.SchoolManage.service.ActivityService;
import com.SchoolManage.service.LogService;
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
    public String insertAc(Activity activity, String comy,HttpServletRequest request) {
        int i = activityService.insertAc(activity);
        if (i != 0) {
            AdminUser a = (AdminUser) request.getSession().getAttribute("administer");
            logService.insertNew("??????", "??? " + activity.getActive(), a.getName(), "?????????" + activity.getId(), "?????????",comy);
            return "loginp_3";
        } else return "redirect:/activity.html";
    }

    @RequestMapping("deleteac")
    @ResponseBody
    public Map<String, Object> deleteAc(int id, String comy,HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        int i = activityService.deleteAc(id);
        if (i != 0) {
            AdminUser a = (AdminUser) request.getSession().getAttribute("administer");
            logService.insertNew("??????", "??????????????? ", a.getName(), "?????????" + id, "?????????",comy);
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
    public String update(Activity activity, String comy,HttpServletRequest request) {
        int i = activityService.updateData(activity);
        if (i != 0) {
            AdminUser a = (AdminUser) request.getSession().getAttribute("administer");
            logService.insertNew("??????", "??? " + activity.getActive(), a.getName(), "?????????" + activity.getId(), "?????????",comy);
            return "loginp_3";
        } else return "redirect:/activity.html";
    }

    @PostMapping("upfile")
    @ResponseBody
    public String upfile(HttpServletRequest request,String comy, @RequestParam("file") MultipartFile file) {
        if (file == null) {
            return "???????????????";
        }
        try {
            String filename = file.getOriginalFilename();
            String extFileName = filename.substring(filename.lastIndexOf(".") + 1, filename.length());
//            System.out.println("?????????:\t"+filename);
//            System.out.println("?????????:\t"+extFileName);
            //???????????????,??????????????????????????????
            String filePath = request.getServletContext().getRealPath("/") + "File\\";
            String path = filePath + filename;
            //??????????????????
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
                AdminUser a = (AdminUser) request.getSession().getAttribute("administer");
                logService.insertNew("??????", "????????????", a.getName(), "??????", "?????????",comy);
                return "???????????????";
            } catch (Exception e) {
                dest.delete();
                return "????????????????????????,??????????????????????????????";
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return "???????????????";
    }

    @RequestMapping(value = "Excle", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String ExcleStudent(HttpServletRequest request, String responsible) throws
            NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException, NameNullException {
        CreateExlceUtil<Activity> createExlceUtil;
        List<Activity> list;
        if (responsible != null && !"".equals(responsible)) {
            int i = activityService.findByResCount(responsible);
            createExlceUtil = new CreateExlceUtil<>(request, Activity.class, "?????????");
            list = activityService.findByRes(responsible, 1, i);
        } else {
            int i = activityService.findAllCount();
            createExlceUtil = new CreateExlceUtil<>(request, Activity.class, "?????????");
            list = activityService.findAll(1, i);
        }

        return createExlceUtil.createExcle(list);

    }

    @RequestMapping(value = "Excle2", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String ExcleStudent2(HttpServletRequest request) throws NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException, NameNullException {
        Activity activity = new Activity(1, "xxx", "xxx", "xxx", new Date(2020 - 02 - 03), 0, "??????");
        return ExcleTemplate.getTemplate(request, activity, "???????????????");

    }

    @RequestMapping(value = "Excle3", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String ExcleStudent3(HttpServletRequest request) throws NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException, NameNullException {
        Activemember activemember = new Activemember(1, 1, "xxx", "xxx", "xxx", "xxx", "xxx");
        return ExcleTemplate.getTemplate(request, activemember, "?????????????????????");

    }
}

