package com.bgs.market.application.brand.view.dto.response;

import com.bgs.market.application.brand.persistence.Brand;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for UpdateBrandResponseDTO.
 */
@Getter
@Setter
public class UpdateBrandResponseDTO extends BaseResponseDTO {
    private Brand brand;
}
