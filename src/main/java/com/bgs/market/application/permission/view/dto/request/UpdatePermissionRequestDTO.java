package com.bgs.market.application.permission.view.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for UpdatePermissionRequestDTO.
 */
@Getter
@Setter
public class UpdatePermissionRequestDTO {
    @NotBlank(message = "permissionName should not be null")
    private String permissionName;
}
