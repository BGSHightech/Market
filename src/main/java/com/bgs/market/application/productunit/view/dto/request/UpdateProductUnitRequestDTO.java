package com.bgs.market.application.productunit.view.dto.request;

import lombok.Getter;
import lombok.Setter;

/**
 * Class for UpdateProductUnitRequestDTO.
 */
@Getter
@Setter
public class UpdateProductUnitRequestDTO {
    private Long productUnitId;
    private String productUnitName;
    private Integer state;
}
