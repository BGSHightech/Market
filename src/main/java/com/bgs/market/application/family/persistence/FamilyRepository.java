package com.bgs.market.application.family.persistence;

import com.bgs.market.application.user.persistence.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Class for FamilyRepository.
 */
public interface FamilyRepository extends JpaRepository<Family, Long> {
    /**
     * Get families by categoryId
     * @param categoryId represents categoryId
     * @return families
     */
    Optional <List<Family>> findFamiliesByCategoryId(Long categoryId) throws Exception;

}
