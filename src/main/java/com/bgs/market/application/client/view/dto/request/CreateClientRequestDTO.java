package com.bgs.market.application.client.view.dto.request;

import lombok.Getter;
import lombok.Setter;

/**
 * Class for CreateClientRequestDTO.
 */
@Getter
@Setter
public class CreateClientRequestDTO {
    private Long clientTypeId;
    private String clientName;
    private Long documentType;
    private String documentNumber;
    private String clientDirection;
    private String ubigeo;
    private String phoneNumber;
    private String clientEmail;
}
