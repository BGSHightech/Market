package com.bgs.market.application.family.view.dto.request;

import lombok.Getter;
import lombok.Setter;

/**
 * Class for CreateFamilyRequestDTO.
 */
@Getter
@Setter
public class CreateFamilyRequestDTO {
    private String familyName;
    private Long categoryId;
}
