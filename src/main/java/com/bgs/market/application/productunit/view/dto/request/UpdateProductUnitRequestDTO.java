package com.bgs.market.application.productunit.view.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

/**
 * Class for UpdateProductUnitRequestDTO.
 */
@Getter
@Setter
public class UpdateProductUnitRequestDTO {
    @NotBlank(message = "productUnitName should not be null")
    private String productUnitName;

    @Range(min = 0, max = 1, message = "state must be 0 or 1")
    private Integer state;
}
