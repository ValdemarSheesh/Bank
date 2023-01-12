package com.example.Bank.controller;

import com.example.Bank.dto.ClientDto;
import com.example.Bank.exceptions.InvalidValueException;
import com.example.Bank.mapper.ClientMapper;
import com.example.Bank.model.Client;
import com.example.Bank.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    @PostMapping("save")
    public void saveClient(@Validated @RequestBody ClientDto clientDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            throw new InvalidValueException("Invalid value");
        Client client = ClientMapper.INSTANCE.clientDtoToClient(clientDto);
        clientService.addClient(client);
    }

    @GetMapping("/{id}")
    public ClientDto getClient(@PathVariable Long id) {
        Client client = clientService.getClientById(id);
        return ClientMapper.INSTANCE.clientToClientDto(client);
    }

    @PutMapping("/update")
    public void updateClient(@RequestParam(value = "id") Long id, @Validated @RequestBody ClientDto clientDto) {
        Client client = ClientMapper.INSTANCE.clientDtoToClient(clientDto);
        client.setId(id);
        clientService.editClient(client);
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
