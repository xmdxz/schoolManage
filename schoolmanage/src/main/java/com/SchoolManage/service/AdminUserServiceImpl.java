package com.SchoolManage.service;

import com.SchoolManage.dao.AdminUserDao;
import com.SchoolManage.pojo.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author RainGoal
 * @Date 2021/1/26 22:14
 * @Description TODO
 * @Version 1.0
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private AdminUserDao adminUserDao;

    @Override
    public int addAdminUser(AdminUser adminUser) {
        return adminUserDao.addAdminUser(adminUser);
    }

    @Override
    public int deleteAdminUser(int id) {
        return adminUserDao.deleteAdminUser(id);
    }

    @Override
    public List<AdminUser> findAll() {
        return adminUserDao.findAll();
    }

    @Override
    public AdminUser getAdminUser(String username) {
        return adminUserDao.getAdminUser(username);
    }

    @Override
    public int updateAdminUser(AdminUser adminUser) {
        return adminUserDao.updateAdminUser(adminUser);
    }

    @Override
    public List<AdminUser> findByName(String name) {
        return adminUserDao.findByName(name);
    }
}
