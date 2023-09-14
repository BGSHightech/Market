package com.bgs.market.application.subfamily.service;

import com.bgs.market.application.family.persistence.Family;
import com.bgs.market.application.subfamily.persistence.SubFamily;
import com.bgs.market.application.family.persistence.FamilyRepository;
import com.bgs.market.application.subfamily.persistence.SubFamilyRepository;
import com.bgs.market.application.subfamily.view.dto.request.CreateSubFamilyRequestDTO;
import com.bgs.market.application.subfamily.view.dto.request.UpdateSubFamilyRequestDTO;
import com.bgs.market.application.subfamily.view.dto.response.CreateSubFamilyResponseDTO;
import com.bgs.market.application.subfamily.view.dto.response.GetAllSubFamiliesResponseDTO;
import com.bgs.market.application.subfamily.view.dto.response.GetSubFamilyByIdResponseDTO;
import com.bgs.market.application.subfamily.view.dto.response.UpdateSubFamilyResponseDTO;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Class for SubFamilyServiceImpl.
 */
@Service
@AllArgsConstructor
public class SubFamilyServiceImpl implements SubFamilyService {
    /**
     * Class for ProductUnitServiceImpl.
     */
    SubFamilyRepository subFamilyRepository;
    FamilyRepository familyRepository;

    /**
     * Get list of subfamilies.
     *
     * @return subfamilies
     */
    @Override
    public GetAllSubFamiliesResponseDTO getAllSubFamilies() {
        // Assign value and find all subfamilies.
        GetAllSubFamiliesResponseDTO responseDTO = new GetAllSubFamiliesResponseDTO();
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setSubFamilies(subFamilyRepository.findAll());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Get subfamily by id.
     *
     * @param subFamilyId represents subFamilyId
     * @return subfamily
     */
    @Override
    public GetSubFamilyByIdResponseDTO getSubFamilyById(Long subFamilyId) {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(subFamilyId));
        GetSubFamilyByIdResponseDTO responseDTO = new GetSubFamilyByIdResponseDTO();

        // Validate if subfamily exists.
        Optional<SubFamily> optionalSubFamily = subFamilyRepository.findById(subFamilyId);
        if (optionalSubFamily.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The subfamily doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Assign values.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setSubFamily(optionalSubFamily.get());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Create subfamily.
     *
     * @param request represents CreateSubFamilyRequestDTO
     * @return subfamilies
     */
    @Override
    public CreateSubFamilyResponseDTO createSubFamily(CreateSubFamilyRequestDTO request) {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(request));
        CreateSubFamilyResponseDTO responseDTO = new CreateSubFamilyResponseDTO();

        // Validate if family exists
        Optional<Family> optionalFamily = familyRepository.findById(request.getFamilyId());
        if (optionalFamily.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The family doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Assign values and save.
        SubFamily subFamily = new SubFamily();
        subFamily.setFamilyId(request.getFamilyId());
        subFamily.setSubFamilyName(request.getSubFamilyName());
        SubFamily subFamilyCreated = subFamilyRepository.save(subFamily);

        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setSubFamily(subFamilyCreated);

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Update subfamily.
     *
     * @param request     represents UpdateSubFamilyRequestDTO
     * @param subFamilyId represents subFamilyId
     * @return subfamily
     */
    @Override
    public UpdateSubFamilyResponseDTO updateSubFamily(UpdateSubFamilyRequestDTO request,
                                                      Long subFamilyId) {
        // Show the request in the console
        System.out.println("request = " + new Gson().toJson(request));
        UpdateSubFamilyResponseDTO responseDTO = new UpdateSubFamilyResponseDTO();

        // Validate if subFamily exists
        Optional<SubFamily> optionalSubFamily = subFamilyRepository.findById(subFamilyId);
        if (optionalSubFamily.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The subFamily doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Validate if family exists
        Optional<Family> optionalFamily = familyRepository.findById(request.getFamilyId());
        if (optionalFamily.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The family doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Assign values and save.
        SubFamily existingSubFamily = optionalSubFamily.get();
        existingSubFamily.setSubFamilyName(request.getSubFamilyName());
        existingSubFamily.setState(request.getState());
        existingSubFamily.setFamilyId(request.getFamilyId());
        SubFamily subFamily = subFamilyRepository.save(existingSubFamily);

        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setSubFamily(subFamily);

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }
}
