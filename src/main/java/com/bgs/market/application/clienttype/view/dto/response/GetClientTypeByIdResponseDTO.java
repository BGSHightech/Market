package com.bgs.market.application.clienttype.view.dto.response;

import com.bgs.market.application.clienttype.persistence.ClientType;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for GetClientTypeByIdResponseDTO.
 */
@Getter
@Setter
public class GetClientTypeByIdResponseDTO extends BaseResponseDTO {
    public ClientType clientType;
}
