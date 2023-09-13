package com.bgs.market.application.product.view.dto.response;

import com.bgs.market.application.product.persistence.Product;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for GetProductById.
 */
@Getter
@Setter
public class GetProductByIdResponseDTO extends BaseResponseDTO {
    private Product product;
}
