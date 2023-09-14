package com.bgs.market.application.subfamily.view.controller;

import com.bgs.market.application.subfamily.service.SubFamilyService;
import com.bgs.market.application.subfamily.view.dto.request.CreateSubFamilyRequestDTO;
import com.bgs.market.application.subfamily.view.dto.request.UpdateSubFamilyRequestDTO;
import com.bgs.market.application.subfamily.view.dto.response.CreateSubFamilyResponseDTO;
import com.bgs.market.application.subfamily.view.dto.response.GetAllSubFamiliesResponseDTO;
import com.bgs.market.application.subfamily.view.dto.response.GetSubFamilyByIdResponseDTO;
import com.bgs.market.application.subfamily.view.dto.response.UpdateSubFamilyResponseDTO;
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
     * Get subfamily by id.
     *
     * @param subFamilyId represents subFamilyId
     * @return subfamily
     */
    @GetMapping("{subFamilyId}")
    public GetSubFamilyByIdResponseDTO getSubFamilyById(@PathVariable("subFamilyId") Long subFamilyId) throws Exception {
        return subFamilyService.getSubFamilyById(subFamilyId);
    }

    /**
     * Create subfamily.
     *
     * @param request represents CreateSubFamilyRequestDTO
     * @return subfamily
     */
    @PostMapping
    public CreateSubFamilyResponseDTO createSubFamily(@Valid @RequestBody CreateSubFamilyRequestDTO request) throws Exception {
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
                                                                 @Valid @RequestBody UpdateSubFamilyRequestDTO request) throws Exception {
        return subFamilyService.updateSubFamily(request, subFamilyId);
    }
}
