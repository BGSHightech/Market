package com.bgs.market.application.brand.service;

import com.bgs.market.application.brand.view.dto.request.CreateBrandRequestDTO;
import com.bgs.market.application.brand.view.dto.request.UpdateBrandRequestDTO;
import com.bgs.market.application.brand.view.dto.response.CreateBrandResponseDTO;
import com.bgs.market.application.brand.view.dto.response.GetAllBrandsResponseDTO;
import com.bgs.market.application.brand.view.dto.response.GetBrandByIdResponseDTO;
import com.bgs.market.application.brand.view.dto.response.UpdateBrandResponseDTO;
import com.bgs.market.exception.Exception;

/**
 * Class for BrandService.
 */
public interface BrandService {
    /**
     * Get list of brands.
     *
     * @return brands
     */
    GetAllBrandsResponseDTO getAllBrands() throws Exception;

    /**
     * Get brand by id.
     *
     * @param brandId represents brandId
     * @return brand
     */
    GetBrandByIdResponseDTO getBrandById(Long brandId) throws Exception;

    /**
     * Create brand.
     *
     * @param request represents CreateBrandRequestDTO
     * @return brand
     */
    CreateBrandResponseDTO createBrand(CreateBrandRequestDTO request) throws Exception;

    /**
     * Update brand.
     *
     * @param request represents UpdateBrandRequestDTO
     * @return brand
     */
    UpdateBrandResponseDTO updateBrand(UpdateBrandRequestDTO request) throws Exception;
}
