package com.bgs.market.application.module.view.dto.response;

import com.bgs.market.application.module.persistence.Module;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Class for GetAllModulesResponseDTO.
 */
@Getter
@Setter
public class GetAllModulesResponseDTO extends BaseResponseDTO {
    private List<Module> modules;
}
