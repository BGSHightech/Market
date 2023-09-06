package com.bgs.market.view.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductUnitRequestDTO {
    private Long productUnitId;
    private String productUnitName;
    private Integer state;
}
