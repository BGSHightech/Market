package com.bgs.market.application.option.service;

import com.bgs.market.application.option.view.dto.request.CreateOptionRequestDTO;
import com.bgs.market.application.option.view.dto.request.UpdateOptionRequestDTO;
import com.bgs.market.application.option.view.dto.response.CreateOptionResponseDTO;
import com.bgs.market.application.option.view.dto.response.GetAllOptionsResponseDTO;
import com.bgs.market.application.option.view.dto.response.GetOptionByIdResponseDTO;
import com.bgs.market.application.option.view.dto.response.UpdateOptionResponseDTO;

/**
 * Class for OptionService.
 */
public interface OptionService {
    /**
     * Get list of options.
     *
     * @return options
     */
    GetAllOptionsResponseDTO getAllOptions() throws Exception;

    /**
     * Get option by id.
     *
     * @param optionId represents optionId
     * @return option
     */
    GetOptionByIdResponseDTO getOptionById(Long optionId) throws Exception;

    /**
     * Create option.
     *
     * @param request represents CreateOptionRequestDTO
     * @return option
     */
    CreateOptionResponseDTO createOption(CreateOptionRequestDTO request) throws Exception;

    /**
     * Update option.
     *
     * @param request  represents UpdateOptionRequestDTO
     * @param optionId represents optionId
     * @return option
     */
    UpdateOptionResponseDTO updateOption(UpdateOptionRequestDTO request,
                                         Long optionId) throws Exception;
}
