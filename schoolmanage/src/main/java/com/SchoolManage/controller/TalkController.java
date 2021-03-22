package com.SchoolManage.controller;

import com.SchoolManage.dao.TalkService;
import com.SchoolManage.pojo.AdminUser;
import com.SchoolManage.pojo.Talk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author RainGoal
 * @Date 2021/2/19 12:04
 * @Description TODO
 * @Version 1.0
 */
@Controller
@RequestMapping("talk")
public class TalkController {
    @Autowired
    private TalkService talkService;

    @RequestMapping("findall")
    @ResponseBody
    public List<Talk> findAll(String comy, HttpServletRequest request) {
//        AdminUser a = (AdminUser) request.getSession().getAttribute("administer");
        return talkService.findAll(comy);
    }

    //    @RequestMapping("findallcount")
//    @ResponseBody
//    public int findAllCount(HttpServletRequest request) {
//        AdminUser a = (AdminUser) request.getSession().getAttribute("administer");
//        return talkService.findAllCount(a.getName());
//    }
    @RequestMapping("findallcount")
    @ResponseBody
    public int findAllCount(String comy) {
        return talkService.findAllCount(comy);
    }

    @RequestMapping("findallpage")
    @ResponseBody
    public List<Talk> findAllPage(String comy, Integer Page, Integer num) {
        return talkService.findAllPage(comy, (Page - 1) * num, num);
    }


    @RequestMapping("inserttalk")
    public String insertTalk(Talk talk, HttpServletRequest request) {
        AdminUser a = (AdminUser) request.getSession().getAttribute("administer");
        talk.setTeacher(a.getName());
        talk.setComy("2019");
        int i = talkService.insertTalk(talk);
        if (i != 0) {
            return "redirect:/loginp_5.html?id=1";
        } else return "redirect:/edit-talk.html?error=true";
    }

    @RequestMapping("inserttalk2")
    public String insertTalk2(Talk talk, HttpServletRequest request) {
        AdminUser a = (AdminUser) request.getSession().getAttribute("administer");
        talk.setTeacher(a.getName());
        talk.setComy("2020");
        int i = talkService.insertTalk(talk);
        if (i != 0) {
            return "redirect:/loginp_5.html?id=2";
        } else return "redirect:/edit-talk.html?error=true";
    }

//    @RequestMapping("findbystudentnopage")
//    @ResponseBody
//    public List<Talk> findByStudentNoPage(String student, HttpServletRequest request) {
//        AdminUser a = (AdminUser) request.getSession().getAttribute("administer");
//        return talkService.findByStudentNoPage(student, a.getName());
//    }

//    @RequestMapping("findbystudentpage")
//    @ResponseBody
//    public List<Talk> findByStudentPage(String student, Integer Page, HttpServletRequest request) {
//        AdminUser a = (AdminUser) request.getSession().getAttribute("administer");
//        return talkService.findByStudentPage(student, Page, a.getName());
//    }
//
//    @RequestMapping("findbystudentcount")
//    @ResponseBody
//    public int findByStudentCount(String student, HttpServletRequest request) {
//        AdminUser a = (AdminUser) request.getSession().getAttribute("administer");
//        return talkService.findByStudentCount(student, a.getName());
//    }

    @RequestMapping("findbystudent")
    @ResponseBody
    public List<Talk> findByStudent(String comy, String student, Integer Page, Integer num) {
        return talkService.findByStudent(comy, student, (Page - 1) * num, num);
    }

    @RequestMapping("findbydate")
    @ResponseBody
    public List<Talk> findByDate(String comy, Date date, Integer Page, Integer num) {
        return talkService.findByDate(comy, date, (Page - 1) * num, num);
    }

    @RequestMapping("findbydatecount")
    @ResponseBody
    public int findByDateCount(String comy, Date date) {
        return talkService.findByDateCount(comy, date);
    }

    @RequestMapping("findbystudentcount")
    @ResponseBody
    public int findByStudentCount(String student) {
        return talkService.findByStudentCount(student);
    }

    @RequestMapping("findbyteacher")
    @ResponseBody
    public List<Talk> findByTeacher(String comy, String teacher, Integer Page, Integer num) {
        return talkService.findByTeacher(comy, teacher, (Page - 1) * num, num);
    }

    @RequestMapping("findbyteachercount")
    @ResponseBody
    public int findByTeacherCount(String comy, String teacher) {
        return talkService.findByTeacherCount(comy, teacher);
    }

