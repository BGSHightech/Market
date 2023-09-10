package com.bgs.market.util;

import com.bgs.market.exception.ErrorResourceDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponseDTO {
    private String statusCode;
    private String statusMessage;
    private ErrorResourceDTO objErrorResourse;
}
