package com.bgs.market.application.category.view.dto.response;

import com.bgs.market.application.category.persistence.Category;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCategoryResponseDTO extends BaseResponseDTO {
    private Category category;
}
