package com.bgs.market.application.product.view.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

/**
 * Class for UpdateProductRequestDTO.
 */
@Getter
@Setter
public class UpdateProductRequestDTO {
    @NotNull(message = "brandId should not be null")
    @Min(message = "brandId should be greater than 0", value = 1L)
    private Long brandId;

    @NotBlank(message = "nameForSale should not be null")
    private String nameForSale;

    @NotBlank(message = "nameForPurchase should not be null")
    private String nameForPurchase;

    @NotNull(message = "productType should not be null")
    @Min(message = "productType should be greater than 0", value = 1L)
    private Long productType;

    @NotNull(message = "unitType should not be null")
    @Min(message = "unitType should be greater than 0", value = 1L)
    private Long unitType;

    @NotNull(message = "mainProductUnitId should not be null")
    @Min(message = "mainProductUnitId should be greater than 0", value = 1L)
    private Long mainProductUnitId;

    @NotNull(message = "secondaryProductUnitId should not be null")
    @Min(message = "secondaryProductUnitId should be greater than 0", value = 1L)
    private Long secondaryProductUnitId;

    @Min(message = "factor should be greater than 0", value = 1L)
    private Float factor;

    @NotNull(message = "igvAffectation should not be null")
    @Min(message = "igvAffectation should be greater than 0", value = 1L)
    private Long igvAffectation;

    private String imageProduct;

    @Range(min = 0, max = 1, message = "state must be 0 or 1")
    private Integer state;
}
