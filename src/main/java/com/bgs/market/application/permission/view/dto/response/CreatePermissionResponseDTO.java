package com.bgs.market.application.permission.view.dto.response;

import com.bgs.market.application.permission.persistence.Permission;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for CreatePermissionResponseDTO.
 */
@Getter
@Setter
public class CreatePermissionResponseDTO extends BaseResponseDTO {
    private Permission permission;
}
