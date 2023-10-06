package com.bgs.market.application.user.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Class for UserRepository.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
