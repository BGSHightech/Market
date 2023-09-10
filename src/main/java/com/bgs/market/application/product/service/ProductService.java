package com.bgs.market.application.product.service;

import com.bgs.market.application.product.view.dto.request.CreateProductRequestDTO;
import com.bgs.market.application.product.view.dto.request.UpdateProductRequestDTO;
import com.bgs.market.application.product.view.dto.response.CreateProductResponseDTO;
import com.bgs.market.application.product.view.dto.response.GetAllProductsResponseDTO;
import com.bgs.market.application.product.view.dto.response.UpdateProductResponseDTO;
import com.bgs.market.exception.Exception;

/**
 * Class for ProductService.
 */
public interface ProductService {
    /**
     * Get list of products.
     *
     * @return products
     */
    GetAllProductsResponseDTO getAllProducts() throws Exception;

    /**
     * Create product.
     *
     * @param request represents CreateProductRequestDTO
     * @return product
     */
    CreateProductResponseDTO createProduct(CreateProductRequestDTO request) throws Exception;

    /**
     * Update product.
     *
     * @param request represents UpdateProductRequestDTO
     * @return product
     */
    UpdateProductResponseDTO updateProduct(UpdateProductRequestDTO request) throws Exception;
}
