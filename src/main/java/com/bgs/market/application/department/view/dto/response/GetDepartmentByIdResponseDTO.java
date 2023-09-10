package com.bgs.market.application.department.view.dto.response;

import com.bgs.market.application.department.persistence.Department;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for GetDepartmentByIdResponseDTO.
 */
@Getter
@Setter
public class GetDepartmentByIdResponseDTO extends BaseResponseDTO {
    private Department department;
}
