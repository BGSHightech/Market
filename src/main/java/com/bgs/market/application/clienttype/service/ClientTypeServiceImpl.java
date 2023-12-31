package com.bgs.market.application.clienttype.service;

import com.bgs.market.application.clienttype.persistence.ClientType;
import com.bgs.market.application.clienttype.persistence.ClientTypeRepository;
import com.bgs.market.application.clienttype.view.dto.request.CreateClientTypeRequestDTO;
import com.bgs.market.application.clienttype.view.dto.request.UpdateClientTypeRequestDTO;
import com.bgs.market.application.clienttype.view.dto.response.CreateClientTypeResponseDTO;
import com.bgs.market.application.clienttype.view.dto.response.GetAllClientTypesResponseDTO;
import com.bgs.market.application.clienttype.view.dto.response.GetClientTypeByIdResponseDTO;
import com.bgs.market.application.clienttype.view.dto.response.UpdateClientTypeResponseDTO;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Class for ClientTypeServiceImpl.
 */
@Service
@AllArgsConstructor
public class ClientTypeServiceImpl implements ClientTypeService {
    /**
     * Instantiating repositories.
     */
    ClientTypeRepository clientTypeRepository;

    /**
     * Get list of client types.
     *
     * @return client types
     */
    @Override
    public GetAllClientTypesResponseDTO getAllClientTypes() {
        // Assign value and find all client types.
        GetAllClientTypesResponseDTO responseDTO = new GetAllClientTypesResponseDTO();
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setClientTypes(clientTypeRepository.findAll());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Get client type by id.
     *
     * @param clientTypeId represents clientTypeId
     * @return client type
     */
    @Override
    public GetClientTypeByIdResponseDTO getClientTypeById(Long clientTypeId) {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(clientTypeId));
        GetClientTypeByIdResponseDTO responseDTO = new GetClientTypeByIdResponseDTO();

        // Validate if client type exists.
        Optional<ClientType> optionalClientType = clientTypeRepository.findById(clientTypeId);
        if (optionalClientType.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The client type doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Assign values.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setClientType(optionalClientType.get());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Create client type.
     *
     * @param request represents CreateClientTypeRequestDTO
     * @return client type
     */
    @Override
    public CreateClientTypeResponseDTO createClientType(CreateClientTypeRequestDTO request) {
        // Assign value and find all clients.
        System.out.println("request = " + new Gson().toJson(request));
        CreateClientTypeResponseDTO responseDTO = new CreateClientTypeResponseDTO();

        // Assign values and save.
        ClientType clientType = new ClientType();
        clientType.setClientTypeName(request.getClientTypeName());
        ClientType clientTypeCreated = clientTypeRepository.save(clientType);

        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setClientType(clientTypeCreated);

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Update client type.
     *
     * @param request      represents UpdateClientTypeRequestDTO
     * @param clientTypeId represents clientTypeId
     * @return client type
     */
    @Override
    public UpdateClientTypeResponseDTO updateClientType(UpdateClientTypeRequestDTO request,
                                                        Long clientTypeId) {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(request));
        UpdateClientTypeResponseDTO responseDTO = new UpdateClientTypeResponseDTO();

        // Verify if client type exists
        Optional<ClientType> optionalClientType = clientTypeRepository.findById(clientTypeId);
        if (optionalClientType.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The client type doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Assign values and save.
        ClientType existingClientType = optionalClientType.get();
        existingClientType.setClientTypeName(request.getClientTypeName());
        existingClientType.setState(request.getState());
        ClientType clientType = clientTypeRepository.save(existingClientType);

        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setClientType(clientType);

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }
}
