package com.bgs.market.transactional.service;

import com.bgs.market.view.dto.response.GetAllProductUnitResponseDTO;
import com.bgs.market.view.exception.Exception;

public interface ProductUnitService {
    GetAllProductUnitResponseDTO getAllProductUnits() throws Exception;

}
