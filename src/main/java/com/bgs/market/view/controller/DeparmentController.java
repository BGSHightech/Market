package com.bgs.market.view.controller;


import com.bgs.market.transactional.service.DepartmentService;
import com.bgs.market.view.dto.response.GetAllDepartmentsResponseDTO;
import com.bgs.market.view.exception.Exception;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/deparment")
public class DeparmentController {

    private DepartmentService departmentService;

    @GetMapping
    public GetAllDepartmentsResponseDTO getAllDepartments() throws Exception {
        return departmentService.getAllDepartments();
    }

}
