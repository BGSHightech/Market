package com.bgs.market.transactional.service;

import com.bgs.market.view.dto.response.GetAllDepartmentsResponseDTO;
import com.bgs.market.view.exception.Exception;

public interface DepartmentService {

    GetAllDepartmentsResponseDTO getAllDepartments() throws Exception;

}
