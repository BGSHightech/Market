package com.bgs.market.application.family.view.dto.response;

import com.bgs.market.application.family.persistence.Family;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for GetFamilyByIdResponseDTO.
 */
@Getter
@Setter
public class GetFamilyByIdResponseDTO extends BaseResponseDTO {
    private Family family;
}
