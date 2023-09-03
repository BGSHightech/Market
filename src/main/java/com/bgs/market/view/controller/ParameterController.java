package com.bgs.market.view.controller;

import com.bgs.market.persistence.domain.Parameter;
import com.bgs.market.transactional.service.ParameterService;
import com.bgs.market.view.dto.request.CreateParameterRequestDTO;
import com.bgs.market.view.dto.request.UpdateParameterRequestDTO;
import com.bgs.market.view.dto.response.CreateParameterResponseDTO;
import com.bgs.market.view.dto.response.GetAllParametersResponseDTO;
import com.bgs.market.view.dto.response.UpdateParameterResponseDTO;
import com.bgs.market.view.exception.Exception;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/parameter")
public class ParameterController {

    private ParameterService parameterService;

    @GetMapping
    public GetAllParametersResponseDTO getAllParameters() throws Exception {
        return parameterService.getAllParameters();
    }

    @PostMapping
    public CreateParameterResponseDTO createParameter(@RequestBody CreateParameterRequestDTO request) throws Exception{
        return parameterService.createParameter(request);
    }

    @PutMapping
    public UpdateParameterResponseDTO updateParameter(@RequestBody UpdateParameterRequestDTO request) throws Exception{
        return parameterService.updateParameter(request);
    }

}
