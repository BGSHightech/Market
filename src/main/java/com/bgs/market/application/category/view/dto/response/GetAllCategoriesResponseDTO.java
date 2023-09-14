package com.bgs.market.application.category.view.dto.response;

import com.bgs.market.application.category.persistence.Category;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Class for GetAllCategoriesResponseDTO.
 */
@Getter
@Setter
public class GetAllCategoriesResponseDTO extends BaseResponseDTO {
    private List<Category> categories;
}
