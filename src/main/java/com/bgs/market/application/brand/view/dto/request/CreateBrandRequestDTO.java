package com.bgs.market.application.brand.view.dto.request;

import lombok.Getter;
import lombok.Setter;

/**
 * Class for CreateBrandRequestDTO.
 */
@Getter
@Setter
public class CreateBrandRequestDTO {
    private String brandName;
    private Long subFamilyId;
}
