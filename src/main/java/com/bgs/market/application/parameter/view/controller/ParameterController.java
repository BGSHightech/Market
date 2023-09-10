package com.bgs.market.application.parameter.view.controller;

import com.bgs.market.application.parameter.service.ParameterService;
import com.bgs.market.application.parameter.view.dto.request.CreateParameterRequestDTO;
import com.bgs.market.application.parameter.view.dto.request.UpdateParameterRequestDTO;
import com.bgs.market.application.parameter.view.dto.response.CreateParameterResponseDTO;
import com.bgs.market.application.parameter.view.dto.response.GetAllParametersResponseDTO;
import com.bgs.market.application.parameter.view.dto.response.UpdateParameterResponseDTO;
import com.bgs.market.exception.Exception;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class for ParameterController.
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/parameter")
public class ParameterController {
    private ParameterService parameterService;

    /**
     * Get list of parameters.
     *
     * @return parameters
     */
    @GetMapping
    public GetAllParametersResponseDTO getAllParameters() throws Exception {
        return parameterService.getAllParameters();
    }

    /**
     * Get list of parameters. - Example Url: localhost:8080/api/v1/parameter/byType?type=Tipo de documento de identidad
     *
     * @param type represents type
     * @return parameters
     */
    @GetMapping(path = "type")
    public GetAllParametersResponseDTO getAllParametersByParameterType(@RequestParam("type") String type) throws Exception {
        return parameterService.getAllParametersByParameterType(type);
    }

    /**
     * Create parameter.
     *
     * @param request represents CreateParameterRequestDTO
     * @return parameter
     */
    @PostMapping
    public CreateParameterResponseDTO createParameter(@RequestBody CreateParameterRequestDTO request) throws Exception {
        return parameterService.createParameter(request);
    }

    /**
     * Update parameter.
     *
     * @param parameterId represents parameterId
     * @param request     represents UpdateParameterRequestDTO
     * @return parameter
     */
    @PutMapping("{parameterId}")
    public UpdateParameterResponseDTO updateParameter(@PathVariable("parameterId") Long parameterId,
                                                      @RequestBody UpdateParameterRequestDTO request) throws Exception {
        request.setParameterId(parameterId);
        return parameterService.updateParameter(request);
    }
}
