package com.bgs.market.application.department.service;

import com.bgs.market.application.department.view.dto.response.GetAllDepartmentsResponseDTO;
import com.bgs.market.application.department.view.dto.response.GetDepartmentByIdResponseDTO;

/**
 * Class for DepartmentService.
 */
public interface DepartmentService {
    /**
     * Get list of departments.
     *
     * @return departments
     */
    GetAllDepartmentsResponseDTO getAllDepartments() throws Exception;

    /**
     * Get department by id.
     *
     * @param departmentId represents departmentId
     * @return departments
     */
    GetDepartmentByIdResponseDTO getDepartmentById(String departmentId) throws Exception;
}
