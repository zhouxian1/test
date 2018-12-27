package com.geovis.service;

import com.geovis.entity.LoginLog;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouxian
 * @since 2018-12-24
 */

public interface LoginLogService extends IService<LoginLog> {

    /**
     * 查询登录次数
     *
     * @param id
     * @return
     */
    Integer findMaxLoginTatalByUserId(String id);


	
}
