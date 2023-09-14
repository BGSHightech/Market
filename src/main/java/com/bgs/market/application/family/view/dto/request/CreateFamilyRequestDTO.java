package com.bgs.market.application.family.view.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for CreateFamilyRequestDTO.
 */
@Getter
@Setter
public class CreateFamilyRequestDTO {
    @NotBlank(message = "familyName should not be null")
    private String familyName;

    @NotNull(message = "categoryId should not be null")
    @Min(message = "categoryId should be greater than 0", value = 1L)
    private Long categoryId;
}
