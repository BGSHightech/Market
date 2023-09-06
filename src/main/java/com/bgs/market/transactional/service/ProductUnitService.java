package com.bgs.market.transactional.service;

import com.bgs.market.view.dto.request.CreateProductUnitRequestDTO;
import com.bgs.market.view.dto.request.UpdateProductUnitRequestDTO;
import com.bgs.market.view.dto.response.CreateProductUnitResponseDTO;
import com.bgs.market.view.dto.response.GetAllProductUnitsResponseDTO;
import com.bgs.market.view.dto.response.UpdateProductUnitResponseDTO;
import com.bgs.market.view.exception.Exception;

public interface ProductUnitService {
    CreateProductUnitResponseDTO createProductUnit(CreateProductUnitRequestDTO request) throws Exception;

    UpdateProductUnitResponseDTO updateProductUnit(UpdateProductUnitRequestDTO request) throws Exception;
    
    GetAllProductUnitsResponseDTO getAllProductUnits() throws Exception;

}
