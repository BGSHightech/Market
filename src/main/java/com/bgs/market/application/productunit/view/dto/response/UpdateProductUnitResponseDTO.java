package com.bgs.market.application.productunit.view.dto.response;

import com.bgs.market.application.productunit.persistence.ProductUnit;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for UpdateProductUnitResponseDTO.
 */
@Getter
@Setter
public class UpdateProductUnitResponseDTO extends BaseResponseDTO {
    private ProductUnit productUnit;
}
