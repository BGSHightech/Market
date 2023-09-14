package com.bgs.market.application.family.view.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

/**
 * Class for UpdateFamilyRequestDTO.
 */
@Getter
@Setter
public class UpdateFamilyRequestDTO {
    @NotBlank(message = "familyName should not be null")
    private String familyName;

    @Range(min = 0, max = 1, message = "state must be 0 or 1")
    private Integer state;

    @NotNull(message = "categoryId should not be null")
    @Min(message = "categoryId should be greater than 0", value = 1L)
    private Long categoryId;
}
