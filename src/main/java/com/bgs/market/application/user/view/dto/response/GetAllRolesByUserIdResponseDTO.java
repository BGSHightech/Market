package com.bgs.market.application.user.view.dto.response;

import com.bgs.market.application.role.persistence.Role;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Class for GetAllRolesByUserId.
 */
@Getter
@Setter
public class GetAllRolesByUserIdResponseDTO extends BaseResponseDTO {
    private List<Role> roles;
}
