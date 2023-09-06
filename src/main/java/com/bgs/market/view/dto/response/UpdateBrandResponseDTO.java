package com.bgs.market.view.dto.response;

import com.bgs.market.persistence.domain.Brand;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBrandResponseDTO extends BaseResponseDTO {
    private Brand brand;
}
