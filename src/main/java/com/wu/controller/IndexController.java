package com.wu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by MJN on 2017/3/21.
 */
@Controller
@RequestMapping("/index")
public class IndexController extends BaseController {

    @RequestMapping("/index")
    public Object index(){
        return new ModelAndView("index");
    }
}
