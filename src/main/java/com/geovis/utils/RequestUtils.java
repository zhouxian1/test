package com.geovis.utils;

import com.geovis.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestUtils {

    private static Logger logger = LoggerFactory.getLogger(RequestUtils.class);

    /**
     * 获取当前登录的用户，若用户未登录，则返回未登录 json
     *
     * @return
     */
    public static User currentLoginUser() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            Object principal = subject.getPrincipals().getPrimaryPrincipal();
            if (principal instanceof User) {
                return (User) principal;
            }
        }
        return null;
    }
}
