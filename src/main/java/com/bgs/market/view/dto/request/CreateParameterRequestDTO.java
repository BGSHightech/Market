package com.bgs.market.view.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateParameterRequestDTO {
    private String parameterType;
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
