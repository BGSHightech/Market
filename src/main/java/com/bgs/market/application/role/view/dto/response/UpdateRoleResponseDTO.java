package com.bgs.market.application.role.view.dto.response;

import com.bgs.market.application.role.persistence.Role;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for UpdateProductUnitResponseDTO.
 */
@Getter
@Setter
public class UpdateRoleResponseDTO extends BaseResponseDTO {
    private Role role;
}
