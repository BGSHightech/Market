package com.bgs.market.application.parameter.service;

import com.bgs.market.application.parameter.persistence.Parameter;
import com.bgs.market.application.parameter.persistence.ParameterRepository;
import com.bgs.market.application.parameter.view.dto.request.CreateParameterRequestDTO;
import com.bgs.market.application.parameter.view.dto.request.UpdateParameterRequestDTO;
import com.bgs.market.application.parameter.view.dto.response.CreateParameterResponseDTO;
import com.bgs.market.application.parameter.view.dto.response.GetAllParametersResponseDTO;
import com.bgs.market.application.parameter.view.dto.response.GetParametersByIdResponseDTO;
import com.bgs.market.application.parameter.view.dto.response.UpdateParameterResponseDTO;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Class for ParameterServiceImpl.
 */
@Service
@AllArgsConstructor
public class ParameterServiceImpl implements ParameterService {
    /**
     * Instantiating repositories.
     */
    private ParameterRepository parameterRepository;

    /**
     * Get list of parameters.
     *
     * @return parameters
     */
    @Override
    public GetAllParametersResponseDTO getAllParameters() {
        // Assign value and find all parameters.
        GetAllParametersResponseDTO responseDTO = new GetAllParametersResponseDTO();
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setParameters(parameterRepository.findAll());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Get list of parameters by parameter type.
     *
     * @param type represents parameter type
     * @return parameters
     */
    @Override
    public GetAllParametersResponseDTO getAllParametersByParameterType(String type) {
        // Show the request in the console, assign value and find all families by parameter type.
        System.out.println("request = " + new Gson().toJson(type));
        GetAllParametersResponseDTO responseDTO = new GetAllParametersResponseDTO();
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setParameters(parameterRepository.getAllParametersByTypeQuery(type));

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Get parameter by id.
     *
     * @param parameterId represents parameterId
     * @return parameter
     */
    @Override
    public GetParametersByIdResponseDTO getParameterById(Long parameterId) {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(parameterId));
        GetParametersByIdResponseDTO responseDTO = new GetParametersByIdResponseDTO();

        // Validate if parameter exists.
        Optional<Parameter> optionalParameter = parameterRepository.findById(parameterId);
        if (optionalParameter.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The parameter doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Assign values.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setParameter(optionalParameter.get());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Create parameter.
     *
     * @param request represents CreateParameterRequestDTO
     * @return parameter
     */
    @Override
    public CreateParameterResponseDTO createParameter(CreateParameterRequestDTO request) {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(request));
        CreateParameterResponseDTO responseDTO = new CreateParameterResponseDTO();

        // Assign values and save.
        Parameter parameter = new Parameter();
        parameter.setParameterType(request.getParameterType());
        parameter.setValue(request.getValue());
        parameter.setValueString1(request.getValueString1());
        parameter.setValueString2(request.getValueString2());
        parameter.setValueString3(request.getValueString3());
        parameter.setValueInt1(request.getValueInt1());
        parameter.setValueInt2(request.getValueInt2());
        parameter.setValueInt3(request.getValueInt3());
        parameter.setValueDouble1(request.getValueDouble1());
        parameter.setValueDouble2(request.getValueDouble2());
        parameter.setValueDouble3(request.getValueDouble3());
        Parameter parameterCreated = parameterRepository.save(parameter);

        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setParameter(parameterCreated);

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Update parameter.
     *
     * @param request     represents UpdateParameterRequestDTO
     * @param parameterId represents parameterId
     * @return parameter
     */
    @Override
    public UpdateParameterResponseDTO updateParameter(UpdateParameterRequestDTO request,
                                                      Long parameterId) {
        // Show the request in the console
        System.out.println("request = " + new Gson().toJson(request));
        UpdateParameterResponseDTO responseDTO = new UpdateParameterResponseDTO();

        // Validate if parameter exists
        Optional<Parameter> optionalParameter = parameterRepository.findById(parameterId);
        if (optionalParameter.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The parameter doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Assign values and save.
        Parameter existingParameter = optionalParameter.get();
        existingParameter.setParameterType(request.getParameterType());
        existingParameter.setValue(request.getValue());
        existingParameter.setState(request.getState());
        existingParameter.setValueString1(request.getValueString1());
        existingParameter.setValueString2(request.getValueString2());
        existingParameter.setValueString3(request.getValueString3());
        existingParameter.setValueInt1(request.getValueInt1());
        existingParameter.setValueInt2(request.getValueInt2());
        existingParameter.setValueInt3(request.getValueInt3());
        existingParameter.setValueDouble1(request.getValueDouble1());
        existingParameter.setValueDouble2(request.getValueDouble2());
        existingParameter.setValueDouble3(request.getValueDouble3());
        Parameter parameter = parameterRepository.save(existingParameter);

        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setParameter(parameter);

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }
}
