package com.bgs.market.view.dto.response;

import com.bgs.market.persistence.domain.ProductUnit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductUnitResponseDTO extends BaseResponseDTO {
    private ProductUnit productUnit;
}
