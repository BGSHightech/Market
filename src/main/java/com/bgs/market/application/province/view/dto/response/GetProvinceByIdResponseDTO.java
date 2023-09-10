package com.bgs.market.application.province.view.dto.response;

import com.bgs.market.application.province.persistence.Province;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for GetProvinceByIdResponseDTO.
 */
@Getter
@Setter
public class GetProvinceByIdResponseDTO extends BaseResponseDTO {
    private Province province;
}
