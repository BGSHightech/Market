package com.bgs.market.transactional.service;

import com.bgs.market.view.dto.request.CreateParameterRequestDTO;
import com.bgs.market.view.dto.request.UpdateParameterRequestDTO;
import com.bgs.market.view.dto.response.CreateParameterResponseDTO;
import com.bgs.market.view.dto.response.GetAllParametersResponseDTO;
import com.bgs.market.view.dto.response.UpdateParameterResponseDTO;
import com.bgs.market.view.exception.Exception;

public interface ParameterService {
    CreateParameterResponseDTO createParameter(CreateParameterRequestDTO request) throws Exception;

    UpdateParameterResponseDTO updateParameter(UpdateParameterRequestDTO request);

    GetAllParametersResponseDTO getAllParameters() throws Exception;

    GetAllParametersResponseDTO getAllParametersByParameterType(String type) throws Exception;
}
