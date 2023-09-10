package com.bgs.market.application.client.service;

import com.bgs.market.application.client.view.dto.request.CreateClientRequestDTO;
import com.bgs.market.application.client.view.dto.request.UpdateClientRequestDTO;
import com.bgs.market.application.client.view.dto.response.CreateClientResponseDTO;
import com.bgs.market.application.client.view.dto.response.GetAllClientsResponseDTO;
import com.bgs.market.application.client.view.dto.response.UpdateClientResponseDTO;
import com.bgs.market.exception.Exception;

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
     * Create client.
     *
     * @param request represents CreateClientRequestDTO
     * @return client
     */
    CreateClientResponseDTO createClient(CreateClientRequestDTO request) throws Exception;

    /**
     * Update client.
     *
     * @param request represents UpdateClientRequestDTO
     * @return client
     */
    UpdateClientResponseDTO updateClient(UpdateClientRequestDTO request) throws Exception;
}
