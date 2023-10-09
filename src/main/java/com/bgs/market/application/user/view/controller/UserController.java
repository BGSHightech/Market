package com.bgs.market.application.user.view.controller;

import com.bgs.market.application.user.service.UserService;
import com.bgs.market.application.user.view.dto.request.CreateUserRequestDTO;
import com.bgs.market.application.user.view.dto.request.UpdateUserRequestDTO;
import com.bgs.market.application.user.view.dto.response.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Class for UserController.
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    private UserService userService;

    /**
     * Get list of users.
     *
     * @return users
     */
    @GetMapping
    public GetAllUsersResponseDTO getAllUsers() throws Exception {
        return userService.getAllUsers();
    }

    /**
     * Get user by id.
     *
     * @param userId represents userId
     * @return user
     */
    @GetMapping("{userId}")
    public GetUserByIdResponseDTO getUserById(@PathVariable("userId") Long userId) throws Exception {
        return userService.getUserById(userId);
    }

    /**
     * Create user.
     *
     * @param request represents CreateUserRequestDTO
     * @return user
     */
    @PostMapping
    public CreateUserResponseDTO createUser(@Valid @RequestBody CreateUserRequestDTO request) throws Exception {
        return userService.createUser(request);
    }

    /**
     * Update user.
     *
     * @param userId  represents userId
     * @param request represents UpdateUserRequestDTO
     * @return user
     */
    @PutMapping("{userId}")
    public UpdateUserResponseDTO updateUser(@PathVariable("userId") Long userId,
                                                       @Valid @RequestBody UpdateUserRequestDTO request) throws Exception {
        return userService.updateUser(request, userId);
    }

    /**
     * Get all roles by user id.
     *
     * @param userId represents userId
     * @return roles
     */
    @GetMapping("{userId}/role")
    public GetAllRolesByUserId getAllRolesByUserId(@PathVariable("userId") Long userId) throws Exception {
        return userService.getAllRolesByUserId(userId);
    }

    /**
     * Add role to user.
     *
     * @param userId represents userId
     * @param roleId represents roleId
     * @return roles
     */
    @PostMapping("{userId}/role/{roleId}")
    public AddRoleToUser addRoleToUser(@PathVariable("userId") Long userId, @PathVariable("roleId") Long roleId) throws Exception {
        return userService.addRoleToUser(userId, roleId);
    }

    /**
     * Delete role to user.
     *
     * @param userId represents userId
     * @param roleId represents roleId
     * @return roles
     */
    @DeleteMapping("{userId}/role/{roleId}")
    public DeleteRoleToUser deleteRoleToUser(@PathVariable("userId") Long userId, @PathVariable("roleId") Long roleId) throws Exception {
        return userService.deleteRoleToUser(userId, roleId);
    }
}
