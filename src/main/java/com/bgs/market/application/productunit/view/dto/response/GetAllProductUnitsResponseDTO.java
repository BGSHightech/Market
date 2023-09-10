package com.bgs.market.application.productunit.view.dto.response;

import com.bgs.market.application.productunit.persistence.ProductUnit;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Class for GetAllProductUnitsResponseDTO.
 */
@Getter
@Setter
public class GetAllProductUnitsResponseDTO extends BaseResponseDTO {
    private List<ProductUnit> productUnits;
}
