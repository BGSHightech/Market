package com.bgs.market.application.brand.view.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

/**
 * Class for UpdateBrandRequestDTO.
 */
@Getter
@Setter
public class UpdateBrandRequestDTO {
    @NotBlank(message = "brandName should not be null")
    private String brandName;

    @NotNull(message = "subFamilyId should not be null")
    @Min(message = "subFamilyId should be greater than 0", value = 1L)
    private Long subFamilyId;

    @Range(min = 0, max = 1, message = "state must be 0 or 1")
    private Integer state;
}
