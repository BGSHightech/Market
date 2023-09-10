package com.bgs.market.application.brand.view.dto.response;

import com.bgs.market.application.brand.persistence.Brand;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Class for GetAllBrandsResponseDTO.
 */
@Getter
@Setter
public class GetAllBrandsResponseDTO extends BaseResponseDTO {
    private List<Brand> brands;
}
