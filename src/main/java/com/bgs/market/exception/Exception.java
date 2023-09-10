package com.bgs.market.exception;

import lombok.Getter;
import org.springframework.validation.Errors;

@Getter
public class Exception extends BaseException {
    private Errors errors;

    public Exception(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }
}
