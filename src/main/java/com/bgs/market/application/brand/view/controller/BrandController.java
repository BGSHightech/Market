package com.bgs.market.application.brand.view.controller;

import com.bgs.market.application.brand.service.BrandService;
import com.bgs.market.application.brand.view.dto.request.CreateBrandRequestDTO;
import com.bgs.market.application.brand.view.dto.request.UpdateBrandRequestDTO;
import com.bgs.market.application.brand.view.dto.response.CreateBrandResponseDTO;
import com.bgs.market.application.brand.view.dto.response.GetAllBrandsResponseDTO;
import com.bgs.market.application.brand.view.dto.response.GetBrandByIdResponseDTO;
import com.bgs.market.application.brand.view.dto.response.UpdateBrandResponseDTO;
import com.bgs.market.exception.Exception;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class for BrandController.
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/brand")
public class BrandController {
    private BrandService brandService;

    /**
     * Get list of brands.
     *
     * @return brands
     */
    @GetMapping
    public GetAllBrandsResponseDTO getAllBrands() throws Exception {
        return brandService.getAllBrands();
    }

    /**
     * Get brand by id.
     *
     * @param brandId represents brandId
     * @return brand
     */
    @GetMapping("{brandId}")
    public GetBrandByIdResponseDTO getBrandById(@PathVariable("brandId") Long brandId) throws Exception {
        return brandService.getBrandById(brandId);
    }

    /**
     * Create brand.
     *
     * @param request represents CreateBrandRequestDTO
     * @return brand
     */
    @PostMapping
    public CreateBrandResponseDTO createBrand(@RequestBody CreateBrandRequestDTO request) throws Exception {
        return brandService.createBrand(request);
    }

    /**
     * Update brand.
     *
     * @param brandId represents brandId
     * @param request represents UpdateBrandRequestDTO
     * @return brand
     */
    @PutMapping("{brandId}")
    public UpdateBrandResponseDTO updateBrandResponseDTO(@PathVariable("brandId") Long brandId,
                                                         @RequestBody UpdateBrandRequestDTO request) throws Exception {
        request.setBrandId(brandId);
        return brandService.updateBrand(request);
    }
}
