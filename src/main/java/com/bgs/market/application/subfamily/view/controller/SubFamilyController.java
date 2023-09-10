package com.bgs.market.application.subfamily.view.controller;

import com.bgs.market.application.subfamily.service.SubFamilyService;
import com.bgs.market.application.subfamily.view.dto.request.CreateSubFamilyRequestDTO;
import com.bgs.market.application.subfamily.view.dto.request.UpdateSubFamilyRequestDTO;
import com.bgs.market.application.subfamily.view.dto.response.CreateSubFamilyResponseDTO;
import com.bgs.market.application.subfamily.view.dto.response.GetAllSubFamiliesResponseDTO;
import com.bgs.market.application.subfamily.view.dto.response.UpdateSubFamilyResponseDTO;
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
 * Class for SubFamilyController.
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/subfamily")
public class SubFamilyController {
    private SubFamilyService subFamilyService;

    /**
     * Get list of subfamilies.
     *
     * @return subfamilies
     */
    @GetMapping
    public GetAllSubFamiliesResponseDTO getAllSubFamilies() throws Exception {
        return subFamilyService.getAllSubFamilies();
    }

    /**
     * Create subfamily.
     *
     * @param request represents CreateSubFamilyRequestDTO
     * @return subfamily
     */
    @PostMapping
    public CreateSubFamilyResponseDTO createSubFamily(@RequestBody CreateSubFamilyRequestDTO request) throws Exception {
        return subFamilyService.createSubFamily(request);
    }

    /**
     * Update subfamily.
     *
     * @param subFamilyId represents subFamilyId
     * @param request     represents UpdateSubFamilyRequestDTO
     * @return subfamily
     */
    @PutMapping("{subFamilyId}")
    public UpdateSubFamilyResponseDTO updateSubFamilyResponseDTO(@PathVariable("subFamilyId") Long subFamilyId,
                                                                 @RequestBody UpdateSubFamilyRequestDTO request) throws Exception {
        request.setSubFamilyId(subFamilyId);
        return subFamilyService.updateSubFamily(request);
    }
}
