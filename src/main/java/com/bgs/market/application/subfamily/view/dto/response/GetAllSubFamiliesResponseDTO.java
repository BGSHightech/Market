package com.bgs.market.application.subfamily.view.dto.response;

import com.bgs.market.application.subfamily.persistence.SubFamily;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Class for GetAllSubFamiliesResponseDTO.
 */
@Getter
@Setter
public class GetAllSubFamiliesResponseDTO extends BaseResponseDTO {
    private List<SubFamily> subFamilies;
}
