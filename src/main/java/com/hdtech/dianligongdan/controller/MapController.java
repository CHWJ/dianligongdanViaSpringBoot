package com.hdtech.dianligongdan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/map")
public class MapController extends BaseController {
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView view = new ModelAndView();

        view.addObject("roleName","");
        view.addObject("userName","root");
        view.setViewName("map/index");
        return view;
    }
}
