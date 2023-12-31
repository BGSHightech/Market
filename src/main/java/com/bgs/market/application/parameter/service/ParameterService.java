package com.bgs.market.application.parameter.service;

import com.bgs.market.application.parameter.view.dto.request.CreateParameterRequestDTO;
import com.bgs.market.application.parameter.view.dto.request.UpdateParameterRequestDTO;
import com.bgs.market.application.parameter.view.dto.response.CreateParameterResponseDTO;
import com.bgs.market.application.parameter.view.dto.response.GetAllParametersResponseDTO;
import com.bgs.market.application.parameter.view.dto.response.GetParametersByIdResponseDTO;
import com.bgs.market.application.parameter.view.dto.response.UpdateParameterResponseDTO;

/**
 * Class for ParameterService.
 */
public interface ParameterService {
    /**
     * Get list of parameters.
     *
     * @return parameters
     */
    GetAllParametersResponseDTO getAllParameters() throws Exception;

    /**
     * Get list of parameters by parameter type.
     *
     * @param type represents parameter type
     * @return parameters
     */

    GetAllParametersResponseDTO getAllParametersByParameterType(String type) throws Exception;

    /**
     * Get parameter by id.
     *
     * @param parameterId represents parameterId
     * @return parameter
     */
    GetParametersByIdResponseDTO getParameterById(Long parameterId) throws Exception;

    /**
     * Create parameter.
     *
     * @param request represents CreateParameterRequestDTO
     * @return parameter
     */
    CreateParameterResponseDTO createParameter(CreateParameterRequestDTO request) throws Exception;

    /**
     * Update parameter.
     *
     * @param request     represents UpdateParameterRequestDTO
     * @param parameterId represents parameterId
     * @return parameter
     */
    UpdateParameterResponseDTO updateParameter(UpdateParameterRequestDTO request,
                                               Long parameterId) throws Exception;
}
