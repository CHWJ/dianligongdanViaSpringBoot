package com.hdtech.dianligongdan.controller;

import com.hdtech.dianligongdan.utils.easyUiAdapter.PageResult;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController<T> {
    protected PageResult<T> toPageResult(Page<T> data){
        PageResult<T> result = new PageResult<>();
        if(data!=null){
            result.setRows(data.getContent());
            result.setTotal(data.getTotalElements());
        }
        return result;
    }
}
