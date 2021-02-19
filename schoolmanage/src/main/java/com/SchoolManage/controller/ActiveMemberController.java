package com.SchoolManage.controller;

import com.SchoolManage.exception.NameNullException;
import com.SchoolManage.pojo.*;
import com.SchoolManage.service.ActiveMemberService;
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
 * @Date 2021/2/19 9:36
 * @Description TODO
 * @Version 1.0
 */
@Controller
@RequestMapping("activemember")
public class ActiveMemberController {
    @Autowired
    private ActiveMemberService activeMemberService;

    @RequestMapping("findall")
    @ResponseBody
    public List<Activemember> findAll(Integer Page, Integer num) {
        return activeMemberService.findAll(Page, num);
    }

    @RequestMapping("findallcount")
    @ResponseBody
    public int findAllCount() {
        return activeMemberService.findAllCount();
    }

    @RequestMapping("findbyactive")
    @ResponseBody
    public List<Activemember> findByActive(Integer id, Integer Page, Integer num) {
        return activeMemberService.findByActive(id, Page, num);
    }

    @RequestMapping("findbyactivecount")
    @ResponseBody
    public int findByActiveCount(Integer id) {
        return activeMemberService.findByActiveCount(id);
    }

    @RequestMapping("findbyclazz")
    @ResponseBody
    public List<Activemember> findByClazz(String clazz, Integer Page, Integer num) {
        return activeMemberService.findByClazz(clazz, Page, num);
    }

    @RequestMapping("findbyclazzcount")
    @ResponseBody
    public int findByClazzCount(String clazz) {
        return activeMemberService.findByClazzCount(clazz);
    }

    @RequestMapping("findbyactiveandclazz")
    @ResponseBody
    public List<Activemember> findByActiveAndClazz(Integer id, String clazz, Integer Page, Integer num) {
        return activeMemberService.findByActiveAndClazz(id, clazz, Page, num);
    }

    @RequestMapping("findbyactiveandclazzcount")
    @ResponseBody
    public int findByActiveAndClazzCount(Integer id, String clazz) {
        return activeMemberService.findByActiveAndClazzCount(id, clazz);
    }

    @RequestMapping("insertdata")
    public String insertData(Activemember activemember) {
        System.out.println(activemember);
        int i = activeMemberService.insertData(activemember);
        if (i!=0){
            return "redirect:/loginp_4.html?id="+activemember.getActivity();
        }else return "redirect:/activity.html";
    }

    @RequestMapping("deletedata")
    @ResponseBody
    public Map<String, Object> deleteData(int id) {
        int i = activeMemberService.deleteData(id);
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
    @RequestMapping(value = "Excle",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String ExcleStudent(HttpServletRequest request,Integer id) throws NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException, NameNullException {
        int i=activeMemberService.findByActiveCount(id);
        CreateExlceUtil<Activemember> createExlceUtil = new CreateExlceUtil<>(request,Activemember.class,"活动成员表");
        List<Activemember> list =activeMemberService.findByActive(id,1,i);
        return createExlceUtil.createExcle(list);
    }
    @RequestMapping("findbystudent")
    @ResponseBody
    public Activemember findByStudent(String student,Integer activity) {
        return activeMemberService.findByStudent(student,activity);
    }
    @RequestMapping("findbyname")
    @ResponseBody
    public List<Activemember> findByName(String name,Integer activity, int page, int num) {
       return activeMemberService.findByName(name,activity,page,num);
    }

    @RequestMapping("findByNameCount")
    @ResponseBody
    public String findByNameCount(String name,Integer activity) {

        int i = activeMemberService.findByNameCount(name,activity);
        return Integer.toString(i);
    }
    @RequestMapping("updatedata")
    public String updateData(Activemember activemember){
        int i = activeMemberService.updateDara(activemember);

        if (i!=0){
            return "redirect:/loginp_4.html?id="+activemember.getActivity();
        }else return "redirect:/activity.html";
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
                i=activeMemberService.BatchAddition(path);
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
