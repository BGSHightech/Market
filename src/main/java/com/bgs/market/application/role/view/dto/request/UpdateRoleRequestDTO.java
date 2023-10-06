package com.bgs.market.application.role.view.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

/**
 * Class for UpdateRoleRequestDTO.
 */
@Getter
@Setter
public class UpdateRoleRequestDTO {
    @NotBlank(message = "role_name should not be null")
    private String role_name;

    @Range(min = 0, max = 1, message = "state must be 0 or 1")
    private Integer state;
}
