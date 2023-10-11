package com.bgs.market.application.module.view.controller;

import com.bgs.market.application.module.service.ModuleService;
import com.bgs.market.application.module.view.dto.request.CreateModuleRequestDTO;
import com.bgs.market.application.module.view.dto.request.UpdateModuleRequestDTO;
import com.bgs.market.application.module.view.dto.response.CreateModuleResponseDTO;
import com.bgs.market.application.module.view.dto.response.GetAllModulesResponseDTO;
import com.bgs.market.application.module.view.dto.response.GetModuleByIdResponseDTO;
import com.bgs.market.application.module.view.dto.response.UpdateModuleResponseDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Class for ProductController.
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/module")
public class ModuleController {
    private ModuleService moduleService;

    /**
     * Get list of modules.
     *
     * @return modules
     */
    @GetMapping()
    public GetAllModulesResponseDTO getAllModules() throws Exception {
        return moduleService.getAllModules();
    }

    /**
     * Get module by id.
     *
     * @param moduleId represents moduleId
     * @return module
     */
    @GetMapping("{moduleId}")
    public GetModuleByIdResponseDTO getModuleById(@PathVariable("moduleId") Long moduleId) throws Exception {
        return moduleService.getModuleById(moduleId);
    }

    /**
     * Create module.
     *
     * @param request represents CreateModuleRequestDTO
     * @return module
     */

    @PostMapping()
    public CreateModuleResponseDTO createModule(@Valid @RequestBody CreateModuleRequestDTO request) throws Exception {
        return moduleService.createModule(request);
    }

    /**
     * Update product.
     *
     * @param moduleId represents moduleId
     * @param request   represents UpdateModuleRequestDTO
     * @return module
     */
    @PutMapping("{moduleId}")
    public UpdateModuleResponseDTO updateModule(@PathVariable("moduleId") Long moduleId,
                                                 @Valid @RequestBody UpdateModuleRequestDTO request) throws Exception {
        return moduleService.updateModule(request, moduleId);
    }
}
