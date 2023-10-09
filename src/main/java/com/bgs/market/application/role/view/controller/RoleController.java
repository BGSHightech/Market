package com.bgs.market.application.role.view.controller;

import com.bgs.market.application.role.service.RoleService;
import com.bgs.market.application.role.view.dto.request.CreateRoleRequestDTO;
import com.bgs.market.application.role.view.dto.request.UpdateRoleRequestDTO;
import com.bgs.market.application.role.view.dto.response.CreateRoleResponseDTO;
import com.bgs.market.application.role.view.dto.response.GetAllRoleResponseDTO;
import com.bgs.market.application.role.view.dto.response.GetRoleByIdResponseDTO;
import com.bgs.market.application.role.view.dto.response.UpdateRoleResponseDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Class for RoleController.
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/role")
public class RoleController {
    private RoleService roleService;

    /**
     * Get list of role.
     *
     * @return role
     */
    @GetMapping
    public GetAllRoleResponseDTO getAllRoles() throws Exception {
        return roleService.getAllRoles();
    }

    /**
     * Get role by id.
     *
     * @param roleId represents roleId
     * @return role
     */
    @GetMapping("{roleId}")
    public GetRoleByIdResponseDTO getRoleById(@PathVariable("roleId") Long roleId) throws Exception {
        return roleService.getRoleById(roleId);
    }

    /**
     * Create role.
     *
     * @param request represents CreateRoleRequestDTO
     * @return role
     */
    @PostMapping
    public CreateRoleResponseDTO createRole(@Valid @RequestBody CreateRoleRequestDTO request) throws Exception {
        return roleService.createRole(request);
    }

    /**
     * Update role.
     *
     * @param roleId represents roleId
     * @param request represents UpdateRoleRequestDTO
     * @return role
     */
    @PutMapping("{roleId}")
    public UpdateRoleResponseDTO updateRoleResponseDTO(@PathVariable("roleId") Long roleId,
                                                       @Valid @RequestBody UpdateRoleRequestDTO request) throws Exception {
        return roleService.updateRole(request, roleId);
    }
}
