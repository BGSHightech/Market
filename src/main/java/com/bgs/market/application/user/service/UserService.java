package com.bgs.market.application.user.service;

import com.bgs.market.application.user.view.dto.request.CreateUserRequestDTO;
import com.bgs.market.application.user.view.dto.request.LoginUserRequestDTO;
import com.bgs.market.application.user.view.dto.request.UpdateUserRequestDTO;
import com.bgs.market.application.user.view.dto.response.*;

/**
 * Class for UserService.
 */
public interface UserService {
    /**
     * Get list of users.
     *
     * @return users
     */
    GetAllUsersResponseDTO getAllUsers() throws Exception;

    /**
     * Get user by id.
     *
     * @param userId represents userId
     * @return user
     */
    GetUserByIdResponseDTO getUserById(Long userId) throws Exception;

    /**
     * Create user.
     *
     * @param request represents CreateUserRequestDTO
     * @return user
     */
    CreateUserResponseDTO createUser(CreateUserRequestDTO request) throws Exception;

    /**
     * Update user.
     *
     * @param request represents UpdateUserRequestDTO
     * @param userId  represents userId
     * @return user
     */
    UpdateUserResponseDTO updateUser(UpdateUserRequestDTO request,
                                     Long userId) throws Exception;

    /**
     * Get all roles by user id.
     *
     * @param userId represents userId
     * @return roles
     */
    GetAllRolesByUserIdResponseDTO getAllRolesByUserId(Long userId) throws Exception;

    /**
     * Add role to user.
     *
     * @param userId represents userId
     * @param roleId represents roleId
     * @return roles
     */
    AddRoleToUserResponseDTO addRoleToUser(Long userId, Long roleId) throws Exception;

    /**
     * Delete role to user.
     *
     * @param userId represents userId
     * @param roleId represents roleId
     * @return roles
     */
    DeleteRoleToUserResponseDTO deleteRoleToUser(Long userId, Long roleId) throws Exception;

    /**
     * Login user.
     *
     * @param request represents LoginUserRequestDTO
     * @return user
     */
    LoginUserResponseDTO loginUser(LoginUserRequestDTO request) throws Exception;

}
