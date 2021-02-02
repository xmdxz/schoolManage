package com.SchoolManage.service;

import com.SchoolManage.dao.FeaturesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author RainGoal
 * @Date 2021/2/2 19:06
 * @Description TODO
 * @Version 1.0
 */
@Service
public class FeaturesServiceImpl implements FeaturesService {

    @Autowired
    private FeaturesDao featuresDao;
    @Override
    public List<String> findDirectionByMajor(String major) {
        return featuresDao.findDirectionByMajor(major);
    }
}
