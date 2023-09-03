package com.bgs.market.view.dto.response;

import com.bgs.market.persistence.domain.Parameter;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetAllParametersResponseDTO extends BaseResponseDTO {

    private List<Parameter> parameters;
}
