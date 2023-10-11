package com.bgs.market.application.option.view.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

/**
 * Class for UpdateOptionRequestDTO.
 */
@Getter
@Setter
public class UpdateOptionRequestDTO {
    @NotBlank(message = "optionName should not be null")
    private String optionName;

    @Range(min = 0, max = 1, message = "state must be 0 or 1")
    private int state;
}
