package com.bgs.market.application.menu.view.controller;

import com.bgs.market.application.menu.service.MenuService;
import com.bgs.market.application.menu.view.dto.request.CreateMenuRequestDTO;
import com.bgs.market.application.menu.view.dto.request.UpdateMenuRequestDTO;
import com.bgs.market.application.menu.view.dto.response.CreateMenuResponseDTO;
import com.bgs.market.application.menu.view.dto.response.GetAllMenusResponseDTO;
import com.bgs.market.application.menu.view.dto.response.GetMenuByIdResponseDTO;
import com.bgs.market.application.menu.view.dto.response.UpdateMenuResponseDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class for MenuController.
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/menu")
public class MenuController {
    private MenuService menuService;

    /**
     * Get list of menus.
     *
     * @return menus
     */
    @GetMapping
    public GetAllMenusResponseDTO getAllMenus() throws Exception {
        return menuService.getAllMenus();
    }

    /**
     * Get menu by id.
     *
     * @param menuId represents menuId
     * @return menu
     */
    @GetMapping("{menuId}")
    public GetMenuByIdResponseDTO getMenuById(@PathVariable("menuId") Long menuId) throws Exception {
        return menuService.getMenuById(menuId);
    }

    /**
     * Create menu.
     *
     * @param request represents CreateMenuRequestDTO
     * @return menu
     */

    @PostMapping
    public CreateMenuResponseDTO createMenu(@Valid @RequestBody CreateMenuRequestDTO request) throws Exception {
        return menuService.createMenu(request);
    }

    /**
     * Update menu.
     *
     * @param menuId  represents menuId
     * @param request represents UpdateMenuRequestDTO
     * @return menu
     */
    @PutMapping("{menuId}")
    public UpdateMenuResponseDTO updateMenuResponseDTO(@PathVariable("menuId") Long menuId,
                                                       @Valid @RequestBody UpdateMenuRequestDTO request) throws Exception {
        return menuService.updateMenu(request, menuId);
    }
}
