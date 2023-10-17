package com.bgs.market.application.family.view.dto.response;

import com.bgs.market.application.family.persistence.Family;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Class for GetAllFamiliesByCategoryIdDTO.
 */
@Getter
@Setter
public class GetAllFamiliesByCategoryIdResponseDTO extends BaseResponseDTO {
    private List<Family> families;
}
