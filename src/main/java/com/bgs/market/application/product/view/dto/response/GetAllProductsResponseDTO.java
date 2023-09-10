package com.bgs.market.application.product.view.dto.response;

import com.bgs.market.util.BaseResponseDTO;
import com.bgs.market.application.product.persistence.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Class for GetAllProductsResponseDTO.
 */
@Getter
@Setter
public class GetAllProductsResponseDTO extends BaseResponseDTO {
    private List<Product> products;
}
