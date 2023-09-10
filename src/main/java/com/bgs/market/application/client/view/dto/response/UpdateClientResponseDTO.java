package com.bgs.market.application.client.view.dto.response;

import com.bgs.market.util.BaseResponseDTO;
import com.bgs.market.application.client.persistence.Client;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for UpdateClientResponseDTO.
 */
@Getter
@Setter
public class UpdateClientResponseDTO extends BaseResponseDTO {
    private Client client;
}
