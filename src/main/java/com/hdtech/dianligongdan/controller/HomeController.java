package com.hdtech.dianligongdan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/home")
public class HomeController extends BaseController {
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView view = new ModelAndView();
        // todo 验证用户是否登录
        // todo 获取用户账号信息
        view.addObject("roleName","超级管理员");
        view.addObject("userName","root");
        view.setViewName("home/index");
        return view;
    }
}
