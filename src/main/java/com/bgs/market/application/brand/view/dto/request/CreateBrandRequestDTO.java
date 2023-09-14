package com.bgs.market.application.brand.view.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for CreateBrandRequestDTO.
 */
@Getter
@Setter
public class CreateBrandRequestDTO {
    @NotBlank(message = "brandName should not be null")
    private String brandName;

    @NotNull(message = "subFamilyId should not be null")
    @Min(message = "subFamilyId should be greater than 0", value = 1L)
    private Long subFamilyId;
}
