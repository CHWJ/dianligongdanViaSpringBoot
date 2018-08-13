package com.hdtech.dianligongdan.service;

import com.hdtech.dianligongdan.utils.easyUiAdapter.PageResult;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseService<T> {
    protected PageResult<T> toPageResult(Page<T> data){
        PageResult<T> result = new PageResult<>();
        if(data!=null){
            result.setRows(data.getContent());
            result.setTotal(data.getTotalElements());
        }
        return result;
    }
    <R> PageResult toPageResult(List<R> collection, Long total){
        return new PageResult<>(total,collection);
    }
}
