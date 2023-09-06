package com.bgs.market.persistence.repository;

import com.bgs.market.persistence.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, String> {
}
