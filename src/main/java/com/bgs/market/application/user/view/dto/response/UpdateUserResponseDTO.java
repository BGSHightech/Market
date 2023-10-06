package com.bgs.market.application.user.view.dto.response;

import com.bgs.market.application.user.persistence.User;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * UpdateUserResponseDTO
 */
@Getter
@Setter
public class UpdateUserResponseDTO extends BaseResponseDTO {
    private User user;
}
