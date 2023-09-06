package com.bgs.market.view.controller;

import com.bgs.market.transactional.service.ParameterService;
import com.bgs.market.view.dto.request.CreateParameterRequestDTO;
import com.bgs.market.view.dto.request.UpdateParameterRequestDTO;
import com.bgs.market.view.dto.response.CreateParameterResponseDTO;
import com.bgs.market.view.dto.response.GetAllParametersResponseDTO;
import com.bgs.market.view.dto.response.UpdateParameterResponseDTO;
import com.bgs.market.view.exception.Exception;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/parameter")
public class ParameterController {
    private ParameterService parameterService;

    @GetMapping
    public GetAllParametersResponseDTO getAllParameters() throws Exception {
        return parameterService.getAllParameters();
    }

    @GetMapping(path = "byType")
    public GetAllParametersResponseDTO getAllParametersByParameterType(@RequestParam("type") String type) throws Exception {
        return parameterService.getAllParametersByParameterType(type);
    }

    @PostMapping
    public CreateParameterResponseDTO createParameter(@RequestBody CreateParameterRequestDTO request) throws Exception{
        return parameterService.createParameter(request);
    }

    @PutMapping("{parameterId}")
    public UpdateParameterResponseDTO updateParameter(@PathVariable("parameterId") Long parameterId,
                                                      @RequestBody UpdateParameterRequestDTO request) throws Exception{
        request.setParameterId(parameterId);
        return parameterService.updateParameter(request);
    }
}
