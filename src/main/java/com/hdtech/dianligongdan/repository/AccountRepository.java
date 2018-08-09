package com.hdtech.dianligongdan.repository;

import com.hdtech.dianligongdan.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    Account findByUsernameAndPassword(String name,String pwd);
}
