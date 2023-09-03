package com.bgs.market.view.dto.response;

import com.bgs.market.view.exception.ErrorResourceDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponseDTO {
    private String statusCode;
    private String statusMessage;
    private ErrorResourceDTO objErrorResourse;
}
