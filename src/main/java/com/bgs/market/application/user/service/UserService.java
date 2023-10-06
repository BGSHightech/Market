package com.bgs.market.application.user.service;

import com.bgs.market.application.user.view.dto.request.CreateUserRequestDTO;
import com.bgs.market.application.user.view.dto.request.UpdateUserRequestDTO;
import com.bgs.market.application.user.view.dto.response.CreateUserResponseDTO;
import com.bgs.market.application.user.view.dto.response.GetAllUsersResponseDTO;
import com.bgs.market.application.user.view.dto.response.GetUserByIdResponseDTO;
import com.bgs.market.application.user.view.dto.response.UpdateUserResponseDTO;

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
}
