package com.bgs.market.application.clienttype.view.controller;

import com.bgs.market.application.clienttype.service.ClientTypeService;
import com.bgs.market.application.clienttype.view.dto.request.CreateClientTypeRequestDTO;
import com.bgs.market.application.clienttype.view.dto.request.UpdateClientTypeRequestDTO;
import com.bgs.market.application.clienttype.view.dto.response.CreateClientTypeResponseDTO;
import com.bgs.market.application.clienttype.view.dto.response.GetAllClientTypesResponseDTO;
import com.bgs.market.application.clienttype.view.dto.response.GetClientTypeByIdResponseDTO;
import com.bgs.market.application.clienttype.view.dto.response.UpdateClientTypeResponseDTO;
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
 * Class for ClientTypeController.
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/client-type")
public class ClientTypeController {
    private ClientTypeService clientTypeService;

    /**
     * Get list of client types.
     *
     * @return client types
     */
    @GetMapping
    public GetAllClientTypesResponseDTO getAllClientTypes() throws Exception {
        return clientTypeService.getAllClientTypes();
    }

    /**
     * Get client type by id.
     *
     * @param clientTypeId represents clientTypeId
     * @return client type
     */
    @GetMapping("{clientTypeId}")
    public GetClientTypeByIdResponseDTO getClientTypeById(@PathVariable("clientTypeId") Long clientTypeId) throws Exception {
        return clientTypeService.getClientTypeById(clientTypeId);
    }

    /**
     * Create client type.
     *
     * @param request represents CreateClientTypeRequestDTO
     * @return client type
     */
    @PostMapping
    public CreateClientTypeResponseDTO createClientType(@Valid @RequestBody CreateClientTypeRequestDTO request) throws Exception {
        return clientTypeService.createClientType(request);
    }

    /**
     * Update client type
     *
     * @param clientTypeId represents clientTypeId
     * @param request      represents UpdateClientTypeRequestDTO
     * @return client type
     */
    @PutMapping("{clientTypeId}")
    public UpdateClientTypeResponseDTO updateClientType(@PathVariable("clientTypeId") Long clientTypeId,
                                                        @Valid @RequestBody UpdateClientTypeRequestDTO request) throws Exception {
        return clientTypeService.updateClientType(request, clientTypeId);
    }

}
