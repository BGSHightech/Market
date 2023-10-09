package com.bgs.market.application.role.service;

import com.bgs.market.application.role.persistence.Role;
import com.bgs.market.application.role.persistence.RoleRepository;
import com.bgs.market.application.role.view.dto.request.CreateRoleRequestDTO;
import com.bgs.market.application.role.view.dto.request.UpdateRoleRequestDTO;
import com.bgs.market.application.role.view.dto.response.CreateRoleResponseDTO;
import com.bgs.market.application.role.view.dto.response.GetAllRoleResponseDTO;
import com.bgs.market.application.role.view.dto.response.GetRoleByIdResponseDTO;
import com.bgs.market.application.role.view.dto.response.UpdateRoleResponseDTO;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    /**
     * Get list of roles.
     *
     * @return roles
     */
    @Override
    public GetAllRoleResponseDTO getAllRoles() {
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
    public GetRoleByIdResponseDTO getRoleById(Long roleId) {
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
    public CreateRoleResponseDTO createRole(CreateRoleRequestDTO request) {
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
     * @param roleId represents roleId
     * @return role
     */

    @Override
    public UpdateRoleResponseDTO updateRole(UpdateRoleRequestDTO request, Long roleId) {

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
}
