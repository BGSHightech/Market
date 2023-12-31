package com.bgs.market.application.category.view.controller;

import com.bgs.market.application.category.service.CategoryService;
import com.bgs.market.application.category.view.dto.request.CreateCategoryRequestDTO;
import com.bgs.market.application.category.view.dto.request.UpdateCategoryRequestDTO;
import com.bgs.market.application.category.view.dto.response.CreateCategoryResponseDTO;
import com.bgs.market.application.category.view.dto.response.GetAllCategoriesResponseDTO;
import com.bgs.market.application.category.view.dto.response.GetCategoryByIdResponseDTO;
import com.bgs.market.application.category.view.dto.response.UpdateCategoryResponseDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class for CategoryController.
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/category")
public class CategoryController {
    private CategoryService categoryService;

    /**
     * Get list of categories.
     *
     * @return categories
     */
    @GetMapping
    public GetAllCategoriesResponseDTO getAllCategories() throws Exception {
        return categoryService.getAllCategories();
    }

    /**
     * Get category by id.
     *
     * @param categoryId represents categoryId
     * @return category
     */
    @GetMapping("{categoryId}")
    public GetCategoryByIdResponseDTO getCategoryById(@PathVariable("categoryId") Long categoryId) throws Exception {
        return categoryService.getCategoryById(categoryId);
    }

    /**
     * Create category.
     *
     * @param request represents CreateCategoryRequestDTO
     * @return category
     */

    @PostMapping
    public CreateCategoryResponseDTO createCategory(@Valid @RequestBody CreateCategoryRequestDTO request) throws Exception {
        return categoryService.createCategory(request);
    }

    /**
     * Update category.
     *
     * @param categoryId represents categoryId
     * @param request    represents UpdateCategoryRequestDTO
     * @return category
     */
    @PutMapping("{categoryId}")
    public UpdateCategoryResponseDTO updateCategoryResponseDTO(@PathVariable("categoryId") Long categoryId,
                                                               @Valid @RequestBody UpdateCategoryRequestDTO request) throws Exception {
        return categoryService.updateCategory(request, categoryId);
    }
}
