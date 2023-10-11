package com.bgs.market.application.user.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Class for UserRepository.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Get user by username
     * @param username represents username
     * @return user
     */
    Optional<User> getUserByUsername(String username) throws Exception;
}
