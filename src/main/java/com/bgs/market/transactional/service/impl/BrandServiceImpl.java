package com.bgs.market.transactional.service.impl;

import com.bgs.market.persistence.domain.Brand;
import com.bgs.market.persistence.repository.BrandRepository;
import com.bgs.market.transactional.service.BrandService;
import com.bgs.market.view.dto.request.CreateBrandRequestDTO;
import com.bgs.market.view.dto.request.UpdateBrandRequestDTO;
import com.bgs.market.view.dto.response.CreateBrandResponseDTO;
import com.bgs.market.view.dto.response.GetAllBrandsResponseDTO;
import com.bgs.market.view.dto.response.UpdateBrandResponseDTO;
import com.bgs.market.view.exception.Exception;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandServiceImpl implements BrandService {
    BrandRepository brandRepository;

    @Override
    public CreateBrandResponseDTO createBrand(CreateBrandRequestDTO request) throws Exception {
        System.out.println("request = " + new Gson().toJson(request));

        Brand brand = new Brand();
        brand.setBrandName(request.getBrandName());
        Brand brandCreated = brandRepository.save(brand);

        CreateBrandResponseDTO responseDTO = new CreateBrandResponseDTO();
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setBrand(brandCreated);
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    @Override
    public UpdateBrandResponseDTO updateBrand(UpdateBrandRequestDTO request) throws Exception {
        System.out.println("request = " + new Gson().toJson(request));

        Brand existingBrand = brandRepository.findById(request.getBrandId()).get();
        existingBrand.setBrandId(request.getBrandId());
        existingBrand.setBrandName(request.getBrandName());
        existingBrand.setState(request.getState());
        Brand brand = brandRepository.save(existingBrand);

        UpdateBrandResponseDTO responseDTO = new UpdateBrandResponseDTO();
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setBrand(brand);
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    @Override
    public GetAllBrandsResponseDTO getAllBrands() throws Exception {
        GetAllBrandsResponseDTO responseDTO = new GetAllBrandsResponseDTO();
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setBrands(brandRepository.findAll());
        System.out.println("_response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }
}
