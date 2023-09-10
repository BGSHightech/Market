package com.bgs.market.application.department.view.dto.response;

import com.bgs.market.application.department.persistence.Department;
import com.bgs.market.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Class for GetAllDepartmentsResponseDTO.
 */
@Getter
@Setter
public class GetAllDepartmentsResponseDTO extends BaseResponseDTO {
    private List<Department> departments;
}
