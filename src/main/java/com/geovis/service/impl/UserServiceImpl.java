package com.geovis.service.impl;

import com.alibaba.fastjson.JSON;
import com.geovis.Enum.EnumCode;
import com.geovis.entity.LoginLog;
import com.geovis.entity.User;
import com.geovis.mapper.UserMapper;
import com.geovis.service.LoginLogService;
import com.geovis.service.UserRoleService;
import com.geovis.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.geovis.utils.ResultUtil;
import com.xiaoleilu.hutool.crypto.SecureUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhouxian
 * @since 2018-12-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private LoginLogService loginLogService;


    @Override
    public Object login(String name, String pass, HttpSession session, HttpServletRequest request) {
        UsernamePasswordToken upToken = new UsernamePasswordToken(name, SecureUtil.md5(pass));
        Subject subject = SecurityUtils.getSubject();
        subject.login(upToken);
        User userInfoDto = (User) subject.getPrincipal();
        session.setAttribute("user", userInfoDto);

        // 登录日志
        LoginLog loginLog = new LoginLog();
        loginLog.setUid(userInfoDto.getId().toString());
        loginLog.setLoginTime(new Date());
        loginLog.setLoginIP(request.getRemoteAddr());
        loginLog.setLoginTotal(loginLogService.findMaxLoginTatalByUserId(userInfoDto.getId().toString())); // 登录总次数
        loginLogService.insert(loginLog);

//        // 一级 模块
//        List<RolePermisDto> parentList = rolePermissionService.findRolesPermisByFatherId(null, null);
//        List<RolePermisDto> sonList = null;
//        List<RolePermisDto> sonssonList = null;
//        String rid = userInfoDto.getRoleName().equals("admin") ? null : userInfoDto.getRoleid();
//        for (int i = 0, j = parentList.size(); i < j; i++) {
//
//            List<RolePermisDto> trueChildrenList = new ArrayList<>();
//
//            // 二级 页面
//            sonList = rolePermissionService.findRolesPermisByFatherId(parentList.get(i).getId(), null);
//            for (int k = 0, l = sonList.size(); k < l; k++) {
//
//                // 三级按钮
//                sonssonList = rolePermissionService.findRolesPermisByFatherId(sonList.get(k).getId(), rid);
//                // 如果按钮级拥有权限说明页面也有权限
//                if (!sonssonList.isEmpty() && sonssonList.size() > 0) {
//                    trueChildrenList.add(sonList.get(k));
//                }
//            }
//            parentList.get(i).setChildren((ArrayList<RolePermisDto>) trueChildrenList);
//        }
//        userInfoDto.setRolePermis((ArrayList) parentList);
        return ResultUtil.result(EnumCode.OK.getValue(), "登陆成功", JSON.toJSON(userInfoDto));

    }
}
