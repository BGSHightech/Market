package com.bgs.market.application.brand.service;

import com.bgs.market.application.brand.persistence.Brand;
import com.bgs.market.application.brand.view.dto.response.GetBrandByIdResponseDTO;
import com.bgs.market.application.subfamily.persistence.SubFamily;
import com.bgs.market.application.brand.persistence.BrandRepository;
import com.bgs.market.application.subfamily.persistence.SubFamilyRepository;
import com.bgs.market.application.brand.view.dto.request.CreateBrandRequestDTO;
import com.bgs.market.application.brand.view.dto.request.UpdateBrandRequestDTO;
import com.bgs.market.application.brand.view.dto.response.CreateBrandResponseDTO;
import com.bgs.market.application.brand.view.dto.response.GetAllBrandsResponseDTO;
import com.bgs.market.application.brand.view.dto.response.UpdateBrandResponseDTO;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Class for BrandServiceImpl.
 */
@Service
@AllArgsConstructor
public class BrandServiceImpl implements BrandService {
    /**
     * Instantiating repositories.
     */
    BrandRepository brandRepository;
    SubFamilyRepository subFamilyRepository;

    /**
     * Get list of brands.
     *
     * @return brands
     */
    @Override
    public GetAllBrandsResponseDTO getAllBrands() {
        // Assign value and find all brands.
        GetAllBrandsResponseDTO responseDTO = new GetAllBrandsResponseDTO();
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setBrands(brandRepository.findAll());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Get brand by id.
     *
     * @param brandId represents brandId
     * @return brand
     */
    @Override
    public GetBrandByIdResponseDTO getBrandById(Long brandId) {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(brandId));
        GetBrandByIdResponseDTO responseDTO = new GetBrandByIdResponseDTO();

        // Validate if brand exists.
        Optional<Brand> optionalBrand = brandRepository.findById(brandId);
        if (optionalBrand.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The brand doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Assign values.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setBrand(optionalBrand.get());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Create brand.
     *
     * @param request represents CreateBrandRequestDTO
     * @return brand.
     */
    @Override
    public CreateBrandResponseDTO createBrand(CreateBrandRequestDTO request) {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(request));
        CreateBrandResponseDTO responseDTO = new CreateBrandResponseDTO();

        // Validate if subFamily exists.
        Optional<SubFamily> optionalSubFamily = subFamilyRepository.findById(request.getSubFamilyId());
        if (optionalSubFamily.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The subFamily doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Assign values and save.
        Brand brand = new Brand();
        brand.setBrandName(request.getBrandName());
        brand.setSubFamilyId(request.getSubFamilyId());
        Brand brandCreated = brandRepository.save(brand);

        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setBrand(brandCreated);

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Update brand.
     *
     * @param request represents UpdateBrandRequestDTO
     * @param brandId represents brandId
     * @return brand
     */
    @Override
    public UpdateBrandResponseDTO updateBrand(UpdateBrandRequestDTO request,
                                              Long brandId) {
        // Show the request in the console
        System.out.println("request = " + new Gson().toJson(request));
        UpdateBrandResponseDTO responseDTO = new UpdateBrandResponseDTO();

        // Validate if brand exists.
        Optional<Brand> optionalBrand = brandRepository.findById(brandId);
        if (optionalBrand.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The brand doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Validate if subFamily exists.
        Optional<SubFamily> optionalSubFamily = subFamilyRepository.findById(request.getSubFamilyId());
        if (optionalSubFamily.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The subFamily doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Assign values and save.
        Brand existingBrand = optionalBrand.get();
        existingBrand.setBrandName(request.getBrandName());
        existingBrand.setState(request.getState());
        existingBrand.setSubFamilyId(request.getSubFamilyId());
        Brand brand = brandRepository.save(existingBrand);

        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setBrand(brand);

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }
}
