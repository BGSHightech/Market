package com.bgs.market.application.client.service;

import com.bgs.market.application.client.view.dto.request.CreateClientRequestDTO;
import com.bgs.market.application.client.view.dto.request.UpdateClientRequestDTO;
import com.bgs.market.application.client.view.dto.response.CreateClientResponseDTO;
import com.bgs.market.application.client.view.dto.response.GetAllClientsResponseDTO;
import com.bgs.market.application.client.view.dto.response.GetClientByIdResponseDTO;
import com.bgs.market.application.client.view.dto.response.UpdateClientResponseDTO;

/**
 * Class for ClientService.
 */
public interface ClientService {
    /**
     * Get list of clients.
     *
     * @return clients
     */
    GetAllClientsResponseDTO getAllClients() throws Exception;

    /**
     * Get client by id.
     *
     * @param clientId represents clientId
     * @return client
     */
    GetClientByIdResponseDTO getClientById(Long clientId) throws Exception;

    /**
     * Create client.
     *
     * @param request represents CreateClientRequestDTO
     * @return client
     */
    CreateClientResponseDTO createClient(CreateClientRequestDTO request) throws Exception;

    /**
     * Update client.
     *
     * @param request  represents UpdateClientRequestDTO
     * @param clientId represents clientId
     * @return client
     */
    UpdateClientResponseDTO updateClient(UpdateClientRequestDTO request,
                                         Long clientId) throws Exception;
}
