package com.bgs.market.application.menu.view.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

/**
 * Class for UpdateMenuRequestDTO.
 */
@Getter
@Setter
public class UpdateMenuRequestDTO {
    @NotBlank(message = "menuName should not be null")
    private String menuName;

    @Range(min = 0, max = 1, message = "state must be 0 or 1")
    private int state;
}
