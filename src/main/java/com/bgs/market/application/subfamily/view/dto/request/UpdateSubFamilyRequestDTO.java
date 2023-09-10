package com.bgs.market.application.subfamily.view.dto.request;

import lombok.Getter;
import lombok.Setter;

/**
 * Class for UpdateSubFamilyRequestDTO.
 */
@Getter
@Setter
public class UpdateSubFamilyRequestDTO {
    private Long subFamilyId;
    private String subFamilyName;
    private Long familyId;
    private Integer state;
}
