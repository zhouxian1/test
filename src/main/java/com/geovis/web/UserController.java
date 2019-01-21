package com.geovis.web;


import com.baomidou.mybatisplus.plugins.Page;
import com.geovis.Enum.EnumCode;
import com.geovis.Enum.EnumRoleType;
import com.geovis.entity.User;
import com.geovis.pojo.dto.ParamsDto;
import com.geovis.pojo.dto.UserDto;
import com.geovis.service.UserService;
import com.geovis.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhouxian
 * @since 2018-12-24
 */
@Controller
@RequestMapping("/user/v1")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @desc: 查询用户
     *
     * @param dto 参数dto
     * @author: jwy
     * @date: 2017/12/19
     */
    @RequestMapping(value = "/findUserByPage",method = RequestMethod.GET)
    public Object findUserByPage(ParamsDto dto) {
        Page<UserDto> page = new Page<>(dto.getStartPage(),dto.getPageSize());
        dto.setType(EnumRoleType.USER.getValue());
        List<UserDto> list = userService.findUserByPage(page,dto);
        return ResultUtil.result(EnumCode.OK.getValue(), "请求成功", list, page.getTotal());
}
	
}
