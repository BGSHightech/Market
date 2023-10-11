package com.bgs.market.application.role.view.dto.response;

import com.bgs.market.application.permission.persistence.Permission;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Class for GetAllPermissionsByRoleIdResponseDTO.
 */
@Getter
@Setter
public class GetAllPermissionsByRoleIdResponseDTO extends BaseResponseDTO {
    private List<Permission> permissions;
}
