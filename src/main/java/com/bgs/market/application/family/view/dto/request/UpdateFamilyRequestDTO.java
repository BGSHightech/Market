package com.bgs.market.application.family.view.dto.request;

import lombok.Getter;
import lombok.Setter;

/**
 * Class for UpdateFamilyRequestDTO.
 */
@Getter
@Setter
public class UpdateFamilyRequestDTO {
    private Long familyId;
    private String familyName;
    private Integer state;
    private Long categoryId;
}
