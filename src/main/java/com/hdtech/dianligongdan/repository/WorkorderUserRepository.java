package com.hdtech.dianligongdan.repository;

import com.hdtech.dianligongdan.domain.entity.WorkorderUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkorderUserRepository extends JpaRepository<WorkorderUser, String> {
    List<WorkorderUser> findByWorkorderIdIn(List<Integer> ids);
}
