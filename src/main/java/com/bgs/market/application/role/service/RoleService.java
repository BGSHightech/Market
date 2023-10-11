package com.bgs.market.application.role.service;

import com.bgs.market.application.role.view.dto.request.CreateRoleRequestDTO;
import com.bgs.market.application.role.view.dto.request.UpdateRoleRequestDTO;
import com.bgs.market.application.role.view.dto.response.*;

/**
 * Class for RoleService.
 */
public interface RoleService {
    /**
     * Get list of roles.
     *
     * @return roles
     */
    GetAllRoleResponseDTO getAllRoles() throws Exception;

    /**
     * Get role by id.
     *
     * @param roleId represents roleId
     * @return role
     */
    GetRoleByIdResponseDTO getRoleById(Long roleId) throws Exception;

    /**
     * Create role.
     *
     * @param request represents CreateRoleResponseDTO
     * @return role
     */
    CreateRoleResponseDTO createRole(CreateRoleRequestDTO request) throws Exception;

    /**
     * Update role.
     *
     * @param request represents UpdateRoleResponseDTO
     * @param roleId  represents roleId
     * @return role
     */
    UpdateRoleResponseDTO updateRole(UpdateRoleRequestDTO request,
                                     Long roleId) throws Exception;

    /**
     * Get all permissions by role id.
     *
     * @param roleId represents roleId
     * @return permissions
     */
    GetAllPermissionsByRoleIdResponseDTO getAllPermissionsByRoleId(Long roleId) throws Exception;

    /**
     * Add permission to role.
     *
     * @param roleId       represents roleId
     * @param permissionId represents permissionId
     * @return permissions
     */
    AddPermissionToRoleResponseDTO addPermissionToRole(Long roleId, Long permissionId) throws Exception;

    /**
     * Delete permission to role.
     *
     * @param roleId       represents roleId
     * @param permissionId represents permissionId
     * @return permission
     */
    DeletePermissionToRoleResponseDTO deletePermissionToRole(Long roleId, Long permissionId) throws Exception;
}
