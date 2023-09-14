package com.bgs.market.application.client.service;

import com.bgs.market.application.client.persistence.Client;
import com.bgs.market.application.client.persistence.ClientRepository;
import com.bgs.market.application.client.view.dto.request.CreateClientRequestDTO;
import com.bgs.market.application.client.view.dto.request.UpdateClientRequestDTO;
import com.bgs.market.application.client.view.dto.response.CreateClientResponseDTO;
import com.bgs.market.application.client.view.dto.response.GetAllClientsResponseDTO;
import com.bgs.market.application.client.view.dto.response.GetClientByIdResponseDTO;
import com.bgs.market.application.client.view.dto.response.UpdateClientResponseDTO;
import com.bgs.market.application.clienttype.persistence.ClientType;
import com.bgs.market.application.clienttype.persistence.ClientTypeRepository;
import com.bgs.market.application.district.persistence.District;
import com.bgs.market.application.district.persistence.DistrictRepository;
import com.bgs.market.application.parameter.persistence.Parameter;
import com.bgs.market.application.parameter.persistence.ParameterRepository;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Class for ClientServiceImpl.
 */
@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    /**
     * Instantiating repositories.
     */
    ClientRepository clientRepository;
    ParameterRepository parameterRepository;
    ClientTypeRepository clientTypeRepository;
    DistrictRepository districtRepository;

    /**
     * Get list of clients.
     *
     * @return clients
     */
    @Override
    public GetAllClientsResponseDTO getAllClients() {
        // Assign value and find all clients.
        GetAllClientsResponseDTO responseDTO = new GetAllClientsResponseDTO();
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setClients(clientRepository.findAll());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Get client by id.
     *
     * @param clientId represents clientId
     * @return client
     */
    @Override
    public GetClientByIdResponseDTO getClientById(Long clientId) {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(clientId));
        GetClientByIdResponseDTO responseDTO = new GetClientByIdResponseDTO();

        // Validate if client exists.
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        if (optionalClient.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The client doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Assign values.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setClient(optionalClient.get());

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Create client.
     *
     * @param request represents CreateClientRequestDTO
     * @return client
     */
    @Override
    public CreateClientResponseDTO createClient(CreateClientRequestDTO request) {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(request));
        CreateClientResponseDTO responseDTO = new CreateClientResponseDTO();

        // Validate if client type exists
        Optional<ClientType> optionalClientType = clientTypeRepository.findById(request.getClientTypeId());
        if (optionalClientType.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The client type doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Validate if document type exists
        List<Parameter> documentTypes = parameterRepository.getAllParametersByTypeQuery("Tipo de documento de identidad");
        boolean documentTypeExists = documentTypes
                .stream()
                .anyMatch(d -> d.getParameterId().equals(request.getDocumentType()));
        if (!documentTypeExists) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The document type doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // If ubigeo is blank or null it will be null
        if (request.getUbigeo() == null || request.getUbigeo().isBlank()) {
            request.setUbigeo(null);
        } else {
            // Validate if ubigeo exists
            Optional<District> optionalDistrict = districtRepository.findById(request.getUbigeo());
            if (optionalDistrict.isEmpty()) {
                responseDTO.setStatusCode("99");
                responseDTO.setStatusMessage("The district doesn't exists");
                System.out.println("response = " + new Gson().toJson(responseDTO));
                return responseDTO;
            }
        }

        // Assign values and save.
        Client client = new Client();
        client.setClientTypeId(request.getClientTypeId());
        client.setClientName(request.getClientName());
        client.setDocumentType(request.getDocumentType());
        client.setDocumentNumber(request.getDocumentNumber());
        client.setClientDirection(request.getClientDirection());
        client.setUbigeo(request.getUbigeo());
        client.setPhoneNumber(request.getPhoneNumber());
        client.setClientEmail(request.getClientEmail());
        Client clientCreated = clientRepository.save(client);

        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setClient(clientCreated);

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }

    /**
     * Update client.
     *
     * @param request  represents UpdateClientRequestDTO
     * @param clientId represents clientId
     * @return client
     */
    @Override
    public UpdateClientResponseDTO updateClient(UpdateClientRequestDTO request,
                                                Long clientId) {
        // Show the request in the console.
        System.out.println("request = " + new Gson().toJson(request));
        UpdateClientResponseDTO responseDTO = new UpdateClientResponseDTO();

        // Validate if client exists
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        if (optionalClient.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The client doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Validate if client type exists
        Optional<ClientType> optionalClientType = clientTypeRepository.findById(request.getClientTypeId());
        if (optionalClientType.isEmpty()) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The client type doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // Validate if document type exists
        List<Parameter> documentTypes = parameterRepository.getAllParametersByTypeQuery("Tipo de documento de identidad");
        boolean documentTypeExists = documentTypes
                .stream()
                .anyMatch(d -> d.getParameterId().equals(request.getDocumentType()));
        if (!documentTypeExists) {
            responseDTO.setStatusCode("99");
            responseDTO.setStatusMessage("The document type doesn't exists");
            System.out.println("response = " + new Gson().toJson(responseDTO));
            return responseDTO;
        }

        // If ubigeo is blank or null it will be null
        if (request.getUbigeo() == null || request.getUbigeo().isBlank()) {
            request.setUbigeo(null);
        } else {
            // Validate if ubigeo exists
            Optional<District> optionalDistrict = districtRepository.findById(request.getUbigeo());
            if (optionalDistrict.isEmpty()) {
                responseDTO.setStatusCode("99");
                responseDTO.setStatusMessage("The district doesn't exists");
                System.out.println("response = " + new Gson().toJson(responseDTO));
                return responseDTO;
            }
        }

        // Assign values and save.
        Client existingClient = optionalClient.get();
        existingClient.setClientId(clientId);
        existingClient.setClientTypeId(request.getClientTypeId());
        existingClient.setClientName(request.getClientName());
        existingClient.setDocumentType(request.getDocumentType());
        existingClient.setDocumentNumber(request.getDocumentNumber());
        existingClient.setClientDirection(request.getClientDirection());
        existingClient.setUbigeo(request.getUbigeo());
        existingClient.setPhoneNumber(request.getPhoneNumber());
        existingClient.setClientEmail(request.getClientEmail());
        existingClient.setState(request.getState());
        Client client = clientRepository.save(existingClient);

        // Assign response.
        responseDTO.setStatusCode("01");
        responseDTO.setStatusMessage("OK");
        responseDTO.setClient(client);

        // Show the result in the console and return the value.
        System.out.println("response = " + new Gson().toJson(responseDTO));
        return responseDTO;
    }
}
