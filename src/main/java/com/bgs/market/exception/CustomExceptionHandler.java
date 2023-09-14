package com.bgs.market.exception;

import com.bgs.market.util.BaseResponseDTO;
import com.bgs.market.util.Errors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponseDTO handleInvalidArgument(MethodArgumentNotValidException exception) {
        BaseResponseDTO response = new BaseResponseDTO();
        List<Errors> errors = new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
            Errors error = new Errors();
            error.setField(fieldError.getField());
            error.setMessage(fieldError.getDefaultMessage());
            errors.add(error);
        });
        response.setStatusCode("99");
        response.setStatusMessage("Error in the field");
        response.setErrors(errors);
        return response;
    }
}
