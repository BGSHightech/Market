package com.bgs.market.application.user.view.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.sql.Date;

/**
 * Class for UpdateUserRequestDTO.
 */
@Getter
@Setter
public class UpdateUserRequestDTO {
    @NotBlank(message = "firstName should not be null")
    private String firstName;

    @NotBlank(message = "lastName should not be null")
    private String lastName;

    @Email(message = "invalid email address")
    private String email;

    @NotBlank(message = "username should not be null")
    private String username;

    @NotBlank(message = "password should not be null")
    private String password;

    @Range(min = 0, max = 1, message = "state must be 0 or 1")
    private Integer state;

    private String phone;
    private Date dateOfBirth;
}
