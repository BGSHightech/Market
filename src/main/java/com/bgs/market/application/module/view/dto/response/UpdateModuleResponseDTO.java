package com.bgs.market.application.module.view.dto.response;

import com.bgs.market.application.module.persistence.Module;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for UpdateModuleResponseDTO.
 */
@Getter
@Setter
public class UpdateModuleResponseDTO extends BaseResponseDTO {
    private Module module;
}
