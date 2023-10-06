package com.bgs.market.application.user.view.dto.response;

import com.bgs.market.application.user.persistence.User;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Class for GetAllUsersResponseDTO.
 */
@Getter
@Setter
public class GetAllUsersResponseDTO extends BaseResponseDTO {
    private List<User> users;
}
