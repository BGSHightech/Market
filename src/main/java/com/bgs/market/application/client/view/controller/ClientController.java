package com.bgs.market.application.client.view.controller;

import com.bgs.market.application.client.service.ClientService;
import com.bgs.market.application.client.view.dto.request.CreateClientRequestDTO;
import com.bgs.market.application.client.view.dto.request.UpdateClientRequestDTO;
import com.bgs.market.application.client.view.dto.response.CreateClientResponseDTO;
import com.bgs.market.application.client.view.dto.response.GetAllClientsResponseDTO;
import com.bgs.market.application.client.view.dto.response.GetClientByIdResponseDTO;
import com.bgs.market.application.client.view.dto.response.UpdateClientResponseDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Class for ClientController.
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/client")
public class ClientController {
    private ClientService clientService;

    /**
     * Get list of clients.
     *
     * @return clients
     */
    @GetMapping()
    public GetAllClientsResponseDTO getAllClients() throws Exception {
        return clientService.getAllClients();
    }

    /**
     * Get client by id.
     *
     * @param clientId represents clientId
     * @return client
     */
    @GetMapping("{clientId}")
    public GetClientByIdResponseDTO getClientById(@PathVariable("clientId") Long clientId) throws Exception {
        return clientService.getClientById(clientId);
    }

    /**
     * Create client.
     *
     * @param request represents CreateClientRequestDTO
     * @return client
     */
    @PostMapping()
    public CreateClientResponseDTO createClient(@Valid @RequestBody CreateClientRequestDTO request) throws Exception {
        return clientService.createClient(request);
    }


    /**
     * Update client.
     *
     * @param clientId represents clientId
     * @param request  represents UpdateClientRequestDTO
     * @return client
     */
    @PutMapping("{clientId}")
    public UpdateClientResponseDTO updateClient(@PathVariable("clientId") Long clientId,
                                                @Valid @RequestBody UpdateClientRequestDTO request) throws Exception {
        return clientService.updateClient(request, clientId);
    }
}
