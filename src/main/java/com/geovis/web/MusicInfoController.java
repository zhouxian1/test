package com.geovis.web;

import com.geovis.entity.User;
import com.geovis.service.UserService;
import com.geovis.utils.RequestUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;


@Controller
@RequestMapping(value = "/music")
public class MusicInfoController {

}
