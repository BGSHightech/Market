package com.bgs.market.application.option.service;

import com.bgs.market.application.option.persistence.Option;
import com.bgs.market.application.option.persistence.OptionRepository;
import com.bgs.market.application.option.view.dto.request.CreateOptionRequestDTO;
import com.bgs.market.application.option.view.dto.request.UpdateOptionRequestDTO;
import com.bgs.market.application.option.view.dto.response.CreateOptionResponseDTO;
import com.bgs.market.application.option.view.dto.response.GetAllOptionsResponseDTO;
import com.bgs.market.application.option.view.dto.response.GetOptionByIdResponseDTO;
import com.bgs.market.application.option.view.dto.response.UpdateOptionResponseDTO;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Class for OptionServiceImpl.
 */
@Service
@AllArgsConstructor
public class OptionServiceImpl implements OptionService {
    /**
     * Instantiating repositories.
     */
    OptionRepository optionRepository;

    /**
     * Get list of options.
     *
     * @return options
     */
    @Override
    public GetAllOptionsResponseDTO getAllOptions() throws Exception {
        // Assign value and find all options.
        GetAllOptionsResponseDTO responseDTO = new GetAllOptionsResponseDTO();
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setOptions(optionRepository.findAll());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }


    /**
     * Get option by id.
     *
     * @param optionId represents optionId
     * @return option
     */
    @Override
    public GetOptionByIdResponseDTO getOptionById(Long optionId) throws Exception {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(optionId));
        GetOptionByIdResponseDTO responseDTO = new GetOptionByIdResponseDTO();

        // Validate if option exists.
        Optional<Option> optionalOption = optionRepository.findById(optionId);
        if (optionalOption.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The option doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Assign values.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setOption(optionalOption.get());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Create option.
     *
     * @param request represents CreateOptionRequestDTO
     * @return option
     */
    @Override
    public CreateOptionResponseDTO createOption(CreateOptionRequestDTO request) throws Exception {
        // Show the request in the console
        System.out.println("request = " + new Gson().toJson(request));
        CreateOptionResponseDTO responseDTO = new CreateOptionResponseDTO();

        // Assign values and save.
        Option option = new Option();
        option.setOptionName(request.getOptionName());
        Option optionCreated = optionRepository.save(option);

        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setOption(optionCreated);

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Update option.
     *
     * @param request  represents UpdateOptionRequestDTO
     * @param optionId represents optionId
     * @return option
     */
    @Override
    public UpdateOptionResponseDTO updateOption(UpdateOptionRequestDTO request,
                                                Long optionId) throws Exception {
        // Show the request in the console
        System.out.println("request = " + new Gson().toJson(request));
        UpdateOptionResponseDTO responseDTO = new UpdateOptionResponseDTO();

        // Validate if option exists.
        Optional<Option> optionalOption = optionRepository.findById(optionId);
        if (optionalOption.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The option doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Assign values and save.
        Option existingOption = optionalOption.get();
        existingOption.setOptionName(request.getOptionName());
        existingOption.setState(request.getState());
        Option option = optionRepository.save(existingOption);

        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setOption(option);

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }
}
