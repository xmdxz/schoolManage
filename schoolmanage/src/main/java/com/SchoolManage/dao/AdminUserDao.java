package com.SchoolManage.dao;

import com.SchoolManage.pojo.AdminUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author RainGoal
 * @Date 2021/1/26 16:50
 * @Description TODO
 * @Version 1.0
 */
@Mapper
@Repository
public interface AdminUserDao {
    /**
     * @Description: 添加管理员用户
     * @Param: [adminUser]
     * @return: int
     * @Author: RainGoal
     * @Date: 2021/1/26
     */
    int addAdminUser(@Param(value = "adminUser") AdminUser adminUser);

    /**
     * @Description: 根据id删除管理员用户
     * @Param: [id]
     * @return: int
     * @Author: RainGoal
     * @Date: 2021/1/26
     */
    int deleteAdminUser(@Param(value = "id") int id);

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
    AdminUser getAdminUser(@Param(value = "username") String username);

    /**
     * @Description: 更改管理员账户信息
     * @Param: [adminUser]
     * @return: int
     * @Author: RainGoal
     * @Date: 2021/1/26
     */
    int updateAdminUser(@Param(value = "adminUser") AdminUser adminUser);

    /**
     * @Description: 根据姓名模糊查询
     * @Param: [name]
     * @return: java.util.List<com.SchoolManage.pojo.AdminUser>
     * @Author: RainGoal
     * @Date: 2021/1/26
     */
    List<AdminUser> findByName(@Param(value = "name") String name);

    /**
     * @Author RainGoal
     * @Description 更改密码
     * @Param [username, password]
     * @Return int
     * @Date 2021/2/23
     */
    int updatePassword(String username, String password);
}
