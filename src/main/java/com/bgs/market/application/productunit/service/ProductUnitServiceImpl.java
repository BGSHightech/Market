package com.bgs.market.application.productunit.service;

import com.bgs.market.application.productunit.persistence.ProductUnit;
import com.bgs.market.application.productunit.persistence.ProductUnitRepository;
import com.bgs.market.application.productunit.view.dto.request.CreateProductUnitRequestDTO;
import com.bgs.market.application.productunit.view.dto.request.UpdateProductUnitRequestDTO;
import com.bgs.market.application.productunit.view.dto.response.CreateProductUnitResponseDTO;
import com.bgs.market.application.productunit.view.dto.response.GetAllProductUnitsResponseDTO;
import com.bgs.market.application.productunit.view.dto.response.GetProductUnitByIdResponseDTO;
import com.bgs.market.application.productunit.view.dto.response.UpdateProductUnitResponseDTO;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Class for ProductUnitServiceImpl.
 */
@Service
@AllArgsConstructor
public class ProductUnitServiceImpl implements ProductUnitService {
    /**
     * Instantiating repositories.
     */
    private ProductUnitRepository productUnitRepository;

    /**
     * Get list of product units.
     *
     * @return product units
     */
    @Override
    public GetAllProductUnitsResponseDTO getAllProductUnits() {
        // Assign value and find all product units.
        GetAllProductUnitsResponseDTO responseDTO = new GetAllProductUnitsResponseDTO();
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setProductUnits(productUnitRepository.findAll());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Get product unit by id.
     *
     * @param productUnitId represents productUnitId
     * @return product unit
     */
    @Override
    public GetProductUnitByIdResponseDTO getProductUnitById(Long productUnitId) {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(productUnitId));
        GetProductUnitByIdResponseDTO responseDTO = new GetProductUnitByIdResponseDTO();

        // Validate if product unit exists
        Optional<ProductUnit> optionalProductUnit = productUnitRepository.findById(productUnitId);
        if (optionalProductUnit.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The product unit doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Assign values.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setProductUnit(optionalProductUnit.get());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Create product unit.
     *
     * @param request represents CreateProductUnitRequestDTO
     * @return product unit
     */
    @Override
    public CreateProductUnitResponseDTO createProductUnit(CreateProductUnitRequestDTO request) {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(request));
        CreateProductUnitResponseDTO responseDTO = new CreateProductUnitResponseDTO();

        // Assign values and save.
        ProductUnit productUnit = new ProductUnit();
        productUnit.setProductUnitName(request.getProductUnitName());
        ProductUnit productUnitCreated = productUnitRepository.save(productUnit);

        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setProductUnit(productUnitCreated);

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Update product unit.
     *
     * @param request       represents UpdateProductUnitRequestDTO
     * @param productUnitId represents productUnitId
     * @return product unit
     */
    @Override
    public UpdateProductUnitResponseDTO updateProductUnit(UpdateProductUnitRequestDTO request,
                                                          Long productUnitId) {
        // Show the request in the console
        System.out.println("request = " + new Gson().toJson(request));
        UpdateProductUnitResponseDTO responseDTO = new UpdateProductUnitResponseDTO();

        // Validate if product unit exists
        Optional<ProductUnit> optionalProductUnit = productUnitRepository.findById(productUnitId);
        if (optionalProductUnit.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The product unit doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Assign values and save.
        ProductUnit existingProductUnit = optionalProductUnit.get();
        existingProductUnit.setProductUnitName(request.getProductUnitName());
        existingProductUnit.setState(request.getState());
        ProductUnit productUnit = productUnitRepository.save(existingProductUnit);

        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setProductUnit(productUnit);

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

}
