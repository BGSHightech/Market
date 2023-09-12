package com.bgs.market.application.category.service;

import com.bgs.market.application.category.view.dto.request.CreateCategoryRequestDTO;
import com.bgs.market.application.category.view.dto.request.UpdateCategoryRequestDTO;
import com.bgs.market.application.category.view.dto.response.CreateCategoryResponseDTO;
import com.bgs.market.application.category.view.dto.response.GetAllCategorysResponseDTO;
import com.bgs.market.application.category.view.dto.response.GetCategoryByIdResponseDTO;
import com.bgs.market.application.category.view.dto.response.UpdateCategoryResponseDTO;
import com.bgs.market.exception.Exception;

/**
 * Class for CategoryService
 */
public interface CategoryService {
    /**
     * Get categories.
     *
     * @return categories
     */
    GetAllCategorysResponseDTO getAllCategories() throws Exception;

    /**
     * Get category by id.
     *
     * @param categoryId represents categoryId
     * @return category
     */

    GetCategoryByIdResponseDTO getCategoryById(Long categoryId) throws Exception;


    /**
     * Create category.
     *
     * @param request represents CreateCategoryRequestDTO
     * @return category
     */

    CreateCategoryResponseDTO createCategory(CreateCategoryRequestDTO request) throws Exception;

    /**
     * Update category.
     *
     * @param request represents UpdateCategoryRequestDTO
     * @return category
     */
    UpdateCategoryResponseDTO updateCategory(UpdateCategoryRequestDTO request) throws Exception;
}
