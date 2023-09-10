package com.bgs.market.application.subfamily.view.dto.response;

import com.bgs.market.application.subfamily.persistence.SubFamily;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for UpdateSubFamilyResponseDTO.
 */
@Getter
@Setter
public class UpdateSubFamilyResponseDTO extends BaseResponseDTO {
    private SubFamily subFamily;
}
