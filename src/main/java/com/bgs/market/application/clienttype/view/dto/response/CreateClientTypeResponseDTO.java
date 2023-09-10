package com.bgs.market.application.clienttype.view.dto.response;

import com.bgs.market.util.BaseResponseDTO;
import com.bgs.market.application.clienttype.persistence.ClientType;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for CreateClientTypeResponseDTO.
 */
@Getter
@Setter
public class CreateClientTypeResponseDTO extends BaseResponseDTO {
    private ClientType clientType;
}
