package com.hdtech.dianligongdan.repository;

import com.hdtech.dianligongdan.domain.entity.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ImportRepository extends JpaRepository<Import, Integer> {
    Page<Import> findAll(Specification<Import> spec, Pageable pageAble);

    List<Import> findAll();
    List<Import> findByIdIn(Collection<Integer> ids);
}
