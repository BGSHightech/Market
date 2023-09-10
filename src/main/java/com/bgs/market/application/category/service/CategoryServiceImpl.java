package com.bgs.market.application.category.service;

import com.bgs.market.application.category.persistence.Category;
import com.bgs.market.application.category.persistence.CategoryRepository;
import com.bgs.market.application.subfamily.persistence.SubFamilyRepository;
import com.bgs.market.application.category.view.dto.request.CreateCategoryRequestDTO;
import com.bgs.market.application.category.view.dto.request.UpdateCategoryRequestDTO;
import com.bgs.market.application.category.view.dto.response.CreateCategoryResponseDTO;
import com.bgs.market.application.category.view.dto.response.GetAllCategorysResponseDTO;
import com.bgs.market.application.category.view.dto.response.UpdateCategoryResponseDTO;
import com.bgs.market.exception.Exception;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    /**
     * Instantiating repositories.
     */
    CategoryRepository categoryRepository;
    SubFamilyRepository subFamilyRepository;

    /**
     * Get categories.
     *
     * @return categories
     */
    @Override
    public GetAllCategorysResponseDTO getAllCategories() throws Exception {
        // Assign value and find all categories.
        GetAllCategorysResponseDTO responseDTO = new GetAllCategorysResponseDTO();
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setCategories(categoryRepository.findAll());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Create category.
     *
     * @param request represents CreateCategoryRequestDTO
     * @return category
     */
    @Override
    public CreateCategoryResponseDTO createCategory(CreateCategoryRequestDTO request) throws Exception {
        // Show the request in the console
        System.out.println("request = " + new Gson().toJson(request));
        CreateCategoryResponseDTO responseDTO = new CreateCategoryResponseDTO();

        // Assign values and save.
        Category category = new Category();
        category.setCategoryName(request.getCategoryName());
        Category categoryCreated = categoryRepository.save(category);

        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setCategory(categoryCreated);

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Update category.
     *
     * @param request represents UpdateCategoryRequestDTO
     * @return category
     */
    @Override
    public UpdateCategoryResponseDTO updateCategory(UpdateCategoryRequestDTO request) throws Exception {
        // Show the request in the console
        System.out.println("request = " + new Gson().toJson(request));
        UpdateCategoryResponseDTO responseDTO = new UpdateCategoryResponseDTO();

        // Validate if category exists.
        Optional<Category> optionalCategory = categoryRepository.findById(request.getCategoryId());
        if (optionalCategory.isEmpty()) {
            responseDTO.setStatusCode("02");
            responseDTO.setStatusMessage("The category doesn't exists");
            return responseDTO;
        }

        // Assign values and save.
        Category existingCategory = optionalCategory.get();
        existingCategory.setCategoryId(request.getCategoryId());
        existingCategory.setCategoryName(request.getCategoryName());
        existingCategory.setState(request.getState());
        Category category = categoryRepository.save(existingCategory);

        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setCategory(category);

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }
}
