package com.bgs.market.application.user.service;

import com.bgs.market.application.role.persistence.Role;
import com.bgs.market.application.role.persistence.RoleRepository;
import com.bgs.market.application.user.persistence.User;
import com.bgs.market.application.user.persistence.UserRepository;
import com.bgs.market.application.user.view.dto.request.CreateUserRequestDTO;
import com.bgs.market.application.user.view.dto.request.UpdateUserRequestDTO;
import com.bgs.market.application.user.view.dto.response.*;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Class for UserServiceImpl.
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    /**
     * Instantiating repositories.
     */
    UserRepository userRepository;
    RoleRepository roleRepository;

    /**
     * Get list of users.
     *
     * @return users
     */
    @Override
    public GetAllUsersResponseDTO getAllUsers() throws Exception {
        // Assign value and find all users.
        GetAllUsersResponseDTO responseDTO = new GetAllUsersResponseDTO();
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setUsers(userRepository.findAll());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Get user by id.
     *
     * @param userId represents userId
     * @return user
     */
    @Override
    public GetUserByIdResponseDTO getUserById(Long userId) throws Exception {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(userId));
        GetUserByIdResponseDTO responseDTO = new GetUserByIdResponseDTO();

        // Validate if user exists.
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The user doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Assign values.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setUser(optionalUser.get());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Create user.
     *
     * @param request represents CreateUserRequestDTO
     * @return user
     */
    @Override
    public CreateUserResponseDTO createUser(CreateUserRequestDTO request) throws Exception {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(request));
        CreateUserResponseDTO responseDTO = new CreateUserResponseDTO();

        // Assign values and save.
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setDateOfBirth(request.getDateOfBirth());
        user.setPhone(request.getPhone());
        User subFamilyCreated = userRepository.save(user);

        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setUser(subFamilyCreated);

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Update user.
     *
     * @param request represents UpdateUserRequestDTO
     * @param userId  represents userId
     * @return user
     */
    @Override
    public UpdateUserResponseDTO updateUser(UpdateUserRequestDTO request,
                                            Long userId) throws Exception {
        // Show the request in the console
        System.out.println("request = " + new Gson().toJson(request));
        UpdateUserResponseDTO responseDTO = new UpdateUserResponseDTO();

        // Validate if subFamily exists
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The user doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Assign values and save.
        User existingUser = optionalUser.get();
        existingUser.setFirstName(request.getFirstName());
        existingUser.setLastName(request.getLastName());
        existingUser.setEmail(request.getEmail());
        existingUser.setUsername(request.getUsername());
        existingUser.setPassword(request.getPassword());
        existingUser.setDateOfBirth(request.getDateOfBirth());
        existingUser.setPhone(request.getPhone());
        existingUser.setState(request.getState());
        User user = userRepository.save(existingUser);

        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setUser(user);

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Get all roles by user id.
     *
     * @param userId represents userId
     * @return roles
     */
    @Override
    public GetAllRolesByUserId getAllRolesByUserId(Long userId) throws Exception {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(userId));
        GetAllRolesByUserId responseDTO = new GetAllRolesByUserId();

        // Validate if user exists.
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The user doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Assign values.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setRoles(optionalUser.get().getRoles());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Add role to user.
     *
     * @param userId represents userId
     * @param roleId represents roleId
     * @return roles
     */
    @Override
    public AddRoleToUser addRoleToUser(Long userId, Long roleId) throws Exception {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson("userId: " + userId + " - roleId: " + roleId));
        AddRoleToUser responseDTO = new AddRoleToUser();

        // Validate if user exists.
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The user doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Validate if rol exists.
        Optional<Role> optionalRole = roleRepository.findById(roleId);
        if (optionalRole.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The role doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // If the user does not yet have the role, assign it
        User existingUser = optionalUser.get();
        Stream<Role> roleStream = existingUser.getRoles().stream().filter(r -> r.getRoleId().equals(optionalRole.get().getRoleId()));
        if (roleStream.findAny().isEmpty()) {
            List<Role> roles = existingUser.getRoles();
            roles.add(optionalRole.get());
            existingUser.setRoles(roles);
        }

        // Save user.
        User user = userRepository.save(existingUser);

        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setRoles(user.getRoles());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Delete role to user.
     *
     * @param userId represents userId
     * @param roleId represents roleId
     * @return roles
     */
    @Override
    public DeleteRoleToUser deleteRoleToUser(Long userId, Long roleId) throws Exception {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson("userId: " + userId + " - roleId: " + roleId));
        DeleteRoleToUser responseDTO = new DeleteRoleToUser();

        // Validate if user exists.
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The user doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Validate if rol exists.
        Optional<Role> optionalRole = roleRepository.findById(roleId);
        if (optionalRole.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The role doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // If the user have the role, remove it
        User existingUser = optionalUser.get();
        Stream<Role> roleStream = existingUser.getRoles().stream().filter(r -> r.getRoleId().equals(optionalRole.get().getRoleId()));
        if (roleStream.findAny().isPresent()) {
            List<Role> roles = existingUser.getRoles();
            roles.remove(optionalRole.get());
            existingUser.setRoles(roles);
        }

        // Save user.
        User user = userRepository.save(existingUser);

        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setRoles(user.getRoles());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

}
