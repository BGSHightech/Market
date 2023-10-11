package com.bgs.market.application.permission.service;

import com.bgs.market.application.permission.view.dto.request.CreatePermissionRequestDTO;
import com.bgs.market.application.permission.view.dto.request.UpdatePermissionRequestDTO;
import com.bgs.market.application.permission.view.dto.response.*;

/**
 * Class for PermissionService.
 */
public interface PermissionService {
    /**
     * Get list of permissions.
     *
     * @return permissions
     */
    GetAllPermissionsResponseDTO getAllPermissions() throws Exception;

    /**
     * Get permission by id.
     *
     * @param permissionId represents permissionId
     * @return permission
     */
    GetPermissionByIdResponseDTO getPermissionById(Long permissionId) throws Exception;

    /**
     * Create permission.
     *
     * @param request represents CreatePermissionRequestDTO
     * @return permission
     */
    CreatePermissionResponseDTO createPermission(CreatePermissionRequestDTO request) throws Exception;

    /**
     * Update permission.
     *
     * @param request      represents UpdatePermissionRequestDTO
     * @param permissionId represents permissionId
     * @return permission
     */
    UpdatePermissionResponseDTO updatePermission(UpdatePermissionRequestDTO request,
                                                 Long permissionId) throws Exception;
}
