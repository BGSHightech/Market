package com.bgs.market.application.parameter.view.dto.response;

import com.bgs.market.application.parameter.persistence.Parameter;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 * Class for GetAllParametersResponseDTO.
 */
@Getter
@Setter
public class GetAllParametersResponseDTO extends BaseResponseDTO {
    private List<Parameter> parameters;
}
