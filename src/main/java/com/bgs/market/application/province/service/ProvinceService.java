package com.bgs.market.application.province.service;

import com.bgs.market.application.province.view.dto.response.GetAllProvincesResponseDTO;
import com.bgs.market.application.province.view.dto.response.GetProvinceByIdResponseDTO;

/**
 * Class for ProvinceService.
 */
public interface ProvinceService {
    /**
     * Get list of provinces.
     *
     * @return provinces
     */
    GetAllProvincesResponseDTO getAllProvinces() throws Exception;

    /**
     * Get province by id.
     *
     * @param provinceId represents provinceId
     * @return provinces
     */
    GetProvinceByIdResponseDTO getProvinceById(String provinceId) throws Exception;
}
