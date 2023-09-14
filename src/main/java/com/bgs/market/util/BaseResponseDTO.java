package com.bgs.market.util;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Class for BaseResponseDTO.
 */
@Getter
@Setter
public class BaseResponseDTO {
    private String statusCode;
    private String statusMessage;
    private List<Errors> errors;
}
