package com.bgs.market.application.parameter.view.dto.response;

import com.bgs.market.application.parameter.persistence.Parameter;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for UpdateParameterResponseDTO.
 */
@Getter
@Setter
public class UpdateParameterResponseDTO extends BaseResponseDTO {
    private Parameter parameter;
}
