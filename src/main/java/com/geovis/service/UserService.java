package com.geovis.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.geovis.entity.User;
import com.baomidou.mybatisplus.service.IService;
import com.geovis.pojo.dto.ParamsDto;
import com.geovis.pojo.dto.UserDto;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 服务类
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
     * @since 2018-12-16
     */
    User getUser(User user);

    /**
     * 根据用户ID查询
     *
     * @param id
     * @author zhouxian
     * @since 2018-12-16
     */
    Set<String> findPermissionsByUserId(String id);

    /**
     * 更新账户状态
     *
     * @param user
     * @author zhouxian
     * @since 2018-12-27
     */
    Integer updateStatusByName(@Param("user") User user);

    /**
     * @desc: 查询用户
     *
     * @param dto 参数dto
     * @author: zhouxian
     * @date: 2018-12-29
     */
    List<UserDto> findUserByPage(Page<UserDto> page, ParamsDto dto);
}
