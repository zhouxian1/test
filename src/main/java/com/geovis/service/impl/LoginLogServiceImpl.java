package com.geovis.service.impl;

import com.geovis.entity.LoginLog;
import com.geovis.mapper.LoginLogMapper;
import com.geovis.service.LoginLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhouxian
 * @since 2018-12-24
 */
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService {

    @Autowired
    private  LoginLogMapper loginLogMapper;

    @Override
    public Integer findMaxLoginTatalByUserId(String id) {

        return this.loginLogMapper.findMaxLoginTatalByUserId(id);
    }
}
