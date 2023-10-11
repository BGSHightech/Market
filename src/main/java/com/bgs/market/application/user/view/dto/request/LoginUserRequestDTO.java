package com.bgs.market.application.user.view.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for LoginUserRequestDTO.
 */
@Getter
@Setter
public class LoginUserRequestDTO {
    @NotBlank(message = "username should not be null")
    private String username;

    @NotBlank(message = "password should not be null")
    private String password;
}
