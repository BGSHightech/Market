package com.bgs.market.application.productunit.view.controller;

import com.bgs.market.application.productunit.service.ProductUnitService;
import com.bgs.market.application.productunit.view.dto.request.CreateProductUnitRequestDTO;
import com.bgs.market.application.productunit.view.dto.request.UpdateProductUnitRequestDTO;
import com.bgs.market.application.productunit.view.dto.response.CreateProductUnitResponseDTO;
import com.bgs.market.application.productunit.view.dto.response.GetAllProductUnitsResponseDTO;
import com.bgs.market.application.productunit.view.dto.response.GetProductUnitByIdResponseDTO;
import com.bgs.market.application.productunit.view.dto.response.UpdateProductUnitResponseDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class for ProductUnitController.
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/product-unit")
public class ProductUnitController {
    private ProductUnitService productUnitService;

    /**
     * Get list of product units.
     *
     * @return product units
     */
    @GetMapping
    public GetAllProductUnitsResponseDTO getAllProductUnits() throws Exception {
        return productUnitService.getAllProductUnits();
    }

    /**
     * Get product unit by id.
     *
     * @param productUnitId represents productUnitId
     * @return product unit
     */
    @GetMapping("{productUnitId}")
    public GetProductUnitByIdResponseDTO getProductUnitById(@PathVariable("productUnitId") Long productUnitId) throws Exception {
        return productUnitService.getProductUnitById(productUnitId);
    }

    /**
     * Create product unit.
     *
     * @param request represents CreateProductUnitRequestDTO
     * @return product unit
     */
    @PostMapping
    public CreateProductUnitResponseDTO createProductUnit(@Valid @RequestBody CreateProductUnitRequestDTO request) throws Exception {
        return productUnitService.createProductUnit(request);
    }

    /**
     * Update product unit.
     *
     * @param productUnitId represents productUnitId
     * @param request       represents UpdateProductUnitRequestDTO
     * @return product unit
     */
    @PutMapping("{productUnitId}")
    public UpdateProductUnitResponseDTO updateProductUnitResponseDTO(@PathVariable("productUnitId") Long productUnitId,
                                                                     @Valid @RequestBody UpdateProductUnitRequestDTO request) throws Exception {
        return productUnitService.updateProductUnit(request, productUnitId);
    }
}
