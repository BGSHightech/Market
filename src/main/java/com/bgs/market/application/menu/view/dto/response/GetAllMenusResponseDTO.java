package com.bgs.market.application.menu.view.dto.response;

import com.bgs.market.application.menu.persistence.Menu;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Class for CreateMenuResponseDTO.
 */
@Getter
@Setter
public class GetAllMenusResponseDTO extends BaseResponseDTO {
    private List<Menu> menus;
}
