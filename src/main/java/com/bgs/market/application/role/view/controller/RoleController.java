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
    public GetAllRoleResponseDTO getAllRoles() throws Exception{
        return roleService.getAllRoles();
    }

    /**
     * Get role by id.
     *
     * @param role_id represents role_id
     * @return role
     */
    @GetMapping("{role_id}")
    public GetRoleByIdResponseDTO getRoleById(@PathVariable("role_id") Long role_id) throws Exception {
        return roleService.getRoleById(role_id);
    }

    /**
     * Create role.
     *
     * @param request represents CreateRoleRequestDTO
     * @return role
     */
    @PostMapping
    public CreateRoleResponseDTO createRole(@Valid @RequestBody CreateRoleRequestDTO request) throws Exception{
        return roleService.createRole(request);
    }

    /**
     * Update product unit.
     *
     * @param role_id represents role_id
     * @param request       represents UpdateRoleRequestDTO
     * @return role
     */
    @PutMapping("{role_id}")
    public UpdateRoleResponseDTO updateRoleResponseDTO(@PathVariable("role_id") Long role_id,
                                                       @Valid @RequestBody UpdateRoleRequestDTO request) throws Exception{
        return roleService.updateRole(request, role_id);
    }
}
