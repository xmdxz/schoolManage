package com.SchoolManage.controller;

import com.SchoolManage.exception.NameNullException;
import com.SchoolManage.pojo.AdminUser;
import com.SchoolManage.pojo.Member;
import com.SchoolManage.service.LogService;
import com.SchoolManage.service.MemberService;
import com.SchoolManage.util.CreateExlceUtil;
import com.SchoolManage.util.UnicodeUtil;
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
 * @Date 2021/2/6 8:39
 * @Description TODO
 * @Version 1.0
 */
@Controller
@RequestMapping("member")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private LogService logService;

    @RequestMapping("findall")
    @ResponseBody
    public List<Member> findAll(int page, int num) {
        List<Member> all = memberService.findAll(page, num);
        return all;
    }

    @RequestMapping("findallnum")
    @ResponseBody
    public int findAllNum() {
        return memberService.findAllNum();
    }

    @RequestMapping("findbydepartment")
    @ResponseBody
    public List<Member> findByDepartment(String department, int page, int num) {
        List<Member> byDepartment = memberService.findByDepartment(department, page, num);
        return byDepartment;
    }

    @RequestMapping("findbydepartmentnum")
    @ResponseBody
    public String findByDepartmentNum(String department) {
        return Integer.toString(memberService.findByDepartmentNum(department));
    }

    @RequestMapping("findbyid")
    @ResponseBody
    public Member findById(String id) {
        Member byId = memberService.findById(id);
        return byId;
    }

    @RequestMapping("findbyname")
    @ResponseBody
    public List<Member> findByName(String name, int page, int num) {
        List<Member> byName = memberService.findByName(name, page, num);
        return byName;
    }

    @RequestMapping("findbynamenum")
    @ResponseBody
    public String findByNameNum(String name) {
        return Integer.toString(memberService.findByNameNum(name));
    }

    @RequestMapping("findbyposition")
    @ResponseBody
    public List<Member> findByPosition(String position, int page, int num) {
        List<Member> byPosition = memberService.findByPosition(position, page, num);
        return byPosition;
    }

    @RequestMapping("findbypositionnum")
    @ResponseBody
    public int findByPositionNum(String position) {
        int byPositionNum = memberService.findByPositionNum(position);
        return byPositionNum;
    }

    @RequestMapping("findByDepartmentAndId")
    @ResponseBody
    public Member findByDepartmentAndId(String department, String id) {
        return memberService.findByDepartmentAndId(department, id);
    }

    @RequestMapping("findByDepartmentAndName")
    @ResponseBody
    public List<Member> findByDepartmentAndName(String department, String name, int startPage, int num) {
        return memberService.findByDepartmentAndName(department, name, startPage, num);
    }

    @RequestMapping("findByDepartmentAndNameNum")
    @ResponseBody
    public String findByDepartmentAndNameNum(String department, String name) {
        int i = memberService.findByDepartmentAndNameNum(department, name);
        return Integer.toString(i);
    }

    @RequestMapping("insertdata")
    public String insertData(Member member, HttpServletRequest request) {
        int i = memberService.insertData(member);
        UnicodeUtil util = new UnicodeUtil();
        String str = util.gbEncoding(member.getDepartment());//????????????unicode??????
        str = str.replace('\\', '_'); //url????????????????????? ????????????
        if (i != 0) {
            AdminUser a = (AdminUser) request.getSession().getAttribute("administer");
            logService.insertNew("??????", "???????????????", a.getName(), "?????????" + member.getId(), member.getDepartment() + "?????????", "2019");
            return "redirect:/loginp_1.html?name=" + str;
        } else return "redirect:/departments.html";
    }

    @RequestMapping("updatedata")
    public String updateData(Member member,HttpServletRequest request){
        int i = memberService.updateData(member);
        UnicodeUtil util = new UnicodeUtil();
        String str =util.gbEncoding(member.getDepartment());//????????????unicode??????
        str =str.replace('\\','_'); //url????????????????????? ????????????
        if (i!=0){
            AdminUser a =(AdminUser) request.getSession().getAttribute("administer");
            logService.insertNew("??????","???????????????",a.getName(),"?????????"+member.getId(),member.getDepartment()+"?????????","2019");
            return "redirect:/loginp_1.html?name="+str;
        }else return "redirect:/departments.html";
    }

    @RequestMapping("deletedata")
    @ResponseBody
    public Map<String, Object> deleteData(String id, HttpServletRequest request) {
        int i = memberService.deleteData(id);
        Map<String, Object> map = new HashMap<>();
        if (i != 0) {
            AdminUser a = (AdminUser) request.getSession().getAttribute("administer");
            logService.insertNew("??????", "???????????????", a.getName(), "?????????" + id, "???????????????","2019");
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
    public String ExcleStudent(HttpServletRequest request, String name) throws NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException, NameNullException {
        int i = memberService.findByDepartmentNum(name);
        CreateExlceUtil<Member> createExlceUtil = new CreateExlceUtil<>(request, Member.class, "???????????????");
        List<Member> list = memberService.findByDepartment(name, 1, i);
        return createExlceUtil.createExcle(list);
    }

    @PostMapping("upfile")
    @ResponseBody
    public String upfile(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
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
                i = memberService.BatchAddition(path);
                dest.delete();
                AdminUser a =(AdminUser) request.getSession().getAttribute("administer");
                logService.insertNew("??????","??????????????????",a.getName(),"??????","???????????????","2019");
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
