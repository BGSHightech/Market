package com.bgs.market.application.product.view.dto.request;

import lombok.Getter;
import lombok.Setter;

/**
 * Class for CreateProductRequestDTO.
 */
@Getter
@Setter
public class CreateProductRequestDTO {
    private Long brandId;
    private String nameForSale;
    private String nameForPurchase;
    private Long productType;
    private Long unitType;
    private Long mainProductUnitId;
    private Long secondaryProductUnitId;
    private Float factor;
    private Long igvAffectation;
    private String imageProduct;
}
