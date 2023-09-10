package com.bgs.market.application.client.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Class for ClientRepository.
 */
public interface ClientRepository extends JpaRepository<Client, Long> {
}
