package com.bgs.market.application.menu.service;

import com.bgs.market.application.menu.view.dto.request.CreateMenuRequestDTO;
import com.bgs.market.application.menu.view.dto.request.UpdateMenuRequestDTO;
import com.bgs.market.application.menu.view.dto.response.CreateMenuResponseDTO;
import com.bgs.market.application.menu.view.dto.response.GetAllMenusResponseDTO;
import com.bgs.market.application.menu.view.dto.response.GetMenuByIdResponseDTO;
import com.bgs.market.application.menu.view.dto.response.UpdateMenuResponseDTO;

/**
 * Class for MenuService.
 */
public interface MenuService {
    /**
     * Get list of menus.
     *
     * @return menus
     */
    GetAllMenusResponseDTO getAllMenus() throws Exception;

    /**
     * Get menu by id.
     *
     * @param menuId represents menuId
     * @return menu
     */
    GetMenuByIdResponseDTO getMenuById(Long menuId) throws Exception;

    /**
     * Create menu.
     *
     * @param request represents CreateMenuRequestDTO
     * @return menu
     */
    CreateMenuResponseDTO createMenu(CreateMenuRequestDTO request) throws Exception;

    /**
     * Update menu.
     *
     * @param request represents UpdateMenuRequestDTO
     * @param menuId  represents menuId
     * @return menu
     */
    UpdateMenuResponseDTO updateMenu(UpdateMenuRequestDTO request,
                                     Long menuId) throws Exception;
}
