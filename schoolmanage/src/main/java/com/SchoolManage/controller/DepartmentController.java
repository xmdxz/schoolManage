package com.SchoolManage.controller;

import com.SchoolManage.exception.NameNullException;
import com.SchoolManage.pojo.AdminUser;
import com.SchoolManage.pojo.DepartMent;
import com.SchoolManage.pojo.Member;
import com.SchoolManage.service.DepartmentService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author RainGoal
 * @Date 2021/2/5 16:00
 * @Description TODO
 * @Version 1.0
 */
@Controller
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    private LogService logService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("findall")
    @ResponseBody
    public List<DepartMent> findAll(int page, int num) {
        List<DepartMent> all = departmentService.findAll(page, num);
        return all;
    }

    @RequestMapping("findallnum")
    @ResponseBody
    public int findAllNum() {
        int allNum = departmentService.findAllNum();
        return allNum;
    }

    @RequestMapping("findbyname")
    @ResponseBody
    public List<DepartMent> findByName(String name, int page, int num) {
        List<DepartMent> byName = departmentService.findByName(name, page, num);
        return byName;
    }

    @RequestMapping("findbyid")
    @ResponseBody
    public DepartMent findById(int id) {
        DepartMent byId = departmentService.findById(id);
        return byId;
    }

    @RequestMapping("findbynamenum")
    @ResponseBody
    public String findByNameNum(String name) {
        return Integer.toString(departmentService.findByNameNum(name));
    }

    @RequestMapping("findbyminister")
    @ResponseBody
    public List<DepartMent> findByMinister(String minister, int page, int num) {
        List<DepartMent> byMinister = departmentService.findByMinister(minister, page, num);
        return byMinister;
    }

    @RequestMapping("findbyministernum")
    @ResponseBody
    public int findByMinisterNum(String minister) {
        int byMinisterNum = departmentService.findByMinisterNum(minister);
        return byMinisterNum;
    }

    @RequestMapping("findbycollege")
    @ResponseBody
    public List<DepartMent> findByCollege(String college, int page, int num) {
        List<DepartMent> byCollege = departmentService.findByCollege(college, page, num);
        return byCollege;
    }

    @RequestMapping("findbycollegenum")
    @ResponseBody
    public int findByCollegeNum(String college) {
        int byCollegeNum = departmentService.findByCollegeNum(college);
        return byCollegeNum;
    }

    @RequestMapping("insertdata")
    public String insertData(DepartMent departMent,String comy, HttpServletRequest request) {
        System.out.println(departMent);
        int i = departmentService.insertData(departMent);
        if (i != 0) {
            AdminUser a = (AdminUser) request.getSession().getAttribute("administer");
            logService.insertNew("??????", "??? " + departMent.getName(), a.getName(), "?????????" + departMent.getId(), "?????????", comy);
            return "loginp_1";
        } else return "redirect:/departments.html";
    }

    @RequestMapping("updatedata")
    public String updateData(DepartMent departMent, String comy,HttpServletRequest request) {
        System.out.println(departMent);
        int i = departmentService.updateData(departMent);
        if (i != 0) {
            AdminUser a = (AdminUser) request.getSession().getAttribute("administer");
            logService.insertNew("??????", "??? " + departMent.getName(), a.getName(), "?????????" + departMent.getId(), "?????????", comy);
            return "loginp_1";
        } else return "redirect:/departments.html";
    }

    @RequestMapping("deletedata")
    @ResponseBody
    public Map<String, Object> deleteData(int id, String comy,HttpServletRequest request) {
        int i = departmentService.deleteData(id);
        Map<String, Object> map = new HashMap<>();
        if (i != 0) {
            AdminUser a = (AdminUser) request.getSession().getAttribute("administer");
            logService.insertNew("??????", "??? ????????????", a.getName(), "?????????" + id, "?????????", comy);
            map.put("msg", "success");
            map.put("code", 200);
            return map;
        } else {
            map.put("msg", "failed");
            map.put("code", 500);
            return map;
        }
    }

    @RequestMapping(value = "Excle", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String ExcleStudent(HttpServletRequest request) throws NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException, NameNullException {
        int i = departmentService.findAllNum();
        CreateExlceUtil<DepartMent> createExlceUtil = new CreateExlceUtil<>(request, DepartMent.class, "?????????");
        List<DepartMent> list = departmentService.findAll(1, i);
        return createExlceUtil.createExcle(list);
    }

    @RequestMapping(value = "Excle2", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String ExcleStudent2(HttpServletRequest request) throws NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException, NameNullException {
        DepartMent departMent = new DepartMent(1, "xxx", "xxx", "xxx", "xxx", 0);
        return ExcleTemplate.getTemplate(request, departMent, "???????????????");
    }

    @RequestMapping(value = "Excle3", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String ExcleStudent3(HttpServletRequest request) throws NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException, NameNullException {
        Member member = new Member("xxx", "xxx", "xxx", "xxx", "xxx", "xxx", "xxx");
        return ExcleTemplate.getTemplate(request, member, "?????????????????????");
    }

    @PostMapping("upfile")
    @ResponseBody
    public String upfile(HttpServletRequest request,String comy, @RequestParam("file") MultipartFile file) {
        System.out.println(comy);
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
                i = departmentService.BatchAddition(path);
                dest.delete();
                AdminUser a = (AdminUser) request.getSession().getAttribute("administer");
                logService.insertNew("??????", "????????????", a.getName(), "??????", "?????????", comy);
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
}
