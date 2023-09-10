package com.bgs.market.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldErrorResourceDTO {

    private String resource;
    private String field;
    private String code;
    private String message;

}
