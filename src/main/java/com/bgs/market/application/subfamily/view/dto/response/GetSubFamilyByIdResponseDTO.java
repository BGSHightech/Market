package com.bgs.market.application.subfamily.view.dto.response;

import com.bgs.market.application.subfamily.persistence.SubFamily;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for GetSubFamilyByIdResponseDTO.
 */
@Getter
@Setter
public class GetSubFamilyByIdResponseDTO extends BaseResponseDTO {
    private SubFamily subFamily;
}
