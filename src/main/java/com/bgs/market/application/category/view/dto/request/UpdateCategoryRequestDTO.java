package com.bgs.market.application.category.view.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

/**
 * Class for UpdateCategoryRequestDTO.
 */
@Getter
@Setter
public class UpdateCategoryRequestDTO {
    @NotBlank(message = "categoryName should not be null")
    private String categoryName;

    @Range(min = 0, max = 1, message = "state must be 0 or 1")
    private Integer state;
}
