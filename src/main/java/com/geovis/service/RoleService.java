package com.geovis.service;

import com.geovis.entity.Role;
import com.baomidou.mybatisplus.service.IService;

import java.util.Set;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zhouxian
 * @since 2018-12-24
 */
public interface RoleService extends IService<Role> {

    /**
     * 根据用户ID查询角色集
     *
     * @param id
     * @author zhouxian
     * @since 2018-12-26
     */

    Set<String> findRoleNameByUserId(String id);

}
