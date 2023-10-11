package com.bgs.market.application.permission.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Class for PermissionRepository.
 */
public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
