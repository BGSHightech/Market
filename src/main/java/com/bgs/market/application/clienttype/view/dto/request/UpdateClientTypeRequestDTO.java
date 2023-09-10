package com.bgs.market.application.clienttype.view.dto.request;

import lombok.Getter;
import lombok.Setter;

/**
 * Class for UpdateClientTypeRequestDTO.
 */
@Getter
@Setter
public class UpdateClientTypeRequestDTO {
    private Long clientTypeId;
    private String clientTypeName;
    private Integer state;
}
