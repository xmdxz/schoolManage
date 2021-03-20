package com.SchoolManage.controller;

import com.SchoolManage.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author RainGoal
 * @Description DOTO
 * @Date 2021/3/6
 * @Version 1.0
 */
@Controller
@RequestMapping("upload")
public class UtilController {
    @Autowired
    private StudentService studentService;
    //上传的图片路径 测试的时候记得改成自己电脑的路径，部署要更改linux的路径
    private String filePath = "C:\\Users\\QYZ\\Desktop\\image";

    @PostMapping("uploadimg")
    @ResponseBody
    public Map<String, Object> uploadImg(HttpServletRequest request,
                                         @RequestParam("file") MultipartFile file,
                                         @RequestParam("id") String id,
                                         @RequestParam("name") String name) throws Exception {
        //通过一个map返回信息
        HashMap<String, Object> map = new HashMap<>();

        //接收到id学号和姓名对比
        String name_real = studentService.findById(id).getName();
        if (!name.equals(name_real)) {
            map.put("msg", "抱歉，您不是学生本人，因为你的学号与姓名不匹配");
            map.put("code", 500);
            return map;
        }

        //判断如果文件不为空
        if (!file.isEmpty()) {
            String originFileName = file.getOriginalFilename();
            String substring = originFileName.substring(originFileName.indexOf("."));
            //开始判断文件格式是否是图片格式
            if (!(substring.equals(".jpg") || substring.equals(".JPG") ||
                    substring.equals(".png") || substring.equals(".PNG"))) {
                map.put("msg", "抱歉，请上传正确的图片文件");
                map.put("code", 500);
                return map;
            }

            //判断文件夹是否存在
            File file_ = new File(filePath);
            if (!file_.exists()) {
                file_.mkdirs();
            }

            //开始将上传的文件写入到指定磁盘
            String path = filePath + "/" + id + substring;
            System.out.println(path);
            file.transferTo(new File(path));
            map.put("msg", "success");
            map.put("code", 200);
            return map;
        } else {
            map.put("msg", "抱歉，文件为空，请重新上传");
            map.put("code", 500);
            return map;
        }


    }
}
