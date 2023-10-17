package com.bgs.market.application.family.service;

import com.bgs.market.application.family.view.dto.request.CreateFamilyRequestDTO;
import com.bgs.market.application.family.view.dto.request.UpdateFamilyRequestDTO;
import com.bgs.market.application.family.view.dto.response.*;

/**
 * Class for FamilyService.
 */
public interface FamilyService {
    /**
     * Get list of families.
     *
     * @return families
     */
    GetAllFamiliesResponseDTO getAllFamilies() throws Exception;

    /**
     * Get family by id.
     *
     * @param familyId represents familyId
     * @return family
     */
    GetFamilyByIdResponseDTO getFamilyById(Long familyId) throws Exception;

    /**
     * Create family.
     *
     * @param request represents CreateFamilyRequestDTO.
     * @return family
     */
    CreateFamilyResponseDTO createFamily(CreateFamilyRequestDTO request) throws Exception;

    /**
     * Update family.
     *
     * @param request  represents UpdateFamilyRequestDTO
     * @param familyId represents familyId
     * @return family
     */
    UpdateFamilyResponseDTO updateFamily(UpdateFamilyRequestDTO request,
                                         Long familyId) throws Exception;

    /**
     * Get family by categoryId.
     *
     * @param categoryId represents categoryId
     * @return family
     */
    GetAllFamiliesByCategoryIdResponseDTO getFamiliesByCategoryId(Long categoryId) throws Exception;

}
