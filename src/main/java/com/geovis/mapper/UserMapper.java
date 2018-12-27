package com.geovis.mapper;

import com.geovis.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

}