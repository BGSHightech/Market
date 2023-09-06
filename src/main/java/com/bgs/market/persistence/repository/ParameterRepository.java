package com.bgs.market.persistence.repository;

import com.bgs.market.persistence.domain.Parameter;
import com.bgs.market.view.exception.Exception;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParameterRepository extends JpaRepository<Parameter, Long> {

    @Query("SELECT p FROM Parameter p WHERE " +
            "p.parameterType = :type " +
            "AND p.state = 1")
    List<Parameter> getAllParametersByTypeQuery(String type) throws Exception;

}
