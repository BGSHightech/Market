package com.bgs.market.application.clienttype.view.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for CreateClientTypeRequestDTO.
 */
@Getter
@Setter
public class CreateClientTypeRequestDTO {
    @NotBlank(message = "clientTypeName should not be null")
    private String clientTypeName;
}
