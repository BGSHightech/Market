package com.bgs.market.application.module.persistence;


import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Class for ProductRepository.
 */
public interface ModuleRepository extends JpaRepository<Module, Long> {
}
