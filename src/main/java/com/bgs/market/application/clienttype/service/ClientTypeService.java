package com.bgs.market.application.clienttype.service;

import com.bgs.market.application.clienttype.view.dto.request.CreateClientTypeRequestDTO;
import com.bgs.market.application.clienttype.view.dto.request.UpdateClientTypeRequestDTO;
import com.bgs.market.application.clienttype.view.dto.response.CreateClientTypeResponseDTO;
import com.bgs.market.application.clienttype.view.dto.response.GetAllClientTypesResponseDTO;
import com.bgs.market.application.clienttype.view.dto.response.UpdateClientTypeResponseDTO;
import com.bgs.market.exception.Exception;

/**
 * Class for ClientTypeService.
 */
public interface ClientTypeService {
    /**
     * Get list of client types.
     *
     * @return client types
     */
    GetAllClientTypesResponseDTO getAllClientTypes() throws Exception;

    /**
     * Create client type.
     *
     * @param request represents CreateClientTypeRequestDTO
     * @return client type
     */
    CreateClientTypeResponseDTO createClientType(CreateClientTypeRequestDTO request) throws Exception;

    /**
     * Update client type.
     *
     * @param request represents UpdateClientTypeRequestDTO
     * @return client type
     */
    UpdateClientTypeResponseDTO updateClientType(UpdateClientTypeRequestDTO request) throws Exception;
}
