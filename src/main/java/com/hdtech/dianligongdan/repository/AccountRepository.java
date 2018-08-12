package com.hdtech.dianligongdan.repository;

import com.hdtech.dianligongdan.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    Account findByUsernameAndPassword(String name,String pwd);
    List<Account> findByIdIn(List<Integer> ids);
}
