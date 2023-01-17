package com.example.Bank.mapper;

import com.example.Bank.dto.ClientDto;
import com.example.Bank.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDto clientToClientDto(Client client);

    Client clientDtoToClient(ClientDto clientDto);

    List<ClientDto> clientsToClientsDto(List<Client> clients);
}
