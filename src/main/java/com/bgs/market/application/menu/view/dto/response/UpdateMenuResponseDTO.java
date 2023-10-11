package com.bgs.market.application.menu.view.dto.response;

import com.bgs.market.application.menu.persistence.Menu;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for UpdateMenuResponseDTO.
 */
@Getter
@Setter
public class UpdateMenuResponseDTO extends BaseResponseDTO {
    private Menu menu;
}
