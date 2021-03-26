package com.SchoolManage.controller;

import com.SchoolManage.exception.NameNullException;
import com.SchoolManage.pojo.AdminUser;
import com.SchoolManage.pojo.Member;
import com.SchoolManage.pojo.TalkMember;
import com.SchoolManage.pojo.TalkType;
import com.SchoolManage.service.TalkMemberService;
import com.SchoolManage.util.CreateExlceUtil;
import com.SchoolManage.util.ExcleTemplate;
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
 * @Description DOTO
 * @Date 2021/3/24
 * @Version 1.0
 */
@Controller
@RequestMapping("talkmember")
public class TalkMemberController {
    @Autowired
    private TalkMemberService talkMemberService;

    @RequestMapping("findall")
    @ResponseBody
    public List<TalkMember> findAll(String type, Integer Page, Integer num) {
        return talkMemberService.findAll(type, Page, num);
    }

    @RequestMapping("findallcount")
    @ResponseBody
    public int findAllCount(String type) {
        return talkMemberService.findAllCount(type);
    }

    @RequestMapping("findbyid")
    @ResponseBody
    public TalkMember findById(Integer id) {
        return talkMemberService.findById(id);
    }

    @RequestMapping("findbycodeandtype")
    @ResponseBody
    public List<TalkMember> findByCodeAndType(String type, String code, String comy,Integer Page, Integer num) {
        return talkMemberService.findByCodeAndType(type, code,comy, Page, num);
    }

    @RequestMapping("findbycodeandtypecount")
    @ResponseBody
    public int findByCodeAndTypeCount(String type, String code,String comy) {
        return talkMemberService.findByCodeAndTypeCount(type,code,comy);
    }

    @RequestMapping("findbycode")
    @ResponseBody
    public List<TalkMember> findByCode(String code,Integer Page, Integer num) {
        return talkMemberService.findByCode(code, Page, num);
    }

    @RequestMapping("findbycodecount")
    @ResponseBody
    public int findByCodeCount(String code) {
        return talkMemberService.findByCodeCount(code);
    }

    @RequestMapping("findbyname")
    @ResponseBody
    public List<TalkMember> findByName(String type, String name,String comy, Integer Page, Integer num) {
        return talkMemberService.findByName(type, name,comy, Page, num);
    }
    @RequestMapping("findbytype")
    @ResponseBody
    public List<TalkMember> findByType(String type, String comy, Integer Page, Integer num) {
        return talkMemberService.findBytype(type, comy, Page, num);
    }
    @RequestMapping("findbytypecount")
    @ResponseBody
    public int findByTypeCount(String type, String comy) {
        return talkMemberService.findBytypeCount(type, comy);
    }
    @RequestMapping(value = "Excle", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String ExcleStudent(HttpServletRequest request, String type,String comy) throws NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException, NameNullException {
        int i = talkMemberService.findBytypeCount(type,comy);
        CreateExlceUtil<TalkMember> createExlceUtil = new CreateExlceUtil<>(request, TalkMember.class, "谈话成员表");
        List<TalkMember> list = talkMemberService.findBytype(type, comy,1, i);
        return createExlceUtil.createExcle(list);
    }
    @RequestMapping("findbynamecount")
    @ResponseBody
    public int findByNameCount(String type, String name,String comy) {
        return talkMemberService.findByNameCount(type, name,comy);
    }

    @RequestMapping("updatedata")
    public String updateData(TalkMember talkMember) {
        int i = talkMemberService.updateData(talkMember);
        UnicodeUtil util = new UnicodeUtil();
        String str = util.gbEncoding(talkMember.getType());//中文换为unicode编码

        str = str.replace('\\', '_'); //url中不允许出现、 所以转换

        if (i != 0) {
            return "redirect:/loginp_9.html?type=" + str;
        } else return "redirect:/psychology.html";
    }

    @RequestMapping("insertdata")
    public String insertData(TalkMember talkMember) {
        int i = talkMemberService.insertData(talkMember);
        UnicodeUtil util = new UnicodeUtil();
        String str = util.gbEncoding(talkMember.getType());//中文换为unicode编码
        str = str.replace('\\', '_'); //url中不允许出现、 所以转换
        if (i != 0) {
            System.out.println(str);
            return "redirect:/loginp_9.html?type=" +str;
        } else return "redirect:/psychology.html";
    }
    @RequestMapping(value = "Excle2", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String ExcleStudent2(HttpServletRequest request) throws NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException, NameNullException {
        TalkMember talkMember = new TalkMember(1,"xxx","xxx","xxx","xxx","xxx","xxx","xxx","xxx","xxx","xxx");
        return ExcleTemplate.getTemplate(request, talkMember, "谈话成员表模板");

    }
    @RequestMapping("deletedata")
    @ResponseBody
    public Map<String, Object> deleteData(int id) {
        int i = talkMemberService.deleteData(id);
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
    public String upfile(HttpServletRequest request,String type, String comy, @RequestParam("file") MultipartFile file) {
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
                i = talkMemberService.BatchAddition(path,type,comy);
                dest.delete();
                AdminUser a = (AdminUser) request.getSession().getAttribute("administer");
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
}
