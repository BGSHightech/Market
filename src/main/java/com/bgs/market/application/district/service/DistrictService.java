package com.bgs.market.application.district.service;

import com.bgs.market.application.district.view.dto.response.GetAllDistrictsResponseDTO;
import com.bgs.market.application.district.view.dto.response.GetDistrictByIdResponseDTO;

/**
 * Class for DistrictService.
 */
public interface DistrictService {

    /**
     * Get list of districts.
     *
     * @return districts
     */
    GetAllDistrictsResponseDTO getAllDistricts() throws Exception;

    /**
     * Get district by id.
     *
     * @param districtId represents districtId
     * @return districts
     */
    GetDistrictByIdResponseDTO getDistrictById(String districtId) throws Exception;
}
