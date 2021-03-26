package com.SchoolManage.controller;

import com.SchoolManage.exception.NameNullException;
import com.SchoolManage.pojo.AdminUser;
import com.SchoolManage.pojo.DepartMent;
import com.SchoolManage.pojo.Honour;
import com.SchoolManage.pojo.TalkType;
import com.SchoolManage.service.TalkTypeService;
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
 * @Description DOTO
 * @Date 2021/3/24
 * @Version 1.0
 */
@Controller
@RequestMapping("talktype")
public class TalkTypeController {
    @Autowired
    private TalkTypeService talkTypeService;

    @RequestMapping("gettype")
    @ResponseBody
    public List<String> getType() {
        return talkTypeService.getType();
    }

    @RequestMapping("findall")
    @ResponseBody
    public List<TalkType> findAll(String comy, Integer Page, Integer num) {
        return talkTypeService.findAll(comy, Page, num);
    }

    @RequestMapping("findallcount")
    @ResponseBody
    public int findAllCount(String comy) {
        return talkTypeService.findAllCount(comy);
    }

    @RequestMapping("findbyid")
    @ResponseBody
    public TalkType findById(Integer id) {
        return talkTypeService.findById(id);
    }

    @RequestMapping("findbytype")
    @ResponseBody
    public List<TalkType> findByType(String comy, String type, Integer Page, Integer num) {
        return talkTypeService.findByType(comy, type, Page, num);
    }

    @RequestMapping(value = "Excle2", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String ExcleStudent2(HttpServletRequest request) throws NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException, NameNullException {
        TalkType talkType = new TalkType(1,"xxx","xxx","xxx",0);
        return ExcleTemplate.getTemplate(request, talkType, "谈话表模板");

    }
    @RequestMapping("findbytypecount")
    @ResponseBody
    public int findByTypeCount(String comy, String type) {
        return talkTypeService.findByTypeCount(comy, type);
    }

    @RequestMapping("updatedata")
    public String updateData(TalkType talkType) {
        int i = talkTypeService.updateData(talkType);
        if (i != 0) {
            if (talkType.getComy().equals("2019"))
                return "loginp_8";
            else
                return "loginp_8-20";
        } else {
//            map.put("msg", "添加失败");
//            map.put("code", 500);
            if (talkType.getComy().equals("2019"))
                return "psychology";
            else
                return "psychology-20";
        }
    }

    @RequestMapping("insertdata")
    public String insertData(TalkType talkType) {
        int i = talkTypeService.insertData(talkType);
        if (i != 0) {
            if (talkType.getComy().equals("2019"))
                return "loginp_8";
            else
                return "loginp_8-20";
        } else {
//            map.put("msg", "添加失败");
//            map.put("code", 500);
            if (talkType.getComy().equals("2019"))
                return "psychology";
            else
                return "psychology-20";
        }
    }

    @RequestMapping("deletedata")
    @ResponseBody
    public Map<String, Object> deleteData(int id) {
        int i = talkTypeService.deleteData(id);
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
    @RequestMapping(value = "Excle", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String ExcleStudent(HttpServletRequest request,String comy) throws NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException, NameNullException {
        int i = talkTypeService.findAllCount(comy);
        CreateExlceUtil<TalkType> createExlceUtil = new CreateExlceUtil<>(request, TalkType.class, "谈话表");
        List<TalkType> list = talkTypeService.findAll(comy,1, i);
        return createExlceUtil.createExcle(list);
    }
    @PostMapping("upfile")
    @ResponseBody
    public String upfile(HttpServletRequest request,String comy, @RequestParam("file") MultipartFile file) {
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
                i = talkTypeService.BatchAddition(path,comy);
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
