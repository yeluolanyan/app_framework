package com.wu.controller;

import com.wu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by MJN on 2017/3/21.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private UserMapper userMapper ;
    @RequestMapping("/userInfo")
    @ResponseBody
    public Object userInfo(int userId){
        return userMapper.selectByPrimaryKey(userId);
    }
}
