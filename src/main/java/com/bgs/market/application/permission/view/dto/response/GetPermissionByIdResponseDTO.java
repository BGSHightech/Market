package com.bgs.market.application.permission.view.dto.response;

import com.bgs.market.application.permission.persistence.Permission;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for GetPermissionByIdResponseDTO.
 */
@Getter
@Setter
public class GetPermissionByIdResponseDTO extends BaseResponseDTO {
    private Permission permission;
}
