package com.bgs.market.application.permission.view.dto.response;

import com.bgs.market.application.permission.persistence.Permission;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Class for GetAllPermissionsResponseDTO.
 */
@Getter
@Setter
public class GetAllPermissionsResponseDTO extends BaseResponseDTO {
    private List<Permission> permissions;
}
