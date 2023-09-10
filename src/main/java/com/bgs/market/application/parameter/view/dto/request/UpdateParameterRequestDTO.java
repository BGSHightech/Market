package com.bgs.market.application.parameter.view.dto.request;

import lombok.Getter;
import lombok.Setter;

/**
 * Class for UpdateParameterRequestDTO.
 */
@Getter
@Setter
public class UpdateParameterRequestDTO {
    private Long parameterId;
    private String parameterType;
    private String value;
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
