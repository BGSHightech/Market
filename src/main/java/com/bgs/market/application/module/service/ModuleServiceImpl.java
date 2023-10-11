package com.bgs.market.application.module.service;


import com.bgs.market.application.brand.persistence.Brand;
import com.bgs.market.application.module.persistence.Module;
import com.bgs.market.application.module.persistence.ModuleRepository;
import com.bgs.market.application.module.view.dto.request.CreateModuleRequestDTO;
import com.bgs.market.application.module.view.dto.request.UpdateModuleRequestDTO;
import com.bgs.market.application.module.view.dto.response.CreateModuleResponseDTO;
import com.bgs.market.application.module.view.dto.response.GetAllModulesResponseDTO;
import com.bgs.market.application.module.view.dto.response.GetModuleByIdResponseDTO;
import com.bgs.market.application.module.view.dto.response.UpdateModuleResponseDTO;
import com.bgs.market.application.product.persistence.Product;
import com.bgs.market.application.product.view.dto.response.CreateProductResponseDTO;
import com.bgs.market.application.product.view.dto.response.GetProductByIdResponseDTO;
import com.bgs.market.application.product.view.dto.response.UpdateProductResponseDTO;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Class for ModuleServiceImpl.
 */
@Service
@AllArgsConstructor
public class ModuleServiceImpl implements ModuleService {
    /**
     * Instantiating repositories.
     */
    ModuleRepository moduleRepository;

    /**
     * Get list of modules.
     *
     * @return modules
     */
    @Override
    public GetAllModulesResponseDTO getAllModules() throws Exception {
        // Assign value and find all modules.
        GetAllModulesResponseDTO responseDTO = new GetAllModulesResponseDTO();
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setModules(moduleRepository.findAll());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Get module by id.
     *
     * @param moduleId represents moduleId
     * @return module
     */

    @Override
    public GetModuleByIdResponseDTO getModuleById(Long moduleId) throws Exception {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(moduleId));
        GetModuleByIdResponseDTO responseDTO = new GetModuleByIdResponseDTO();

        // Validate if module exists
        Optional<Module> optionalModule = moduleRepository.findById(moduleId);
        if (optionalModule.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The module doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Assign values.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setModule(optionalModule.get());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Create module.
     *
     * @param request represents CreateModuleResponseDTO
     * @return module
     */
    @Override
    public CreateModuleResponseDTO createModule(CreateModuleRequestDTO request) throws Exception {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(request));
        CreateModuleResponseDTO responseDTO = new CreateModuleResponseDTO();

        // Assign values and save.
        Module module = new Module();
        module.setModuleName(request.getModuleName());
        Module moduleCreated = moduleRepository.save(module);

        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setModule(moduleCreated);

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Update module.
     *
     * @param request   represents UpdateModuleRequestDTO
     * @param moduleId represents moduleId
     * @return module
     */
    @Override
    public UpdateModuleResponseDTO updateModule(UpdateModuleRequestDTO request, Long moduleId) throws Exception {
        // Show the request in the console
        System.out.println("request = " + new Gson().toJson(request));
        UpdateModuleResponseDTO responseDTO = new UpdateModuleResponseDTO();

        // Validate if module exists
        Optional<Module> optionalModule = moduleRepository.findById(moduleId);
        if (optionalModule.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The module doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Assign values and save.
        Module existingModule = optionalModule.get();
        existingModule.setModuleName(request.getModuleName());
        existingModule.setState(request.getState());
        Module module = moduleRepository.save(existingModule);

        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setModule(module);

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }
}
