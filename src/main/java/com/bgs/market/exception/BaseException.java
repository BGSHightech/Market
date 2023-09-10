package com.bgs.market.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseException extends RuntimeException {
    private Exception objException;
    private String codError;
    private String msjError;

    public BaseException() {
        super();
    }

    public BaseException(Exception objException) {
        this.objException = objException;
    }

    public BaseException(String msjError) {
        this.msjError = msjError;
    }

    public BaseException(String msjError, Exception objException) {
        super(objException);
        this.objException = objException;
        this.msjError = msjError;
    }

    public BaseException(String codError, String msjError, Exception objException) {
        super(msjError);
        this.codError = codError;
        this.msjError = msjError;
        this.objException = objException;
    }

    public String getMessage() {
        return objException != null ? objException.getMessage() : null;
    }

}
