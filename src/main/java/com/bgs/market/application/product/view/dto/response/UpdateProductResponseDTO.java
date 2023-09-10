package com.bgs.market.application.product.view.dto.response;

import com.bgs.market.util.BaseResponseDTO;
import com.bgs.market.application.product.persistence.Product;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for UpdateProductResponseDTO.
 */
@Getter
@Setter
public class UpdateProductResponseDTO extends BaseResponseDTO {
    private Product product;
}
