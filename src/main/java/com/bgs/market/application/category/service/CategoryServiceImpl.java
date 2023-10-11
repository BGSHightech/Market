package com.bgs.market.application.category.service;

import com.bgs.market.application.category.persistence.Category;
import com.bgs.market.application.category.persistence.CategoryRepository;
import com.bgs.market.application.category.view.dto.response.GetCategoryByIdResponseDTO;
import com.bgs.market.application.category.view.dto.request.CreateCategoryRequestDTO;
import com.bgs.market.application.category.view.dto.request.UpdateCategoryRequestDTO;
import com.bgs.market.application.category.view.dto.response.CreateCategoryResponseDTO;
import com.bgs.market.application.category.view.dto.response.GetAllCategoriesResponseDTO;
import com.bgs.market.application.category.view.dto.response.UpdateCategoryResponseDTO;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Class for CategoryServiceImpl.
 */
@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    /**
     * Instantiating repositories.
     */
    CategoryRepository categoryRepository;

    /**
     * Get categories.
     *
     * @return categories
     */
    @Override
    public GetAllCategoriesResponseDTO getAllCategories() throws Exception {
        // Assign value and find all categories.
        GetAllCategoriesResponseDTO responseDTO = new GetAllCategoriesResponseDTO();
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setCategories(categoryRepository.findAll());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }


    /**
     * Get category by id.
     *
     * @param categoryId represents categoryId
     * @return category
     */
    @Override
    public GetCategoryByIdResponseDTO getCategoryById(Long categoryId) throws Exception {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(categoryId));
        GetCategoryByIdResponseDTO responseDTO = new GetCategoryByIdResponseDTO();

        // Validate if category exists.
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The category doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Assign values.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setCategory(optionalCategory.get());

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
     * @param request    represents UpdateCategoryRequestDTO
     * @param categoryId represents categoryId
     * @return category
     */
    @Override
    public UpdateCategoryResponseDTO updateCategory(UpdateCategoryRequestDTO request,
                                                    Long categoryId) throws Exception {
        // Show the request in the console
        System.out.println("request = " + new Gson().toJson(request));
        UpdateCategoryResponseDTO responseDTO = new UpdateCategoryResponseDTO();

        // Validate if category exists.
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The category doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Assign values and save.
        Category existingCategory = optionalCategory.get();
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
