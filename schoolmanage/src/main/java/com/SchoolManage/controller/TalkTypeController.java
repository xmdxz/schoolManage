package com.SchoolManage.controller;

import com.SchoolManage.pojo.TalkType;
import com.SchoolManage.service.TalkTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        return talkTypeService.findAll(comy, (Page - 1) * num, num);
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
        return talkTypeService.findByType(comy, type, (Page - 1) * num, num);
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
            return "redirect:成功地址";
        } else return "redirect:失败地址";
    }

    @RequestMapping("insertdata")
    public String insertData(TalkType talkType) {
        int i = talkTypeService.insertData(talkType);
        if (i != 0) {
            return "redirect:成功地址";
        } else return "redirect:失败地址";
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

  
}
