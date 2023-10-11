package com.bgs.market.application.option.view.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for CreateOptionRequestDTO.
 */
@Getter
@Setter
public class CreateOptionRequestDTO {
    @NotBlank(message = "optionName should not be null")
    private String optionName;
}
