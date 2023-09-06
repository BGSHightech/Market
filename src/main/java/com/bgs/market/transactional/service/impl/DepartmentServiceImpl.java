package com.bgs.market.transactional.service.impl;

import com.bgs.market.persistence.repository.DepartmentRepository;
import com.bgs.market.transactional.service.DepartmentService;
import com.bgs.market.view.dto.response.GetAllDepartmentsResponseDTO;
import com.bgs.market.view.exception.Exception;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    @Override
    public GetAllDepartmentsResponseDTO getAllDepartments() throws Exception {

        GetAllDepartmentsResponseDTO responseDTO = new GetAllDepartmentsResponseDTO();
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setDepartments(departmentRepository.findAll());
        System.out.println("_response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }
}
