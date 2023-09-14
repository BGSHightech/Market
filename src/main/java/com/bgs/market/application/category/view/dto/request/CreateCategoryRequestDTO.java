package com.bgs.market.application.category.view.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for CreateCategoryRequestDTO.
 */
@Getter
@Setter
public class CreateCategoryRequestDTO {
    @NotBlank(message = "categoryName should not be null")
    private String categoryName;
}
