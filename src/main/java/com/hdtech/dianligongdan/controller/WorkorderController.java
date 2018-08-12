package com.hdtech.dianligongdan.controller;

import com.hdtech.dianligongdan.domain.entity.Workorder;
import com.hdtech.dianligongdan.service.WorkorderService;
import com.hdtech.dianligongdan.utils.easyUiAdapter.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/workorder")
public class WorkorderController extends BaseController<Workorder> {
    @Autowired
    private WorkorderService workorderService;

    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView view = new ModelAndView();
        view.setViewName("workorder/index");
        return view;
    }

    @PostMapping("/findByPage")
    public PageResult<Workorder> findByPage(@RequestParam(required=false)Workorder wo,
                                          @RequestParam(required=false) Integer pageNum,
                                          @RequestParam(required=false) Integer pageSize ){
        if(pageNum == null){
            pageNum = 0;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        PageResult<Workorder> list = workorderService.findByPage(wo, pageNum, pageSize);
        return list;
    }
}
