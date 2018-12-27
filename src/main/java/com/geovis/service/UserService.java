package com.geovis.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.geovis.entity.ParamsDto;
import com.geovis.entity.User;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouxian
 * @since 2018-12-24
 */
public interface UserService extends IService<User> {


    /**
     * 登录
     *
     * @param name
     * @param pass
     * @param session
     * @param request
     * @return
     */
    Object login(String name, String pass, HttpSession session, HttpServletRequest request);

    /**
     * 验证用户
     *
     * @param user
     * @author zhouxian
     * @since  2018-12-16
     *
     * */
    User getUser(User user);

    /**
     * 根据用户ID查询
     *
     * @param  id
     *
     * @author  zhouxian
     *
     * @since 2018-12-16
     *
     * */
    Set<String> findPermissionsByUserId(String id);

    /**
     * 更新账户状态
     * @param user
     * @author  zhouxian
     * @since 2018-12-27
     *
     * */
    Integer updateStatusByName (@Param("user") User user);
}
