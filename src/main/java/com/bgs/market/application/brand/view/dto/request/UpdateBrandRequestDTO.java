package com.bgs.market.application.brand.view.dto.request;

import lombok.Getter;
import lombok.Setter;

/**
 * Class for UpdateBrandRequestDTO.
 */
@Getter
@Setter
public class UpdateBrandRequestDTO {
    private Long brandId;
    private String brandName;
    private Long subFamilyId;
    private Integer state;
}
