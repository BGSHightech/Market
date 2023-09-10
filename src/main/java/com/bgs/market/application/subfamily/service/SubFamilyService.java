package com.bgs.market.application.subfamily.service;

import com.bgs.market.application.subfamily.view.dto.request.CreateSubFamilyRequestDTO;
import com.bgs.market.application.subfamily.view.dto.request.UpdateSubFamilyRequestDTO;
import com.bgs.market.application.subfamily.view.dto.response.CreateSubFamilyResponseDTO;
import com.bgs.market.application.subfamily.view.dto.response.GetAllSubFamiliesResponseDTO;
import com.bgs.market.application.subfamily.view.dto.response.UpdateSubFamilyResponseDTO;
import com.bgs.market.exception.Exception;

/**
 * Class for SubFamilyService.
 */
public interface SubFamilyService {
    /**
     * Get list of subfamilies.
     *
     * @return subfamilies
     */
    GetAllSubFamiliesResponseDTO getAllSubFamilies() throws Exception;

    /**
     * Create subfamily.
     *
     * @param request represents CreateSubFamilyRequestDTO
     * @return subfamilies
     */
    CreateSubFamilyResponseDTO createSubFamily(CreateSubFamilyRequestDTO request) throws Exception;

    /**
     * Update subfamily.
     *
     * @param request represents UpdateSubFamilyRequestDTO
     * @return subfamilies
     */
    UpdateSubFamilyResponseDTO updateSubFamily(UpdateSubFamilyRequestDTO request) throws Exception;

}
