package com.bgs.market.application.menu.view.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for CreateMenuRequestDTO.
 */
@Getter
@Setter
public class CreateMenuRequestDTO {
    @NotBlank(message = "menuName should not be null")
    private String menuName;
}
