package com.bgs.market.application.district.view.controller;

import com.bgs.market.application.district.service.DistrictService;
import com.bgs.market.application.district.view.dto.response.GetAllDistrictsResponseDTO;
import com.bgs.market.application.district.view.dto.response.GetDistrictByIdResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class for DistrictController.
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/district")
public class DistrictController {
    private DistrictService districtService;

    /**
     * Get list of districts.
     *
     * @return districts
     */
    @GetMapping
    public GetAllDistrictsResponseDTO getAllDistricts() throws Exception {
        return districtService.getAllDistricts();
    }

    /**
     * Get district by id.
     *
     * @param districtId represents districtId
     * @return districts
     */
    @GetMapping("{id}")
    public GetDistrictByIdResponseDTO getDistrictById(@PathVariable("id") String districtId) throws Exception {
        return districtService.getDistrictById(districtId);
    }
}
