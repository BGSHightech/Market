package com.bgs.market.application.product.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Class for ProductRepository.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
