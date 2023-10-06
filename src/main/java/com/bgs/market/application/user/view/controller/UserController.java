package com.bgs.market.application.user.view.controller;

import com.bgs.market.application.user.service.UserService;
import com.bgs.market.application.user.view.dto.request.CreateUserRequestDTO;
import com.bgs.market.application.user.view.dto.request.UpdateUserRequestDTO;
import com.bgs.market.application.user.view.dto.response.CreateUserResponseDTO;
import com.bgs.market.application.user.view.dto.response.GetAllUsersResponseDTO;
import com.bgs.market.application.user.view.dto.response.GetUserByIdResponseDTO;
import com.bgs.market.application.user.view.dto.response.UpdateUserResponseDTO;
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
    public UpdateUserResponseDTO updateUserResponseDTO(@PathVariable("userId") Long userId,
                                                       @Valid @RequestBody UpdateUserRequestDTO request) throws Exception {
        return userService.updateUser(request, userId);
    }
}
