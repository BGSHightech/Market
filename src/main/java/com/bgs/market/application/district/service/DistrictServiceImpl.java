package com.bgs.market.application.district.service;

import com.bgs.market.application.district.persistence.District;
import com.bgs.market.application.district.persistence.DistrictRepository;
import com.bgs.market.application.district.view.dto.response.GetAllDistrictsResponseDTO;
import com.bgs.market.application.district.view.dto.response.GetDistrictByIdResponseDTO;
import com.bgs.market.exception.Exception;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Class for DistrictServiceImpl.
 */
@Service
@AllArgsConstructor
public class DistrictServiceImpl implements DistrictService {
    /**
     * Instantiating repositories.
     */
    DistrictRepository districtRepository;

    /**
     * Get list of districts.
     *
     * @return districts
     */
    @Override
    public GetAllDistrictsResponseDTO getAllDistricts() throws Exception {
        // Assign value and find all districts.
        GetAllDistrictsResponseDTO responseDTO = new GetAllDistrictsResponseDTO();
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setDistricts(districtRepository.findAll());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Get list of districts by id.
     *
     * @param districtId represents districtId
     * @return districts
     */
    @Override
    public GetDistrictByIdResponseDTO getDistrictById(String districtId) throws Exception {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(districtId));
        GetDistrictByIdResponseDTO responseDTO = new GetDistrictByIdResponseDTO();

        // Verify if district exists
        Optional<District> optionalDistrict = districtRepository.findById(districtId);
        if (optionalDistrict.isEmpty()) {
            responseDTO.setStatusCode("02");
            responseDTO.setStatusMessage("The district doesn't exists");
            return responseDTO;
        }

        // Assign values.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setDistrict(optionalDistrict.get());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }
}
