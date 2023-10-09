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
    @NotBlank(message = "roleName should not be null")
    private String roleName;

    @Range(min = 0, max = 1, message = "state must be 0 or 1")
    private Integer state;
}
