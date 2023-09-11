package com.bgs.market.application.province.view.controller;

import com.bgs.market.application.province.service.ProvinceService;
import com.bgs.market.application.province.view.dto.response.GetAllProvincesResponseDTO;
import com.bgs.market.application.province.view.dto.response.GetProvinceByIdResponseDTO;
import com.bgs.market.exception.Exception;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class for ProvinceController.
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/province")
public class ProvinceController {
    private ProvinceService provinceService;

    /**
     * Get list of provinces.
     *
     * @return provinces
     */
    @GetMapping
    public GetAllProvincesResponseDTO getAllProvinces() throws Exception {
        return provinceService.getAllProvinces();
    }

    /**
     * Get province by id.
     *
     * @param provinceId represents provinceId
     * @return provinces
     */
    @GetMapping("{id}")
    public GetProvinceByIdResponseDTO getProvinceById(@PathVariable("id") String provinceId) throws Exception {
        return provinceService.getProvinceById(provinceId);
    }
}
