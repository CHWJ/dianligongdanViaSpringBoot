package com.hdtech.dianligongdan.controller;

import com.hdtech.dianligongdan.domain.entity.Workorder;
import com.hdtech.dianligongdan.service.WorkorderService;
import com.hdtech.dianligongdan.utils.easyUiAdapter.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/workorder")
public class WorkorderController extends BaseController<Workorder> {
    @Autowired
    private WorkorderService workorderService;

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        view.setViewName("workorder/index");
        return view;
    }

    @PostMapping("/findByPage")
    public PageResult<Workorder> findByPage(@RequestParam(required = false) Workorder wo,
                                            @RequestParam(required = false) Integer page,
                                            @RequestParam(required = false) Integer rows) {
        page = Integer.valueOf(page == null ? 0 : (page - 1));
        if (rows == null) rows = 10;
        PageResult<Workorder> list = workorderService.findByPage(wo, page, rows);
        return list;
    }
}
