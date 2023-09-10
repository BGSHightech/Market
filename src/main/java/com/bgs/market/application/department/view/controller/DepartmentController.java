package com.bgs.market.application.department.view.controller;

import com.bgs.market.application.department.service.DepartmentService;
import com.bgs.market.application.department.view.dto.response.GetAllDepartmentsResponseDTO;
import com.bgs.market.application.department.view.dto.response.GetDepartmentByIdResponseDTO;
import com.bgs.market.exception.Exception;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class for DepartmentController.
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/department")
public class DepartmentController {
    private DepartmentService departmentService;

    /**
     * Get list of departments.
     *
     * @return departments
     */
    @GetMapping
    public GetAllDepartmentsResponseDTO getAllDepartments() throws Exception {
        return departmentService.getAllDepartments();
    }

    /**
     * Get list of departments by id.
     *
     * @param departmentId represents departmentId
     * @return departments
     */
    @GetMapping("{id}")
    public GetDepartmentByIdResponseDTO getDepartmentById(@PathVariable("id") String departmentId) throws Exception {
        return departmentService.getDepartmentById(departmentId);
    }
}
