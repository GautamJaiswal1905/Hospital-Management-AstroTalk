package com.Hospital.repository;

import com.Hospital.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    Staff findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String username);
}

