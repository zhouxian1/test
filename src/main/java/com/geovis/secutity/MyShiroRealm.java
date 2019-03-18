package com.geovis.secutity;

import com.geovis.entity.User;
import com.geovis.service.RoleService;
import com.geovis.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class MyShiroRealm extends AuthorizingRealm {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

    //如果项目中用到了事物，@Autowired注解会使事物失效，可以自己用get方法获取值
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private String SHIRO_LOGIN_COUNT = "SHIRO_LOGIN_COUNT";
    private String SHIRO_IS_LOCK = "SHIRO_IS_LOCK";

    /**
     * 认证信息.(身份验证) : Authentication 是用来验证用户身份
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        logger.info("---------------- 执行 Shiro 凭证认证 ----------------------");
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String name = token.getUsername();
        String password = String.valueOf(token.getPassword());
        User user = new User();
        user.setUserName(name);
        user.setPassWord(password);
        // 从数据库获取对应用户名密码的用户
        User userList = userService.getUser(user);
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        if (userList == null) {
            //访问一次，计数一次
            opsForValue.increment(SHIRO_LOGIN_COUNT + name, 1);
            //计数大于5时，设置用户被锁定一小时
            if (Integer.parseInt((String) opsForValue.get(SHIRO_LOGIN_COUNT + name)) >= 5) {
                opsForValue.set(SHIRO_IS_LOCK + name, "LOCK");
                redisTemplate.expire(SHIRO_IS_LOCK + name, 1, TimeUnit.HOURS);
                user.setUserStatus(1);
                userService.updateStatusByName(user);
            }
            if ("LOCK".equals((String) opsForValue.get(SHIRO_IS_LOCK + name))) {
                throw new DisabledAccountException("由于密码输入错误次数大于5次，帐号已经禁止登录！");
            }
            throw new UnknownAccountException();
        } else {
            long s = redisTemplate.getExpire("SHIRO_IS_LOCK" + name);
            if (s<= 0) {
                // 用户为禁用状态
                if (userList.getUserEnable() != 1) {
                    throw new DisabledAccountException();
                }
                logger.info("---------------- Shiro 凭证认证成功 ----------------------");
                //清空登录计数
                opsForValue.set(SHIRO_LOGIN_COUNT + name, "0");
                user.setUserStatus(0);
                userService.updateStatusByName(user);
                SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                        userList, //用户
                        userList.getPassWord(), //密码
                        getName()  //realm name
                );
                return authenticationInfo;
            }
            throw new DisabledAccountException("由于密码输入错误次数大于5次，帐号已经禁止登录！");
        }

    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("---------------- 执行 Shiro 权限获取 ---------------------");
        Object principal = principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        if (principal instanceof User) {
            User userLogin = (User) principal;
            Set<String> roles = roleService.findRoleNameByUserId(userLogin.getId().toString());
            authorizationInfo.addRoles(roles);

//            Set<String> permissions = userService.findPermissionsByUserId(userLogin.getId().toString());
//            authorizationInfo.addStringPermissions(permissions);
        }
        logger.info("---- 获取到以下权限 ----");
        logger.info(authorizationInfo.getStringPermissions().toString());
        logger.info("---------------- Shiro 权限获取成功 ----------------------");
        return authorizationInfo;
    }

}
