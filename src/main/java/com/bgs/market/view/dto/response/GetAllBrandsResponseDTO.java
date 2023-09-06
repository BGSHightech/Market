package com.bgs.market.view.dto.response;

import com.bgs.market.persistence.domain.Brand;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class GetAllBrandsResponseDTO extends BaseResponseDTO {
    private List<Brand> brands;
}
