package com.bgs.market.persistence.repository;

import com.bgs.market.persistence.domain.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParameterRepository extends JpaRepository<Parameter, Long> {

}
