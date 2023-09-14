package com.bgs.market.application.parameter.view.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

/**
 * Class for UpdateParameterRequestDTO.
 */
@Getter
@Setter
public class UpdateParameterRequestDTO {
    @NotBlank(message = "parameterType should not be null")
    private String parameterType;

    @NotBlank(message = "value should not be null")
    private String value;

    @Range(min = 0, max = 1, message = "state must be 0 or 1")
    private Integer state;

    private String valueString1;
    private String valueString2;
    private String valueString3;
    private Integer valueInt1;
    private Integer valueInt2;
    private Integer valueInt3;
    private Double valueDouble1;
    private Double valueDouble2;
    private Double valueDouble3;
}
