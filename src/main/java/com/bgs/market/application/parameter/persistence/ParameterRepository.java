package com.bgs.market.application.parameter.persistence;

import com.bgs.market.exception.Exception;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Class for ParameterRepository.
 */
public interface ParameterRepository extends JpaRepository<Parameter, Long> {
    /**
     * Get list of parameter by parameter type.
     *
     * @param type represents parameter type
     * @return parameters
     */
    @Query("SELECT p FROM Parameter p WHERE " +
            "p.parameterType = :type " +
            "AND p.state = 1")
    List<Parameter> getAllParametersByTypeQuery(String type) throws Exception;
}
