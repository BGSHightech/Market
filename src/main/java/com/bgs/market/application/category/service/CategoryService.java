package com.bgs.market.application.category.service;

import com.bgs.market.application.category.view.dto.request.CreateCategoryRequestDTO;
import com.bgs.market.application.category.view.dto.request.UpdateCategoryRequestDTO;
import com.bgs.market.application.category.view.dto.response.CreateCategoryResponseDTO;
import com.bgs.market.application.category.view.dto.response.GetAllCategoriesResponseDTO;
import com.bgs.market.application.category.view.dto.response.GetCategoryByIdResponseDTO;
import com.bgs.market.application.category.view.dto.response.UpdateCategoryResponseDTO;

/**
 * Class for CategoryService
 */
public interface CategoryService {
    /**
     * Get categories.
     *
     * @return categories
     */
    GetAllCategoriesResponseDTO getAllCategories() throws Exception;

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
     * @param request    represents UpdateCategoryRequestDTO
     * @param categoryId represents categoryId
     * @return category
     */
    UpdateCategoryResponseDTO updateCategory(UpdateCategoryRequestDTO request,
                                             Long categoryId) throws Exception;
}
