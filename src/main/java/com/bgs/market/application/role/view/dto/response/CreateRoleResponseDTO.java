package com.bgs.market.application.role.view.dto.response;

import com.bgs.market.application.role.persistence.Role;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for CreateRoleResponseDTO.
 */
@Getter
@Setter
public class CreateRoleResponseDTO extends BaseResponseDTO {
    private Role role;
}
