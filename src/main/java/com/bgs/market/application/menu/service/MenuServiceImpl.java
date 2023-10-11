package com.bgs.market.application.menu.service;

import com.bgs.market.application.menu.persistence.Menu;
import com.bgs.market.application.menu.persistence.MenuRepository;
import com.bgs.market.application.menu.view.dto.request.CreateMenuRequestDTO;
import com.bgs.market.application.menu.view.dto.request.UpdateMenuRequestDTO;
import com.bgs.market.application.menu.view.dto.response.CreateMenuResponseDTO;
import com.bgs.market.application.menu.view.dto.response.GetAllMenusResponseDTO;
import com.bgs.market.application.menu.view.dto.response.GetMenuByIdResponseDTO;
import com.bgs.market.application.menu.view.dto.response.UpdateMenuResponseDTO;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Class for MenuServiceImpl.
 */
@Service
@AllArgsConstructor
public class MenuServiceImpl implements MenuService {
    /**
     * Instantiating repositories.
     */
    MenuRepository menuRepository;

    /**
     * Get list of menus.
     *
     * @return menus
     */
    @Override
    public GetAllMenusResponseDTO getAllMenus() throws Exception {
        // Assign value and find all menus.
        GetAllMenusResponseDTO responseDTO = new GetAllMenusResponseDTO();
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setMenus(menuRepository.findAll());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }


    /**
     * Get menu by id.
     *
     * @param menuId represents menuId
     * @return menu
     */
    @Override
    public GetMenuByIdResponseDTO getMenuById(Long menuId) throws Exception {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(menuId));
        GetMenuByIdResponseDTO responseDTO = new GetMenuByIdResponseDTO();

        // Validate if menu exists.
        Optional<Menu> optionalMenu = menuRepository.findById(menuId);
        if (optionalMenu.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The menu doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Assign values.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setMenu(optionalMenu.get());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Create menu.
     *
     * @param request represents CreateMenuRequestDTO
     * @return menu
     */
    @Override
    public CreateMenuResponseDTO createMenu(CreateMenuRequestDTO request) throws Exception {
        // Show the request in the console
        System.out.println("request = " + new Gson().toJson(request));
        CreateMenuResponseDTO responseDTO = new CreateMenuResponseDTO();

        // Assign values and save.
        Menu menu = new Menu();
        menu.setMenuName(request.getMenuName());
        Menu menuCreated = menuRepository.save(menu);

        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setMenu(menuCreated);

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Update menu.
     *
     * @param request represents UpdateMenuRequestDTO
     * @param menuId  represents menuId
     * @return menu
     */
    @Override
    public UpdateMenuResponseDTO updateMenu(UpdateMenuRequestDTO request,
                                            Long menuId) throws Exception {
        // Show the request in the console
        System.out.println("request = " + new Gson().toJson(request));
        UpdateMenuResponseDTO responseDTO = new UpdateMenuResponseDTO();

        // Validate if menu exists.
        Optional<Menu> optionalMenu = menuRepository.findById(menuId);
        if (optionalMenu.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The menu doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Assign values and save.
        Menu existingMenu = optionalMenu.get();
        existingMenu.setMenuName(request.getMenuName());
        existingMenu.setState(request.getState());
        Menu menu = menuRepository.save(existingMenu);

        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setMenu(menu);

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }
}
