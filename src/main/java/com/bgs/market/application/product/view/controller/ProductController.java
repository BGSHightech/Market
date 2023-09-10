package com.bgs.market.application.product.view.controller;

import com.bgs.market.application.product.service.ProductService;
import com.bgs.market.application.product.view.dto.request.CreateProductRequestDTO;
import com.bgs.market.application.product.view.dto.request.UpdateProductRequestDTO;
import com.bgs.market.application.product.view.dto.response.CreateProductResponseDTO;
import com.bgs.market.application.product.view.dto.response.GetAllProductsResponseDTO;
import com.bgs.market.application.product.view.dto.response.UpdateProductResponseDTO;
import com.bgs.market.exception.Exception;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class for ProductController.
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/product")
public class ProductController {
    private ProductService productService;

    /**
     * Get list of products.
     *
     * @return products
     */
    @GetMapping()
    GetAllProductsResponseDTO getAllProducts() throws Exception {
        return productService.getAllProducts();
    }

    /**
     * Create product.
     *
     * @param request represents CreateProductRequestDTO
     * @return product
     */
    @PostMapping()
    CreateProductResponseDTO createProduct(@RequestBody CreateProductRequestDTO request) throws Exception {
        return productService.createProduct(request);
    }

    /**
     * Update product.
     *
     * @param productId represents productId
     * @param request   represents UpdateProductRequestDTO
     * @return product
     */
    @PutMapping("{productId}")
    UpdateProductResponseDTO updateProduct(@PathVariable("productId") Long productId,
                                           @RequestBody UpdateProductRequestDTO request) throws Exception {
        request.setProductId(productId);
        return productService.updateProduct(request);
    }
}
