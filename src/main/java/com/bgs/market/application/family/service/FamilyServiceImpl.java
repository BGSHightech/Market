package com.bgs.market.application.family.service;

import com.bgs.market.application.category.persistence.Category;
import com.bgs.market.application.family.persistence.Family;
import com.bgs.market.application.category.persistence.CategoryRepository;
import com.bgs.market.application.family.persistence.FamilyRepository;
import com.bgs.market.application.family.view.dto.request.CreateFamilyRequestDTO;
import com.bgs.market.application.family.view.dto.request.UpdateFamilyRequestDTO;
import com.bgs.market.application.family.view.dto.response.*;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Class for FamilyServiceImpl.
 */
@Service
@AllArgsConstructor
public class FamilyServiceImpl implements FamilyService {
    /**
     * Instantiating repositories.
     */
    FamilyRepository familyRepository;
    CategoryRepository categoryRepository;

    /**
     * Get list of families.
     *
     * @return families
     */
    @Override
    public GetAllFamiliesResponseDTO getAllFamilies() {
        // Assign value and find all families.
        GetAllFamiliesResponseDTO responseDTO = new GetAllFamiliesResponseDTO();
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setFamilies(familyRepository.findAll());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Get family by id.
     *
     * @param familyId represents familyId
     * @return family
     */
    @Override
    public GetFamilyByIdResponseDTO getFamilyById(Long familyId) {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(familyId));
        GetFamilyByIdResponseDTO responseDTO = new GetFamilyByIdResponseDTO();

        // Validate if family exists.
        Optional<Family> optionalFamily = familyRepository.findById(familyId);
        if (optionalFamily.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The family doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Assign values.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setFamily(optionalFamily.get());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Create family.
     *
     * @param request represents CreateFamilyRequestDTO.
     * @return family
     */
    @Override
    public CreateFamilyResponseDTO createFamily(CreateFamilyRequestDTO request) {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(request));
        CreateFamilyResponseDTO responseDTO = new CreateFamilyResponseDTO();

        // Validate if category exists
        Optional<Category> optionalCategory = categoryRepository.findById(request.getCategoryId());
        if (optionalCategory.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The category doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Assign values and save.
        Family family = new Family();
        family.setFamilyName(request.getFamilyName());
        family.setCategoryId(request.getCategoryId());
        Family familyCreated = familyRepository.save(family);

        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setFamily(familyCreated);

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Update family.
     *
     * @param request  represents UpdateFamilyRequestDTO
     * @param familyId represents familyId
     * @return family
     */
    @Override
    public UpdateFamilyResponseDTO updateFamily(UpdateFamilyRequestDTO request,
                                                Long familyId) {
        // Show the request in the console
        System.out.println("request = " + new Gson().toJson(request));
        UpdateFamilyResponseDTO responseDTO = new UpdateFamilyResponseDTO();

        // Validate if family exists
        Optional<Family> optionalFamily = familyRepository.findById(familyId);
        if (optionalFamily.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The family doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Validate if category exists
        Optional<Category> optionalCategory = categoryRepository.findById(request.getCategoryId());
        if (optionalCategory.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The category doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Assign values and save.
        Family existingFamily = optionalFamily.get();
        existingFamily.setFamilyName(request.getFamilyName());
        existingFamily.setCategoryId(request.getCategoryId());
        existingFamily.setState(request.getState());
        Family family = familyRepository.save(existingFamily);

        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setFamily(family);

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    @Override
    public GetAllFamiliesByCategoryIdResponseDTO getFamiliesByCategoryId(Long categoryId) throws Exception {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(categoryId));
        GetAllFamiliesByCategoryIdResponseDTO responseDTO = new GetAllFamiliesByCategoryIdResponseDTO();


        // Validate if category exists
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The category doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }
        List<Family> families = new ArrayList<>();
        Optional <List<Family>> optionalFamilies = familyRepository.findFamiliesByCategoryId(categoryId);
        if (optionalFamilies.isPresent()){
            families = optionalFamilies.get();
        }
        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setFamilies(families);

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;

    }
}
