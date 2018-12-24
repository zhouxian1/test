package com.geovis.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.geovis.entity.ParamsDto;
import com.geovis.entity.User;
import com.baomidou.mybatisplus.service.IService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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


}
