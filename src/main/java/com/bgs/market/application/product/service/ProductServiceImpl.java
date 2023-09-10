package com.bgs.market.application.product.service;

import com.bgs.market.application.brand.persistence.Brand;
import com.bgs.market.application.brand.persistence.BrandRepository;
import com.bgs.market.application.parameter.persistence.Parameter;
import com.bgs.market.application.parameter.persistence.ParameterRepository;
import com.bgs.market.application.product.persistence.Product;
import com.bgs.market.application.product.persistence.ProductRepository;
import com.bgs.market.application.product.view.dto.request.CreateProductRequestDTO;
import com.bgs.market.application.product.view.dto.request.UpdateProductRequestDTO;
import com.bgs.market.application.product.view.dto.response.CreateProductResponseDTO;
import com.bgs.market.application.product.view.dto.response.GetAllProductsResponseDTO;
import com.bgs.market.application.product.view.dto.response.UpdateProductResponseDTO;
import com.bgs.market.exception.Exception;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Class for ProductServiceImpl.
 */
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    /**
     * Instantiating repositories.
     */
    ProductRepository productRepository;
    BrandRepository brandRepository;
    ParameterRepository parameterRepository;

    /**
     * Get list of products.
     *
     * @return products
     */
    @Override
    public GetAllProductsResponseDTO getAllProducts() throws Exception {
        // Assign value and find all products.
        GetAllProductsResponseDTO responseDTO = new GetAllProductsResponseDTO();
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setProducts(productRepository.findAll());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Create product.
     *
     * @param request represents CreateProductRequestDTO
     * @return product
     */
    @Override
    public CreateProductResponseDTO createProduct(CreateProductRequestDTO request) throws Exception {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(request));
        CreateProductResponseDTO responseDTO = new CreateProductResponseDTO();

        // Validate if brand exists
        Optional<Brand> optionalBrand = brandRepository.findById(request.getBrandId());
        if (optionalBrand.isEmpty()) {
            responseDTO.setStatusCode("02");
            responseDTO.setStatusMessage("The brand doesn't exists");
            return responseDTO;
        }

        // Validate if product type exists
        Optional<Parameter> optionalProductType = parameterRepository.findById(request.getProductType());
        if (optionalProductType.isEmpty()) {
            responseDTO.setStatusCode("02");
            responseDTO.setStatusMessage("The product type doesn't exists");
            return responseDTO;
        }

        // Validate if unit type exists
        Optional<Parameter> optionalUnitType = parameterRepository.findById(request.getUnitType());
        if (optionalUnitType.isEmpty()) {
            responseDTO.setStatusCode("02");
            responseDTO.setStatusMessage("The unit type doesn't exists");
            return responseDTO;
        }

        // Validate if main product unit exists
        Optional<Parameter> optionalMainProductUnit = parameterRepository.findById(request.getMainProductUnitId());
        if (optionalMainProductUnit.isEmpty()) {
            responseDTO.setStatusCode("02");
            responseDTO.setStatusMessage("The main product unit doesn't exists");
            return responseDTO;
        }

        // Validate if secondary product unit exists
        Optional<Parameter> optionalSecondaryProductUnit = parameterRepository.findById(request.getSecondaryProductUnitId());
        if (optionalSecondaryProductUnit.isEmpty()) {
            responseDTO.setStatusCode("02");
            responseDTO.setStatusMessage("The secondary product unit doesn't exists");
            return responseDTO;
        }

        // Validate if igv affectation exists
        Optional<Parameter> optionalIgvAffectation = parameterRepository.findById(request.getIgvAffectation());
        if (optionalIgvAffectation.isEmpty()) {
            responseDTO.setStatusCode("02");
            responseDTO.setStatusMessage("The igv affectation doesn't exists");
            return responseDTO;
        }

        // Assign values and save.
        Product product = new Product();
        product.setBrandId(request.getBrandId());
        product.setNameForSale(request.getNameForSale());
        product.setNameForPurchase(request.getNameForPurchase());
        product.setProductType(request.getProductType());
        product.setUnitType(request.getUnitType());
        product.setMainProductUnitId(request.getMainProductUnitId());
        product.setSecondaryProductUnitId(request.getSecondaryProductUnitId());
        product.setFactor(request.getFactor());
        product.setIgvAffectation(request.getIgvAffectation());
        product.setImageProduct(request.getImageProduct());
        Product productCreated = productRepository.save(product);

        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setProduct(productCreated);

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Update product.
     *
     * @param request represents UpdateProductRequestDTO
     * @return product
     */
    @Override
    public UpdateProductResponseDTO updateProduct(UpdateProductRequestDTO request) throws Exception {
        // Show the request in the console
        System.out.println("request = " + new Gson().toJson(request));
        UpdateProductResponseDTO responseDTO = new UpdateProductResponseDTO();

        // Validate if product exists
        Optional<Product> optionalProduct = productRepository.findById(request.getProductId());
        if (optionalProduct.isEmpty()) {
            responseDTO.setStatusCode("02");
            responseDTO.setStatusMessage("The product doesn't exists");
            return responseDTO;
        }

        // Validate if brand exists
        Optional<Brand> optionalBrand = brandRepository.findById(request.getBrandId());
        if (optionalBrand.isEmpty()) {
            responseDTO.setStatusCode("02");
            responseDTO.setStatusMessage("The brand doesn't exists");
            return responseDTO;
        }

        // Validate if product type exists
        Optional<Parameter> optionalProductType = parameterRepository.findById(request.getProductType());
        if (optionalProductType.isEmpty()) {
            responseDTO.setStatusCode("02");
            responseDTO.setStatusMessage("The product type doesn't exists");
            return responseDTO;
        }

        // Validate if unit type exists
        Optional<Parameter> optionalUnitType = parameterRepository.findById(request.getUnitType());
        if (optionalUnitType.isEmpty()) {
            responseDTO.setStatusCode("02");
            responseDTO.setStatusMessage("The unit type doesn't exists");
            return responseDTO;
        }

        // Validate if main product unit exists
        Optional<Parameter> optionalMainProductUnit = parameterRepository.findById(request.getMainProductUnitId());
        if (optionalMainProductUnit.isEmpty()) {
            responseDTO.setStatusCode("02");
            responseDTO.setStatusMessage("The main product unit doesn't exists");
            return responseDTO;
        }

        // Validate if secondary product unit exists
        Optional<Parameter> optionalSecondaryProductUnit = parameterRepository.findById(request.getSecondaryProductUnitId());
        if (optionalSecondaryProductUnit.isEmpty()) {
            responseDTO.setStatusCode("02");
            responseDTO.setStatusMessage("The secondary product unit doesn't exists");
            return responseDTO;
        }

        // Validate if igv affectation exists
        Optional<Parameter> optionalIgvAffectation = parameterRepository.findById(request.getIgvAffectation());
        if (optionalIgvAffectation.isEmpty()) {
            responseDTO.setStatusCode("02");
            responseDTO.setStatusMessage("The igv affectation doesn't exists");
            return responseDTO;
        }

        // Assign values and save.
        Product existingProduct = optionalProduct.get();
        existingProduct.setBrandId(request.getBrandId());
        existingProduct.setNameForSale(request.getNameForSale());
        existingProduct.setNameForPurchase(request.getNameForPurchase());
        existingProduct.setProductType(request.getProductType());
        existingProduct.setUnitType(request.getUnitType());
        existingProduct.setMainProductUnitId(request.getMainProductUnitId());
        existingProduct.setSecondaryProductUnitId(request.getSecondaryProductUnitId());
        existingProduct.setFactor(request.getFactor());
        existingProduct.setIgvAffectation(request.getIgvAffectation());
        existingProduct.setImageProduct(request.getImageProduct());
        existingProduct.setState(request.getState());
        Product product = productRepository.save(existingProduct);

        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setProduct(product);

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }
}
