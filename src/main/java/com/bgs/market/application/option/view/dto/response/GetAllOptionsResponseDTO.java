package com.bgs.market.application.option.view.dto.response;

import com.bgs.market.application.option.persistence.Option;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Class for CreateOptionResponseDTO.
 */
@Getter
@Setter
public class GetAllOptionsResponseDTO extends BaseResponseDTO {
    private List<Option> options;
}
