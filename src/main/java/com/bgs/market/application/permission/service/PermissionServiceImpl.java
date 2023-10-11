package com.bgs.market.application.permission.service;

import com.bgs.market.application.permission.persistence.Permission;
import com.bgs.market.application.permission.persistence.PermissionRepository;
import com.bgs.market.application.permission.view.dto.request.CreatePermissionRequestDTO;
import com.bgs.market.application.permission.view.dto.request.UpdatePermissionRequestDTO;
import com.bgs.market.application.permission.view.dto.response.CreatePermissionResponseDTO;
import com.bgs.market.application.permission.view.dto.response.GetAllPermissionsResponseDTO;
import com.bgs.market.application.permission.view.dto.response.GetPermissionByIdResponseDTO;
import com.bgs.market.application.permission.view.dto.response.UpdatePermissionResponseDTO;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Class for PermissionServiceImpl.
 */
@Service
@AllArgsConstructor
public class PermissionServiceImpl implements PermissionService {
    /**
     * Instantiating repositories.
     */
    PermissionRepository permissionRepository;

    /**
     * Get list of permissions.
     *
     * @return permissions
     */
    @Override
    public GetAllPermissionsResponseDTO getAllPermissions() {
        // Assign value and find all permissions.
        GetAllPermissionsResponseDTO responseDTO = new GetAllPermissionsResponseDTO();
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setPermissions(permissionRepository.findAll());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Get permission by id.
     *
     * @param permissionId represents permissionId
     * @return permission
     */
    @Override
    public GetPermissionByIdResponseDTO getPermissionById(Long permissionId) {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(permissionId));
        GetPermissionByIdResponseDTO responseDTO = new GetPermissionByIdResponseDTO();

        // Validate if permission exists.
        Optional<Permission> optionalPermission = permissionRepository.findById(permissionId);
        if (optionalPermission.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The permission doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Assign values.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setPermission(optionalPermission.get());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Create permission.
     *
     * @param request represents CreatePermissionRequestDTO
     * @return permission
     */
    @Override
    public CreatePermissionResponseDTO createPermission(CreatePermissionRequestDTO request) {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(request));
        CreatePermissionResponseDTO responseDTO = new CreatePermissionResponseDTO();

        // Assign values and save.
        Permission permission = new Permission();
        permission.setPermissionName(request.getPermissionName());
        Permission permissionCreated = permissionRepository.save(permission);

        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setPermission(permissionCreated);

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Update permission.
     *
     * @param request      represents UpdatePermissionRequestDTO
     * @param permissionId represents permissionId
     * @return permission
     */
    @Override
    public UpdatePermissionResponseDTO updatePermission(UpdatePermissionRequestDTO request,
                                                        Long permissionId) {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(request));
        UpdatePermissionResponseDTO responseDTO = new UpdatePermissionResponseDTO();

        // Validate if permission exists
        Optional<Permission> optionalPermission = permissionRepository.findById(permissionId);
        if (optionalPermission.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The permission doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Assign values and save.
        Permission existingPermission = optionalPermission.get();
        existingPermission.setPermissionId(permissionId);
        existingPermission.setPermissionName(request.getPermissionName());
        Permission permission = permissionRepository.save(existingPermission);

        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setPermission(permission);

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }
}
