package com.bgs.market.application.role.service;

import com.bgs.market.application.role.view.dto.request.CreateRoleRequestDTO;
import com.bgs.market.application.role.view.dto.request.UpdateRoleRequestDTO;
import com.bgs.market.application.role.view.dto.response.CreateRoleResponseDTO;
import com.bgs.market.application.role.view.dto.response.GetAllRoleResponseDTO;
import com.bgs.market.application.role.view.dto.response.GetRoleByIdResponseDTO;
import com.bgs.market.application.role.view.dto.response.UpdateRoleResponseDTO;

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
     * @param role_id represents role_id
     * @return role
     */
    GetRoleByIdResponseDTO getRoleById(Long role_id) throws Exception;

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
     * @param role_id represents role_id
     * @return role
     */
    UpdateRoleResponseDTO updateRole(UpdateRoleRequestDTO request,
                                     Long role_id) throws Exception;

}
