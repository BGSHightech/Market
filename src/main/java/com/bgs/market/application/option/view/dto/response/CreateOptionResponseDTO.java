package com.bgs.market.application.option.view.dto.response;

import com.bgs.market.application.option.persistence.Option;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for CreateOptionResponseDTO.
 */
@Getter
@Setter
public class CreateOptionResponseDTO extends BaseResponseDTO {
    private Option option;
}
