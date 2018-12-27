package com.geovis.mapper;

import com.geovis.entity.UserRole;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

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
public interface UserRoleMapper extends BaseMapper<UserRole> {

}