package com.bgs.market.application.province.service;

import com.bgs.market.application.province.persistence.Province;
import com.bgs.market.application.province.persistence.ProvinceRepository;
import com.bgs.market.application.province.view.dto.response.GetAllProvincesResponseDTO;
import com.bgs.market.application.province.view.dto.response.GetProvinceByIdResponseDTO;
import com.bgs.market.exception.Exception;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Class for ProvinceServiceImpl.
 */
@Service
@AllArgsConstructor
public class ProvinceServiceImpl implements ProvinceService {
    /**
     * Class for ProductUnitServiceImpl.
     */
    ProvinceRepository provinceRepository;

    /**
     * Get list of provinces.
     *
     * @return provinces
     */
    @Override
    public GetAllProvincesResponseDTO getAllProvinces() throws Exception {
        // Assign value and find all provinces.
        GetAllProvincesResponseDTO responseDTO = new GetAllProvincesResponseDTO();
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setProvinces(provinceRepository.findAll());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Get list of provinces by id.
     *
     * @param provinceId represents provinceId
     * @return provinces
     */
    @Override
    public GetProvinceByIdResponseDTO getProvinceById(String provinceId) throws Exception {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(provinceId));
        GetProvinceByIdResponseDTO responseDTO = new GetProvinceByIdResponseDTO();

        // Verify if province exists
        Optional<Province> optionalProvince = provinceRepository.findById(provinceId);
        if (optionalProvince.isEmpty()) {
            responseDTO.setStatusCode("02");
            responseDTO.setStatusMessage("The province doesn't exists");
            return responseDTO;
        }

        // Assign values.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setProvince(optionalProvince.get());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }
}
