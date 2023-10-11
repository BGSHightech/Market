package com.bgs.market.application.module.view.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for CreateModuleRequestDTO.
 */
@Getter
@Setter
public class CreateModuleRequestDTO {


    @NotBlank(message = "moduleName should not be null")
    private String moduleName;

}
