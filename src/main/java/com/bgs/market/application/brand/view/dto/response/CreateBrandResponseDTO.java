package com.bgs.market.application.brand.view.dto.response;

import com.bgs.market.application.brand.persistence.Brand;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for CreateBrandResponseDTO.
 */
@Getter
@Setter
public class CreateBrandResponseDTO extends BaseResponseDTO {
    private Brand brand;
}
