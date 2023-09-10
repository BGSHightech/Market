package com.bgs.market.application.district.view.dto.response;

import com.bgs.market.application.district.persistence.District;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Class for GetAllDistrictsResponseDTO.
 */
@Getter
@Setter
public class GetAllDistrictsResponseDTO extends BaseResponseDTO {
    private List<District> districts;
}
