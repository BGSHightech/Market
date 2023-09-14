package com.bgs.market.application.subfamily.view.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for CreateSubFamilyRequestDTO.
 */
@Getter
@Setter
public class CreateSubFamilyRequestDTO {
    @NotBlank(message = "subFamilyName should not be null")
    private String subFamilyName;

    @NotNull(message = "familyId should not be null")
    @Min(message = "familyId should be greater than 0", value = 1L)
    private Long familyId;
}
