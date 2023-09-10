package com.bgs.market.application.family.view.dto.response;

import com.bgs.market.application.family.persistence.Family;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Class for GetAllFamiliesResponseDTO.
 */
@Getter
@Setter
public class GetAllFamiliesResponseDTO extends BaseResponseDTO {
    private List<Family> families;
}
