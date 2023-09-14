package com.bgs.market.application.subfamily.view.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

/**
 * Class for UpdateSubFamilyRequestDTO.
 */
@Getter
@Setter
public class UpdateSubFamilyRequestDTO {
    @NotBlank(message = "subFamilyName should not be null")
    private String subFamilyName;

    @NotNull(message = "familyId should not be null")
    @Min(message = "familyId should be greater than 0", value = 1L)
    private Long familyId;

    @Range(min = 0, max = 1, message = "state must be 0 or 1")
    private Integer state;
}
