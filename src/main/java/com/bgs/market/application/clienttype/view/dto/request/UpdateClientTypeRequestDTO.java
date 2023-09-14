package com.bgs.market.application.clienttype.view.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

/**
 * Class for UpdateClientTypeRequestDTO.
 */
@Getter
@Setter
public class UpdateClientTypeRequestDTO {
    @NotBlank(message = "clientTypeName should not be null")
    private String clientTypeName;

    @Range(min = 0, max = 1, message = "state must be 0 or 1")
    private Integer state;
}
