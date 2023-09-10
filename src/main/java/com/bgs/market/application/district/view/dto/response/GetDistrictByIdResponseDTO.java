package com.bgs.market.application.district.view.dto.response;

import com.bgs.market.application.district.persistence.District;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for GetDistrictByIdResponseDTO.
 */
@Getter
@Setter
public class GetDistrictByIdResponseDTO extends BaseResponseDTO {
    private District district;
}
