package com.bgs.market.application.client.view.dto.response;

import com.bgs.market.application.client.persistence.Client;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for GetClientByIdResponseDTO.
 */
@Getter
@Setter
public class GetClientByIdResponseDTO extends BaseResponseDTO {
    private Client client;
}
