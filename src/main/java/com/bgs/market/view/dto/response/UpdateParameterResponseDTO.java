package com.bgs.market.view.dto.response;

import com.bgs.market.persistence.domain.Parameter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateParameterResponseDTO extends BaseResponseDTO{
    private Parameter parameter;
}
