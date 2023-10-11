package com.bgs.market.application.option.view.controller;

import com.bgs.market.application.option.service.OptionService;
import com.bgs.market.application.option.view.dto.request.CreateOptionRequestDTO;
import com.bgs.market.application.option.view.dto.request.UpdateOptionRequestDTO;
import com.bgs.market.application.option.view.dto.response.CreateOptionResponseDTO;
import com.bgs.market.application.option.view.dto.response.GetAllOptionsResponseDTO;
import com.bgs.market.application.option.view.dto.response.GetOptionByIdResponseDTO;
import com.bgs.market.application.option.view.dto.response.UpdateOptionResponseDTO;
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
 * Class for OptionController.
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/option")
public class OptionController {
    private OptionService optionService;

    /**
     * Get list of options.
     *
     * @return options
     */
    @GetMapping
    public GetAllOptionsResponseDTO getAllOptions() throws Exception {
        return optionService.getAllOptions();
    }

    /**
     * Get option by id.
     *
     * @param optionId represents optionId
     * @return option
     */
    @GetMapping("{optionId}")
    public GetOptionByIdResponseDTO getOptionById(@PathVariable("optionId") Long optionId) throws Exception {
        return optionService.getOptionById(optionId);
    }

    /**
     * Create option.
     *
     * @param request represents CreateOptionRequestDTO
     * @return option
     */

    @PostMapping
    public CreateOptionResponseDTO createOption(@Valid @RequestBody CreateOptionRequestDTO request) throws Exception {
        return optionService.createOption(request);
    }

    /**
     * Update option.
     *
     * @param optionId represents optionId
     * @param request  represents UpdateOptionRequestDTO
     * @return option
     */
    @PutMapping("{optionId}")
    public UpdateOptionResponseDTO updateOptionResponseDTO(@PathVariable("optionId") Long optionId,
                                                           @Valid @RequestBody UpdateOptionRequestDTO request) throws Exception {
        return optionService.updateOption(request, optionId);
    }
}
