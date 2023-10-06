package com.bgs.market.application.role.view.dto.response;

import com.bgs.market.application.role.persistence.Role;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Class for GetAllRoleResponseDTO.
 */
@Getter
@Setter
public class GetAllRoleResponseDTO extends BaseResponseDTO {
    private List<Role> roles;
}
