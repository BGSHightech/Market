package com.bgs.market.view.controller;

import com.bgs.market.transactional.service.BrandService;
import com.bgs.market.view.dto.request.CreateBrandRequestDTO;
import com.bgs.market.view.dto.request.UpdateBrandRequestDTO;
import com.bgs.market.view.dto.response.CreateBrandResponseDTO;
import com.bgs.market.view.dto.response.GetAllBrandsResponseDTO;
import com.bgs.market.view.dto.response.UpdateBrandResponseDTO;
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
@RequestMapping("api/v1/brand")
public class BrandController {
    private BrandService brandService;

    @GetMapping
    public GetAllBrandsResponseDTO getAllBrands() throws Exception {
        return brandService.getAllBrands();
    }

    @PostMapping
    public CreateBrandResponseDTO createBrand(@RequestBody CreateBrandRequestDTO request) throws Exception {
        return brandService.createBrand(request);
    }

    @PutMapping("{brandId}")
    public UpdateBrandResponseDTO updateBrandResponseDTO(@PathVariable("brandId") Long brandId,
                                                         @RequestBody UpdateBrandRequestDTO request) throws Exception {
        request.setBrandId(brandId);
        return brandService.updateBrand(request);
    }
}
