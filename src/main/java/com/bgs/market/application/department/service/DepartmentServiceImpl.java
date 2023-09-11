package com.bgs.market.application.department.service;

import com.bgs.market.application.department.persistence.Department;
import com.bgs.market.application.department.persistence.DepartmentRepository;
import com.bgs.market.application.department.view.dto.response.GetAllDepartmentsResponseDTO;
import com.bgs.market.application.department.view.dto.response.GetDepartmentByIdResponseDTO;
import com.bgs.market.exception.Exception;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Class for DepartmentServiceImpl.
 */
@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    /**
     * Instantiating repositories.
     */
    private DepartmentRepository departmentRepository;

    /**
     * Get list of departments.
     *
     * @return departments
     */
    @Override
    public GetAllDepartmentsResponseDTO getAllDepartments() throws Exception {
        // Assign value and find all departments.
        GetAllDepartmentsResponseDTO responseDTO = new GetAllDepartmentsResponseDTO();
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setDepartments(departmentRepository.findAll());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Get department by id.
     *
     * @param departmentId represents departmentId
     * @return departments
     */
    @Override
    public GetDepartmentByIdResponseDTO getDepartmentById(String departmentId) {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(departmentId));
        GetDepartmentByIdResponseDTO responseDTO = new GetDepartmentByIdResponseDTO();

        // Verify if department exists
        Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);
        if (optionalDepartment.isEmpty()) {
            responseDTO.setStatusCode("02");
            responseDTO.setStatusMessage("The department doesn't exists");
            return responseDTO;
        }

        // Assign values.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setDepartment(optionalDepartment.get());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }
}
