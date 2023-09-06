package com.bgs.market.view.dto.response;

import com.bgs.market.persistence.domain.Department;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetAllDepartmentsResponseDTO extends BaseResponseDTO{

    private List<Department> departments;

}
