package com.bgs.market.application.productunit.view.dto.response;

import com.bgs.market.application.productunit.persistence.ProductUnit;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for GetProductUnitByIdResponseDTO.
 */
@Getter
@Setter
public class GetProductUnitByIdResponseDTO extends BaseResponseDTO {
    private ProductUnit productUnit;
}
