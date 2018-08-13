package com.hdtech.dianligongdan.repository;

import com.hdtech.dianligongdan.domain.entity.WorkorderUser;
import com.hdtech.dianligongdan.domain.entity.WorkorderUserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkorderUserRepository extends JpaRepository<WorkorderUser, String> {
    @Query(" SELECT new com.hdtech.dianligongdan.domain.entity.WorkorderUserDto(dwu.workorderId,dwu.managerId,dwu.status,dm.name,dm.phonenum) " +
            " FROM WorkorderUser dwu " +
            " JOIN Account dm ON dwu.managerId = dm.id " +
            " WHERE dwu.workorderId IN ?1")
    List<WorkorderUserDto> findByWorkorderIds(List<Integer> ids);
}
