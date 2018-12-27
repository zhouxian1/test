package com.geovis.service.impl;

import com.geovis.entity.Role;
import com.geovis.mapper.RoleMapper;
import com.geovis.service.RoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhouxian
 * @since 2018-12-24
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private  RoleMapper roleMapper;

    @Override
    public Set<String> findRoleNameByUserId(String id) {
        return this.roleMapper.findRoleNameByUserId(id);
    }
}
