package com.bgs.market.application.category.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Class for CategoryRepository.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
