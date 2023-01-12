package com.example.Bank.controller;

import com.example.Bank.dto.ClientDto;
import com.example.Bank.mapper.ClientMapper;
import com.example.Bank.model.Client;
import com.example.Bank.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    @PostMapping("save")
    public void saveClient(@RequestBody ClientDto clientDto) {
        Client client = ClientMapper.INSTANCE.clientDtoToClient(clientDto);
        clientService.addClient(client);
    }

    @GetMapping("/{id}")
    public ClientDto getClient(@PathVariable Long id) {
        Client client = clientService.getClientById(id);
        return ClientMapper.INSTANCE.clientToClientDto(client);
    }

    @GetMapping()
    public List<ClientDto> getAllClients() {
        List<Client> clients = clientService.getAllClient();
        return ClientMapper.INSTANCE.clientsToClientsDto(clients);
    }

    @DeleteMapping("/delete")
    public void deleteClient(@RequestParam(value = "id") Long id) {
        clientService.deleteClient(id);
    }
}
