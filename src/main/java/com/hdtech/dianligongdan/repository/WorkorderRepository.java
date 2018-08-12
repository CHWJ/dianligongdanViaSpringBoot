package com.hdtech.dianligongdan.repository;

import com.hdtech.dianligongdan.domain.entity.Workorder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkorderRepository extends JpaRepository<Workorder, Integer> {
    Page<Workorder> findAll(Specification<Workorder> spec, Pageable pageAble);
}
