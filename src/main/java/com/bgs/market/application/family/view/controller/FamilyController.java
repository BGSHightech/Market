package com.bgs.market.application.family.view.controller;

import com.bgs.market.application.family.service.FamilyService;
import com.bgs.market.application.family.view.dto.request.CreateFamilyRequestDTO;
import com.bgs.market.application.family.view.dto.request.UpdateFamilyRequestDTO;
import com.bgs.market.application.family.view.dto.response.CreateFamilyResponseDTO;
import com.bgs.market.application.family.view.dto.response.GetAllFamiliesResponseDTO;
import com.bgs.market.application.family.view.dto.response.GetFamilyByIdResponseDTO;
import com.bgs.market.application.family.view.dto.response.UpdateFamilyResponseDTO;
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
 * Class for FamilyController.
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/family")
public class FamilyController {
    private FamilyService FamilyService;

    /**
     * Get list of families.
     *
     * @return families
     */
    @GetMapping
    public GetAllFamiliesResponseDTO getAllFamilies() throws Exception {
        return FamilyService.getAllFamilies();
    }

    /**
     * Get family by id.
     *
     * @param familyId represents familyId
     * @return family
     */
    @GetMapping("{familyId}")
    public GetFamilyByIdResponseDTO getFamilyById(@PathVariable("familyId") Long familyId) throws Exception {
        return FamilyService.getFamilyById(familyId);
    }

    /**
     * Create family.
     *
     * @param request represents CreateFamilyRequestDTO
     * @return family
     */
    @PostMapping
    public CreateFamilyResponseDTO createFamily(@Valid @RequestBody CreateFamilyRequestDTO request) throws Exception {
        return FamilyService.createFamily(request);
    }

    /**
     * Update family.
     *
     * @param familyId represents familyId
     * @param request  represents UpdateFamilyRequestDTO
     * @return family
     */
    @PutMapping("{familyId}")
    public UpdateFamilyResponseDTO updateFamilyResponseDTO(@PathVariable("familyId") Long familyId,
                                                           @Valid @RequestBody UpdateFamilyRequestDTO request) throws Exception {
        return FamilyService.updateFamily(request, familyId);
    }
}
