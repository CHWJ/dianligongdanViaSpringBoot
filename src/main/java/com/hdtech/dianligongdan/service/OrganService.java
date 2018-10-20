package com.hdtech.dianligongdan.service;

import com.hdtech.dianligongdan.domain.entity.Organization;
import com.hdtech.dianligongdan.repository.AccountRepository;
import com.hdtech.dianligongdan.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganService extends BaseService<Organization> {
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private AccountRepository accountRepository;


    public List<Organization> findAll() {
        return organizationRepository.findAll();
    }
}
