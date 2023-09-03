package com.bgs.market.view.dto.response;


import com.bgs.market.persistence.domain.ProductUnit;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetAllProductUnitResponseDTO extends BaseResponseDTO {
    private List<ProductUnit> productUnits;
}
