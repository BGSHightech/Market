package com.bgs.market.application.subfamily.view.dto.request;

import lombok.Getter;
import lombok.Setter;

/**
 * Class for CreateSubFamilyRequestDTO.
 */
@Getter
@Setter
public class CreateSubFamilyRequestDTO {
    private String subFamilyName;
    private Long familyId;
}
