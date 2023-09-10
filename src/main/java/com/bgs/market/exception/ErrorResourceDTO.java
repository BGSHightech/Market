package com.bgs.market.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ErrorResourceDTO {

    private String code;
    private String message;
    private List<FieldErrorResourceDTO> fieldErrors;

    public ErrorResourceDTO(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
