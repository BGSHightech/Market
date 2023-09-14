package com.bgs.market.application.productunit.view.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for CreateProductUnitRequestDTO.
 */
@Getter
@Setter
public class CreateProductUnitRequestDTO {
    @NotBlank(message = "productUnitName should not be null")
    private String productUnitName;
}