    @RequestMapping("deletetalk")
    @ResponseBody
    public Map<String, Object> deleteTalk(Integer id, HttpServletRequest request) {
//        AdminUser a = (AdminUser) request.getSession().getAttribute("administer");
        int i = talkService.deleteTalk(id);
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

    @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping("findbytime")
    @ResponseBody
    public List<Talk> findByTime(String comy, Date date, Integer Page, Integer num) {
        return talkService.findByTime(comy, date, (Page - 1) * num, num);
    }

    //    @RequestMapping("findbytime2")
//    @ResponseBody
//    public List<Talk> findByTime2(Date date, HttpServletRequest request) {
//        AdminUser a = (AdminUser) request.getSession().getAttribute("administer");
//        return talkService.findByTime("2020", date);
//    }
//    @RequestMapping("findbytimecount")
//    @ResponseBody
//    public int findByTimeCount(Date date, HttpServletRequest request) {
//        AdminUser a = (AdminUser) request.getSession().getAttribute("administer");
//        return talkService.findByTimeCount(date, a.getName());
//    }
    @RequestMapping("findbytimecount")
    @ResponseBody
    public int findByTimeCount(String comy, Date date) {
        return talkService.findByTimeCount(comy, date);
    }

    @RequestMapping("findbytimeyearandmonth")
    @ResponseBody
    public List<Talk> findByTimeYearAndMonth(String comy, Date date, Integer Page, Integer num) {
        return talkService.findByTimeYearAndMonth(comy, date, (Page - 1) * num, num);
    }

    @RequestMapping("findbytimeyearandmonthcount")
    @ResponseBody
    public int findByTimeYearAndMonthCount(String comy, Date date) {
        return talkService.findByTimeYearAndMonthCount(comy, date);
    }

    @RequestMapping("findbytimeyear")
    @ResponseBody
    public List<Talk> findByTimeYear(String comy, Date date, String name, Integer Page, Integer num) {
        return talkService.findByTimeYear(comy, date, name, (Page - 1) * num, num);
    }

    //    @RequestMapping("findbytimeyearandmonthcount")
//    @ResponseBody
//    public int findByTimeYearAndMonthCount(Date date) {
//        return talkService.findByTimeYearAndMonthCount(date);
//    }
    @RequestMapping("findbytimeyearcount")
    @ResponseBody
    public int findByTimeYearCount(String comy, Date date) {
        return talkService.findByTimeYearCount(comy, date);
    }

    @RequestMapping("findbyid")
    @ResponseBody
    public Talk findById(Integer id, String comy) {
        return talkService.findById(id, comy);
    }

    @RequestMapping("findbytypes")
    @ResponseBody
    public List<Talk> findByTypes(String types, String comy, Integer Page, Integer num) {
        return talkService.findByTypes(types, comy, (Page - 1) * num, num);
    }

    @RequestMapping("findbytypescount")
    @ResponseBody
    public int findByTypesCount(String types, String comy) {
        return talkService.findByTypesCount(types, comy);
    }

    @RequestMapping("findbydateandtypesandlevel")
    @ResponseBody
    public List<Talk> findByDateAndTypesAndLevel(Date time, String types, String level, String comy, Integer Page, Integer num) {
        return talkService.findByDateAndTypesAndLevel(time, types, level, comy, (Page - 1) * num, num);
    }

    @RequestMapping("findbydateandtypesandlevelcount")
    @ResponseBody
    public int findByDateAndTypesAndLevelCount(Date time, String types, String level, String comy) {
        return talkService.findByDateAndTypesAndLevelCount(time, types, level, comy);
    }

    //这个接口用于绑定的时候验证权限
    @RequestMapping("checkuser")
    @ResponseBody
    public boolean check(Integer id, String comy, HttpServletRequest request) {
        Talk talk = talkService.findById(id, comy);
        if (talk == null) return false;
        AdminUser a = (AdminUser) request.getSession().getAttribute("administer");
        if (talk.getTeacher().equals(a.getName())) return true;
        else return false;
    }

    @RequestMapping("update")
    public String update(Talk talk, HttpServletRequest request) {
        AdminUser a = (AdminUser) request.getSession().getAttribute("administer");
        talk.setTeacher(a.getName());
        int i = talkService.updata(talk);
        if (i != 0) {
            return "redirect:/loginp_5.html?id=" + (talk.getComy().equals("2019") ? "1" : "2");
        } else return "redirect:/edit-talk.html?error=true";
    }
}
