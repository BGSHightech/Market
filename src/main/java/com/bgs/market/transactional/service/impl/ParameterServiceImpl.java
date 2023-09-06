package com.bgs.market.transactional.service.impl;

import com.bgs.market.persistence.domain.Parameter;
import com.bgs.market.persistence.repository.ParameterRepository;
import com.bgs.market.transactional.service.ParameterService;
import com.bgs.market.view.dto.request.CreateParameterRequestDTO;
import com.bgs.market.view.dto.request.UpdateParameterRequestDTO;
import com.bgs.market.view.dto.response.CreateParameterResponseDTO;
import com.bgs.market.view.dto.response.GetAllParametersResponseDTO;
import com.bgs.market.view.dto.response.UpdateParameterResponseDTO;
import com.bgs.market.view.exception.Exception;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParameterServiceImpl implements ParameterService {
    private ParameterRepository parameterRepository;

    @Override
    public CreateParameterResponseDTO createParameter(CreateParameterRequestDTO request) throws Exception {
        System.out.println("request = " + new Gson().toJson(request));

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

        CreateParameterResponseDTO responseDTO = new CreateParameterResponseDTO();
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setParameter(parameterCreated);
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    @Override
    public UpdateParameterResponseDTO updateParameter(UpdateParameterRequestDTO request) {
        System.out.println("request = " + new Gson().toJson(request));

        Parameter existingParameter = parameterRepository.findById(request.getParameterId()).get();
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

        UpdateParameterResponseDTO responseDTO = new UpdateParameterResponseDTO();
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setParameter(parameter);
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    @Override
    public GetAllParametersResponseDTO getAllParameters() throws Exception {
        GetAllParametersResponseDTO responseDTO = new GetAllParametersResponseDTO();
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setParameters(parameterRepository.findAll());
        System.out.println("_response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    @Override
    public GetAllParametersResponseDTO getAllParametersByParameterType(String type) throws Exception {
        GetAllParametersResponseDTO responseDTO = new GetAllParametersResponseDTO();
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setParameters(parameterRepository.getAllParametersByTypeQuery(type));
        System.out.println("_response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }
}
