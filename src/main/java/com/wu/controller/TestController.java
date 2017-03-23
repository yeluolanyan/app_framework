package com.wu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by MJN on 2017/3/21.
 */
@Controller
@RequestMapping("/test")
public class TestController extends BaseController {

    @RequestMapping("/test")
    @ResponseBody
    public Object test(){
        return "SUCCESS";
    }
}
