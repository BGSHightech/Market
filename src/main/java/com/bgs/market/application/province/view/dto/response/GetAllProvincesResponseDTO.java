package com.bgs.market.application.province.view.dto.response;

import com.bgs.market.application.province.persistence.Province;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Class for GetAllProvincesResponseDTO.
 */
@Getter
@Setter
public class GetAllProvincesResponseDTO extends BaseResponseDTO {
    private List<Province> provinces;
}
