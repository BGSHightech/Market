package com.bgs.market.application.clienttype.view.dto.response;

import com.bgs.market.util.BaseResponseDTO;
import com.bgs.market.application.clienttype.persistence.ClientType;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for UpdateClientTypeResponseDTO.
 */
@Getter
@Setter
public class UpdateClientTypeResponseDTO extends BaseResponseDTO {
    private ClientType clientType;
}
