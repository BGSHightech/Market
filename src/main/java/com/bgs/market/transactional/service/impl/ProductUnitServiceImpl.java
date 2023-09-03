package com.bgs.market.transactional.service.impl;

import com.bgs.market.persistence.repository.ParameterRepository;
import com.bgs.market.persistence.repository.ProductUnitRepository;
import com.bgs.market.transactional.service.ProductUnitService;
import com.bgs.market.view.dto.response.GetAllParametersResponseDTO;
import com.bgs.market.view.dto.response.GetAllProductUnitResponseDTO;
import com.bgs.market.view.exception.Exception;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ProductUnitServiceImpl implements ProductUnitService {

    private ProductUnitRepository productUnitRepository;

    @Override
    public GetAllProductUnitResponseDTO getAllProductUnits() throws Exception {
        GetAllProductUnitResponseDTO responseDTO = new GetAllProductUnitResponseDTO();
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setProductUnits(productUnitRepository.findAll());

        System.out.println("_response = " + new Gson().toJson(responseDTO));

        return responseDTO;
    }
}
