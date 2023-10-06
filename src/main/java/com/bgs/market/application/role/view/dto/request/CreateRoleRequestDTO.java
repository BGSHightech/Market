package com.bgs.market.application.role.view.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for CreateRoleRequestDTO.
 */
@Getter
@Setter
public class CreateRoleRequestDTO {
    @NotBlank(message = "RolesName should not be null")
    private String role_name;
}
