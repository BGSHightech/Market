package com.bgs.market.application.role.service;

import com.bgs.market.application.permission.persistence.Permission;
import com.bgs.market.application.permission.persistence.PermissionRepository;
import com.bgs.market.application.role.persistence.Role;
import com.bgs.market.application.role.persistence.RoleRepository;
import com.bgs.market.application.role.view.dto.request.CreateRoleRequestDTO;
import com.bgs.market.application.role.view.dto.request.UpdateRoleRequestDTO;
import com.bgs.market.application.role.view.dto.response.AddPermissionToRoleResponseDTO;
import com.bgs.market.application.role.view.dto.response.CreateRoleResponseDTO;
import com.bgs.market.application.role.view.dto.response.DeletePermissionToRoleResponseDTO;
import com.bgs.market.application.role.view.dto.response.GetAllPermissionsByRoleIdResponseDTO;
import com.bgs.market.application.role.view.dto.response.GetAllRoleResponseDTO;
import com.bgs.market.application.role.view.dto.response.GetRoleByIdResponseDTO;
import com.bgs.market.application.role.view.dto.response.UpdateRoleResponseDTO;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Class for RoleServiceImpl.
 */
@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    /**
     * Instantiating repositories.
     */
    private RoleRepository roleRepository;
    private PermissionRepository permissionRepository;

    /**
     * Get list of roles.
     *
     * @return roles
     */
    @Override
    public GetAllRoleResponseDTO getAllRoles() throws Exception {
        // Assign value and find all roles.
        GetAllRoleResponseDTO responseDTO = new GetAllRoleResponseDTO();
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setRoles(roleRepository.findAll());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Get role by id.
     *
     * @param roleId represents roleId
     * @return role
     */

    @Override
    public GetRoleByIdResponseDTO getRoleById(Long roleId) throws Exception {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(roleId));
        GetRoleByIdResponseDTO responseDTO = new GetRoleByIdResponseDTO();

        // Validate if role exists
        Optional<Role> optionalRole = roleRepository.findById(roleId);
        if (optionalRole.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The role doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        //Assign values.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setRole(optionalRole.get());

        //Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Create role.
     *
     * @param request represents CreateRoleRequestDTO
     * @return role
     */

    @Override
    public CreateRoleResponseDTO createRole(CreateRoleRequestDTO request) throws Exception {
        //Show the request in the console.
        System.out.println("request = " + new Gson().toJson(request));
        CreateRoleResponseDTO responseDTO = new CreateRoleResponseDTO();

        //Assign values and save.
        Role role = new Role();
        role.setRoleName(request.getRoleName());
        Role roleCreated = roleRepository.save(role);

        //Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setRole(roleCreated);

        //Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Update role.
     *
     * @param request represents UpdateRoleRequestDTO
     * @param roleId  represents roleId
     * @return role
     */
    @Override
    public UpdateRoleResponseDTO updateRole(UpdateRoleRequestDTO request, Long roleId) throws Exception {

        //Show the request in the console
        System.out.println("request = " + new Gson().toJson(request));
        UpdateRoleResponseDTO responseDTO = new UpdateRoleResponseDTO();

        //Validate if role exists
        Optional<Role> optionalRole = roleRepository.findById(roleId);
        if (optionalRole.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The role doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Assign values and save.
        Role existingRole = optionalRole.get();
        existingRole.setRoleName(request.getRoleName());
        existingRole.setState(request.getState());
        Role role = roleRepository.save(existingRole);

        //Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setRole(role);

        //Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Get all permissions by role id.
     *
     * @param roleId represents roleId
     * @return permissions
     */
    @Override
    public GetAllPermissionsByRoleIdResponseDTO getAllPermissionsByRoleId(Long roleId) throws Exception {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(roleId));
        GetAllPermissionsByRoleIdResponseDTO responseDTO = new GetAllPermissionsByRoleIdResponseDTO();

        // Validate if role exists.
        Optional<Role> optionalRole = roleRepository.findById(roleId);
        if (optionalRole.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The role doesn't exists.");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Assign values.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setPermissions(optionalRole.get().getPermissions());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Add permission to role.
     *
     * @param roleId       represents roleId
     * @param permissionId represents permissionId
     * @return permissions
     */
    @Override
    public AddPermissionToRoleResponseDTO addPermissionToRole(Long roleId, Long permissionId) throws Exception {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson("roleId: " + roleId + " - permissionId: " + permissionId));
        AddPermissionToRoleResponseDTO responseDTO = new AddPermissionToRoleResponseDTO();

        // Validate if rol exists.
        Optional<Role> optionalRole = roleRepository.findById(roleId);
        if (optionalRole.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The role doesn't exists.");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Validate if permission exists.
        Optional<Permission> optionalPermission = permissionRepository.findById(permissionId);
        if (optionalPermission.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The permission doesn't exists.");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // If the role does not yet have the permission, assign it
        Role existingRole = optionalRole.get();
        Stream<Permission> roleStream = existingRole.getPermissions().stream().filter(r -> r.getPermissionId().equals(optionalPermission.get().getPermissionId()));
        if (roleStream.findAny().isEmpty()) {
            List<Permission> permissions = existingRole.getPermissions();
            permissions.add(optionalPermission.get());
            existingRole.setPermissions(permissions);
        }

        // Save role.
        Role role = roleRepository.save(existingRole);

        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setPermission(role.getPermissions());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Delete permission to role.
     *
     * @param roleId       represents roleId
     * @param permissionId represents permissionId
     * @return permission
     */
    @Override
    public DeletePermissionToRoleResponseDTO deletePermissionToRole(Long roleId, Long permissionId) throws Exception {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson("roleId: " + roleId + " - permissionId: " + permissionId));
        DeletePermissionToRoleResponseDTO responseDTO = new DeletePermissionToRoleResponseDTO();

        // Validate if role exists.
        Optional<Role> optionalRole = roleRepository.findById(roleId);
        if (optionalRole.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The role doesn't exists.");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Validate if rol exists.
        Optional<Permission> optionalPermission = permissionRepository.findById(permissionId);
        if (optionalPermission.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The permission doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // If the role have the permission, remove it
        Role existingRole = optionalRole.get();
        Stream<Permission> permissionStream = existingRole.getPermissions().stream().filter(r -> r.getPermissionId().equals(optionalRole.get().getRoleId()));
        if (permissionStream.findAny().isPresent()) {
            List<Permission> permissions = existingRole.getPermissions();
            permissions.remove(optionalPermission.get());
            existingRole.setPermissions(permissions);
        }

        // Save role.
        Role role = roleRepository.save(existingRole);

        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setPermission(role.getPermissions());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }
}
