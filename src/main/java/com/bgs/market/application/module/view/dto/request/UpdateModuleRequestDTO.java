package com.bgs.market.application.module.view.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

/**
 * Class for UpdateModuleRequestDTO.
 */
@Getter
@Setter
public class UpdateModuleRequestDTO {

    @NotBlank(message = "moduleName should not be null")
    private String moduleName;

    @Range(min = 0, max = 1, message = "state must be 0 or 1")
    private Integer state;

}
