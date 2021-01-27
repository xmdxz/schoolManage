package com.SchoolManage.service;

import com.SchoolManage.pojo.AdminUser;

import java.util.List;

/**
 * @Author RainGoal
 * @Date 2021/1/26 22:14
 * @Description TODO
 * @Version 1.0
 */

public interface AdminUserService {
    /**
     * @Description:  添加管理员用户
     * @Param: [adminUser]
     * @return: int
     * @Author: RainGoal
     * @Date: 2021/1/26
     */
    int addAdminUser(AdminUser adminUser);

    /**
     * @Description: 根据id删除管理员用户
     * @Param: [id]
     * @return: int
     * @Author: RainGoal
     * @Date: 2021/1/26
     */
    int deleteAdminUser(int id);

    /**
     * @Description: 查询所有的管理员用户
     * @Param: []
     * @return: java.util.List<com.SchoolManage.pojo.AdminUser>
     * @Author: RainGoal
     * @Date: 2021/1/26
     */
    List<AdminUser> findAll();

    /**
     * @Description: 根据账户得到密码
     * @Param: [username]
     * @return: java.lang.String
     * @Author: RainGoal
     * @Date: 2021/1/26
     */
    AdminUser getAdminUser(String username);

    /**
     * @Description: 更改管理员账户信息
     * @Param: [adminUser]
     * @return: int
     * @Author: RainGoal
     * @Date: 2021/1/26
     */
    int updateAdminUser(AdminUser adminUser);

    /**
     * @Description: 根据姓名模糊查询
     * @Param: [name]
     * @return: java.util.List<com.SchoolManage.pojo.AdminUser>
     * @Author: RainGoal
     * @Date: 2021/1/26
     */
    List<AdminUser> findByName(String name);
}
