package com.bgs.market.application.permission.view.controller;

import com.bgs.market.application.permission.service.PermissionService;
import com.bgs.market.application.permission.view.dto.request.CreatePermissionRequestDTO;
import com.bgs.market.application.permission.view.dto.request.UpdatePermissionRequestDTO;
import com.bgs.market.application.permission.view.dto.response.CreatePermissionResponseDTO;
import com.bgs.market.application.permission.view.dto.response.GetAllPermissionsResponseDTO;
import com.bgs.market.application.permission.view.dto.response.GetPermissionByIdResponseDTO;
import com.bgs.market.application.permission.view.dto.response.UpdatePermissionResponseDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class for PermissionController.
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/permission")
public class PermissionController {
    private PermissionService permissionService;

    /**
     * Get list of permissions.
     *
     * @return permissions
     */
    @GetMapping()
    public GetAllPermissionsResponseDTO getAllPermissions() throws Exception {
        return permissionService.getAllPermissions();
    }

    /**
     * Get permission by id.
     *
     * @param permissionId represents permissionId
     * @return permission
     */
    @GetMapping("{permissionId}")
    public GetPermissionByIdResponseDTO getPermissionById(@PathVariable("permissionId") Long permissionId) throws Exception {
        return permissionService.getPermissionById(permissionId);
    }

    /**
     * Create permission.
     *
     * @param request represents CreatePermissionRequestDTO
     * @return permission
     */
    @PostMapping()
    public CreatePermissionResponseDTO createPermission(@Valid @RequestBody CreatePermissionRequestDTO request) throws Exception {
        return permissionService.createPermission(request);
    }

    /**
     * Update permission.
     *
     * @param permissionId represents permissionId
     * @param request      represents UpdatePermissionRequestDTO
     * @return permission
     */
    @PutMapping("{permissionId}")
    public UpdatePermissionResponseDTO updatePermission(@PathVariable("permissionId") Long permissionId,
                                                        @Valid @RequestBody UpdatePermissionRequestDTO request) throws Exception {
        return permissionService.updatePermission(request, permissionId);
    }
}
