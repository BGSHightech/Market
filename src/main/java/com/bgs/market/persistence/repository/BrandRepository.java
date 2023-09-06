package com.bgs.market.persistence.repository;

import com.bgs.market.persistence.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
