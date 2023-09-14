package com.bgs.market.application.client.view.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

/**
 * Class for UpdateClientRequestDTO.
 */
@Getter
@Setter
public class UpdateClientRequestDTO {
    @NotNull(message = "clientTypeId cannot be null")
    @Min(message = "clientTypeId should be greater than 0", value = 1L)
    private Long clientTypeId;

    @NotBlank(message = "clientName should not be null")
    private String clientName;

    @NotNull(message = "documentType cannot be null")
    @Min(message = "documentType should be greater than 0", value = 1L)
    private Long documentType;

    @NotBlank(message = "documentNumber should not be null")
    private String documentNumber;

    @NotBlank(message = "clientDirection should not be null")
    private String clientDirection;

    @Email(message = "invalid email address")
    private String clientEmail;

    @Range(min = 0, max = 1, message = "state must be 0 or 1")
    private Integer state;

    private String ubigeo;
    private String phoneNumber;
}
