package com.bgs.market.application.clienttype.view.dto.response;

import com.bgs.market.util.BaseResponseDTO;
import com.bgs.market.application.clienttype.persistence.ClientType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Class for GetAllClientTypesResponseDTO.
 */
@Getter
@Setter
public class GetAllClientTypesResponseDTO extends BaseResponseDTO {
    private List<ClientType> clientTypes;
}
