package com.bgs.market.application.category.view.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCategoryRequestDTO {
    private Long categoryId;
    private String categoryName;
    private Integer state;
}
