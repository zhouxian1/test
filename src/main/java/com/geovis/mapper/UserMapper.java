package com.geovis.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.geovis.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.geovis.pojo.dto.ParamsDto;
import com.geovis.pojo.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
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
public interface UserMapper extends BaseMapper<User> {


    /**
     * 验证用户
     *
     * @param user
     * @author zhouxian
     * @since  2018-12-16
     *
     * */
    User getUser(User user);

    /**
     * 根据用户ID查询
     *
     * @param  id
     *
     * @author  zhouxian
     *
     * @since 2018-12-16
     *
     * */
    Set<String> findPermissionsByUserId(String id);

    /**
     * 更新账户状态
     *
     * @param user
     * @author zhouxian
     * @since 2018-12-27
     */
    Integer updateStatusByName(@Param("user") User user);

    /**
     * @desc: 查询用户
     *
     * @param dto 参数dto
     * @author: zhouxian
     * @date: 2018-12-29
     */
    List<UserDto> findUserByPage(Page<UserDto> page, ParamsDto dto);

}