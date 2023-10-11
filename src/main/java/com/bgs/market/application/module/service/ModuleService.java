package com.bgs.market.application.module.service;

import com.bgs.market.application.module.view.dto.request.CreateModuleRequestDTO;
import com.bgs.market.application.module.view.dto.request.UpdateModuleRequestDTO;
import com.bgs.market.application.module.view.dto.response.CreateModuleResponseDTO;
import com.bgs.market.application.module.view.dto.response.GetAllModulesResponseDTO;
import com.bgs.market.application.module.view.dto.response.GetModuleByIdResponseDTO;
import com.bgs.market.application.module.view.dto.response.UpdateModuleResponseDTO;

/**
 * Class for ModuleService.
 */
public interface ModuleService {
    /**
     * Get list of modules.
     *
     * @return modules
     */
    GetAllModulesResponseDTO getAllModules() throws Exception;

    /**
     * Get module by id.
     *
     * @param moduleId represents moduleId
     * @return module
     */
    GetModuleByIdResponseDTO getModuleById(Long moduleId) throws Exception;

    /**
     * Create module.
     *
     * @param request represents CreateModuleResponseDTO
     * @return module
     */
    CreateModuleResponseDTO createModule(CreateModuleRequestDTO request) throws Exception;

    /**
     * Update module.
     *
     * @param request   represents UpdateModuleResponseDTO
     * @param moduleId represents moduleId
     * @return module
     */
    UpdateModuleResponseDTO updateModule(UpdateModuleRequestDTO request,
                                         Long moduleId) throws Exception;

}
