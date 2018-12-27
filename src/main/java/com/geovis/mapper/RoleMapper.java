package com.geovis.mapper;

import com.geovis.entity.Role;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zhouxian
 * @since 2018-12-24
 */
@Component
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据用户ID查询角色集
     *
     * @param  id
     *
     * @author zhouxian
     *
     * @since 2018-12-26
     * */

    Set<String> findRoleNameByUserId(String id);

}