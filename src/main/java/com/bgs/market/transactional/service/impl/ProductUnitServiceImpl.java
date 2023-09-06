package com.bgs.market.transactional.service.impl;

import com.bgs.market.persistence.domain.ProductUnit;
import com.bgs.market.persistence.repository.ProductUnitRepository;
import com.bgs.market.transactional.service.ProductUnitService;
import com.bgs.market.view.dto.request.CreateProductUnitRequestDTO;
import com.bgs.market.view.dto.request.UpdateProductUnitRequestDTO;
import com.bgs.market.view.dto.response.CreateProductUnitResponseDTO;
import com.bgs.market.view.dto.response.GetAllProductUnitsResponseDTO;
import com.bgs.market.view.dto.response.UpdateProductUnitResponseDTO;
import com.bgs.market.view.exception.Exception;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductUnitServiceImpl implements ProductUnitService {
    private ProductUnitRepository productUnitRepository;

    @Override
    public CreateProductUnitResponseDTO createProductUnit(CreateProductUnitRequestDTO request) throws Exception {
        System.out.println("request = " + new Gson().toJson(request));

        ProductUnit productUnit = new ProductUnit();
        productUnit.setProductUnitName(request.getProductUnitName());
        ProductUnit productUnitCreated = productUnitRepository.save(productUnit);

        CreateProductUnitResponseDTO responseDTO = new CreateProductUnitResponseDTO();
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setProductUnit(productUnitCreated);
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    @Override
    public UpdateProductUnitResponseDTO updateProductUnit(UpdateProductUnitRequestDTO request) throws Exception {
        System.out.println("request = " + new Gson().toJson(request));

        ProductUnit existingProductUnit = productUnitRepository.findById(request.getProductUnitId()).get();
        existingProductUnit.setProductUnitId(request.getProductUnitId());
        existingProductUnit.setProductUnitName(request.getProductUnitName());
        existingProductUnit.setState(request.getState());
        ProductUnit productUnit = productUnitRepository.save(existingProductUnit);

        UpdateProductUnitResponseDTO responseDTO = new UpdateProductUnitResponseDTO();
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setProductUnit(productUnit);
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    @Override
    public GetAllProductUnitsResponseDTO getAllProductUnits() throws Exception {
        GetAllProductUnitsResponseDTO responseDTO = new GetAllProductUnitsResponseDTO();
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setProductUnits(productUnitRepository.findAll());
        System.out.println("_response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }
}
