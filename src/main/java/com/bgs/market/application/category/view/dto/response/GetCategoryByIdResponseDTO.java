package com.bgs.market.application.category.view.dto.response;

import com.bgs.market.application.category.persistence.Category;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for GetCategoryByIdResponseDTO.
 */
@Getter
@Setter
public class GetCategoryByIdResponseDTO extends BaseResponseDTO {
    private Category category;
}
