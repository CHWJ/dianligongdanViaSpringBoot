package com.hdtech.dianligongdan.service;

import com.hdtech.dianligongdan.domain.entity.*;
import com.hdtech.dianligongdan.repository.AccountRepository;
import com.hdtech.dianligongdan.repository.ImportRepository;
import com.hdtech.dianligongdan.repository.WorkorderRepository;
import com.hdtech.dianligongdan.repository.WorkorderUserRepository;
import com.hdtech.dianligongdan.utils.JsonHelper;
import com.hdtech.dianligongdan.utils.easyUiAdapter.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class WorkorderService extends BaseService<Workorder> {
    @Autowired
    private WorkorderRepository workorderRepository;
    @Autowired
    private WorkorderUserRepository workorderUserRepository;
    @Autowired
    private ImportRepository importRepository;
    @Autowired
    private AccountRepository accountRepository;


    public PageResult<Workorder> findByPage(Workorder wo, Integer pageNum, Integer pageSize) {
        Pageable pageable = new PageRequest(pageNum, pageSize, new Sort(Sort.Direction.DESC, "id"));
        Specification<Workorder> spec = new Specification<Workorder>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<Workorder> root, CriteriaQuery<?> crite, CriteriaBuilder cb) {
                List<Predicate> pr = new ArrayList<>();
                if (wo != null && wo.getOrderNo() != null) {
                    pr.add(cb.like(root.get("name").as(String.class), "%" + wo.getOrderNo() + "%"));
                }
                return cb.and(pr.toArray(new Predicate[pr.size()]));
            }
        };

        Page<Workorder> result = workorderRepository.findAll(spec, pageable);

        // 扩展属性
        List<Workorder> list = result.getContent();
        if (list != null && list.size() > 0) {
            List<Integer> importIds = list.stream().map(Workorder::getImportId).distinct().collect(toList());
            List<Import> importList = importRepository.findByIdIn(importIds);
            List<Integer> sendIds = list.stream().map(Workorder::getSendId).distinct().collect(toList());
            List<Account> sendList = accountRepository.findByIdIn(sendIds);
            List<Integer> workorderIds = list.stream().map(Workorder::getId).distinct().collect(toList());
            List<WorkorderUserDto> workorderUserList = workorderUserRepository.findByWorkorderIds(workorderIds);

            for (Workorder item : list) {
                importList.stream().filter(x -> x.getId() == item.getImportId()).findFirst().ifPresent(temp -> item.setImportName(temp.getName()));
                sendList.stream().filter(x -> x.getId() == item.getSendId()).findFirst().ifPresent(temp -> item.setSendName(temp.getName()));
                workorderUserList.stream().filter(x -> x.getWorkorderId() == item.getId()).findFirst().ifPresent(temp -> item.setWorkorderUserName(temp.getManagerName()));
                workorderUserList.stream().filter(x -> x.getWorkorderId() == item.getId()).findFirst().ifPresent(temp -> item.setWorkorderUserPhonenum(temp.getPhoneNum()));
            }

            return toPageResult(list, result.getTotalElements());
        }

        return toPageResult(list, result.getTotalElements());
    }
}
