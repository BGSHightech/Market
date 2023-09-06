package com.bgs.market.transactional.service;

import com.bgs.market.view.dto.request.CreateBrandRequestDTO;
import com.bgs.market.view.dto.request.UpdateBrandRequestDTO;
import com.bgs.market.view.dto.response.CreateBrandResponseDTO;
import com.bgs.market.view.dto.response.GetAllBrandsResponseDTO;
import com.bgs.market.view.dto.response.UpdateBrandResponseDTO;
import com.bgs.market.view.exception.Exception;

public interface BrandService {
    CreateBrandResponseDTO createBrand(CreateBrandRequestDTO request) throws Exception;

    UpdateBrandResponseDTO updateBrand(UpdateBrandRequestDTO request) throws Exception;

    GetAllBrandsResponseDTO getAllBrands() throws Exception;
}
