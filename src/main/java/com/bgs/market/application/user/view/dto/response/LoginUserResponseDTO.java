package com.bgs.market.application.user.view.dto.response;

import com.bgs.market.application.user.persistence.User;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for LoginUserResponseDTO.
 */
@Getter
@Setter
public class LoginUserResponseDTO extends BaseResponseDTO {
    private User user;
}
