package com.bgs.market.application.parameter.view.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for CreateParameterRequestDTO.
 */
@Getter
@Setter
public class CreateParameterRequestDTO {
    @NotBlank(message = "parameterType should not be null")
    private String parameterType;

    @NotBlank(message = "value should not be null")
    private String value;

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
