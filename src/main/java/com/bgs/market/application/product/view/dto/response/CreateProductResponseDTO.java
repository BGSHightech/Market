package com.bgs.market.application.product.view.dto.response;

import com.bgs.market.util.BaseResponseDTO;
import com.bgs.market.application.product.persistence.Product;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for CreateProductResponseDTO.
 */
@Getter
@Setter
public class CreateProductResponseDTO extends BaseResponseDTO {
    private Product product;
}
