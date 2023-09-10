package com.bgs.market.application.family.view.dto.response;

import com.bgs.market.application.family.persistence.Family;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for UpdateFamilyResponseDTO.
 */
@Getter
@Setter
public class UpdateFamilyResponseDTO extends BaseResponseDTO {
    private Family family;
}
