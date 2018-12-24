package com.geovis.web;

import com.geovis.entity.User;
import com.geovis.mapper.UserMapper;
import com.geovis.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("api/v1/")
@Api("LoginController相关的api")
public class LoginController {

    @Autowired
    private  UserService userService;

    private static final Logger logger= LoggerFactory.getLogger(LoginController.class);

    @ApiOperation(value = "根据用户密码验证登陆", notes = "登陆验证")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object submitLogin(String username,String password, HttpSession session, HttpServletRequest request) {
        // 执行到这里说明用户已登录成功
        logger.info("开始验证登陆！");
        return userService.login(username,password,session,request);
    }
}
