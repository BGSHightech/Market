package com.bgs.market.view.controller;


import com.bgs.market.transactional.service.ParameterService;
import com.bgs.market.transactional.service.ProductUnitService;
import com.bgs.market.view.dto.response.GetAllParametersResponseDTO;
import com.bgs.market.view.dto.response.GetAllProductUnitResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/productunit")
public class ProductUnitController {
    private ProductUnitService productUnitService;

    @GetMapping
    public GetAllProductUnitResponseDTO getAllProductUnits(){
        return productUnitService.getAllProductUnits();
    }
}
