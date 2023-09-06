package com.bgs.market.view.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBrandRequestDTO {
    private Long brandId;
    private String brandName;
    private Integer state;
}
