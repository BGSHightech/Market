package com.bgs.market.application.menu.view.dto.response;

import com.bgs.market.application.menu.persistence.Menu;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for CreateMenuResponseDTO.
 */
@Getter
@Setter
public class CreateMenuResponseDTO extends BaseResponseDTO {
    private Menu menu;
}
