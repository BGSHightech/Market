package com.bgs.market.view.exception;

import lombok.Getter;
import org.springframework.validation.Errors;

@Getter
public class SOAException extends BaseException {

    private Errors errors;

    public SOAException(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }

}
