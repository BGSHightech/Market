package com.bgs.market.view.controller;

import com.bgs.market.transactional.service.ProductUnitService;
import com.bgs.market.view.dto.request.CreateProductUnitRequestDTO;
import com.bgs.market.view.dto.request.UpdateProductUnitRequestDTO;
import com.bgs.market.view.dto.response.*;
import com.bgs.market.view.exception.Exception;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/productunit")
public class ProductUnitController {
    private ProductUnitService productUnitService;

    @GetMapping
    public GetAllProductUnitsResponseDTO getAllProductUnits() throws Exception {
        return productUnitService.getAllProductUnits();
    }

    @PostMapping
    public CreateProductUnitResponseDTO createProductUnit(@RequestBody CreateProductUnitRequestDTO request) throws Exception {
        return productUnitService.createProductUnit(request);
    }

    @PutMapping("{productUnitId}")
    public UpdateProductUnitResponseDTO updateProductUnitResponseDTO(@PathVariable("productUnitId") Long productUnitId,
                                                                     @RequestBody UpdateProductUnitRequestDTO request) throws Exception {
        request.setProductUnitId(productUnitId);
        return productUnitService.updateProductUnit(request);
    }
}
