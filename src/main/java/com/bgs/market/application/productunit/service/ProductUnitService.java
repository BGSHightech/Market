package com.bgs.market.application.productunit.service;

import com.bgs.market.application.productunit.view.dto.request.CreateProductUnitRequestDTO;
import com.bgs.market.application.productunit.view.dto.request.UpdateProductUnitRequestDTO;
import com.bgs.market.application.productunit.view.dto.response.CreateProductUnitResponseDTO;
import com.bgs.market.application.productunit.view.dto.response.GetAllProductUnitsResponseDTO;
import com.bgs.market.application.productunit.view.dto.response.GetProductUnitByIdResponseDTO;
import com.bgs.market.application.productunit.view.dto.response.UpdateProductUnitResponseDTO;

/**
 * Class for ProductUnitService.
 */
public interface ProductUnitService {
    /**
     * Get list of product units.
     *
     * @return product units
     */
    GetAllProductUnitsResponseDTO getAllProductUnits() throws Exception;

    /**
     * Get product unit by id.
     *
     * @param productUnitId represents productUnitId
     * @return product unit
     */
    GetProductUnitByIdResponseDTO getProductUnitById(Long productUnitId) throws Exception;

    /**
     * Create product unit.
     *
     * @param request represents CreateProductUnitRequestDTO
     * @return product unit
     */
    CreateProductUnitResponseDTO createProductUnit(CreateProductUnitRequestDTO request) throws Exception;

    /**
     * Update product unit.
     *
     * @param request       represents UpdateProductUnitRequestDTO
     * @param productUnitId represents productUnitId
     * @return product unit
     */
    UpdateProductUnitResponseDTO updateProductUnit(UpdateProductUnitRequestDTO request,
                                                   Long productUnitId) throws Exception;
}
