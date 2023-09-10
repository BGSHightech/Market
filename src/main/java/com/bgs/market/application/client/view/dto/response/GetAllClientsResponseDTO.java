package com.bgs.market.application.client.view.dto.response;

import com.bgs.market.util.BaseResponseDTO;
import com.bgs.market.application.client.persistence.Client;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Class for GetAllClientsResponseDTO.
 */
@Getter
@Setter
public class GetAllClientsResponseDTO extends BaseResponseDTO {
    private List<Client> clients;
}
