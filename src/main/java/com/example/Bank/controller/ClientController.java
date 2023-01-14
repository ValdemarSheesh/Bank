package com.example.Bank.controller;

import com.example.Bank.dto.ClientDto;
import com.example.Bank.exceptions.InvalidValueException;
import com.example.Bank.mapper.ClientMapper;
import com.example.Bank.model.Client;
import com.example.Bank.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> saveClient(@Validated @RequestBody ClientDto clientDto,
                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            throw new InvalidValueException(InvalidValueException.createMessage(bindingResult));

        Client client = ClientMapper.INSTANCE.clientDtoToClient(clientDto);
        clientService.addClient(client);
        return ResponseEntity.ok("Client added");
    }

    @GetMapping("/{id}")
    public ClientDto getClient(@PathVariable Long id) {
        Client client = clientService.getClientById(id);
        return ClientMapper.INSTANCE.clientToClientDto(client);
    }

    @PutMapping
    public ResponseEntity<String> updateClient(@RequestParam(value = "id") Long id,
                                               @Validated @RequestBody ClientDto clientDto,
                                               BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            throw new InvalidValueException(InvalidValueException.createMessage(bindingResult));

        Client client = ClientMapper.INSTANCE.clientDtoToClient(clientDto);
        client.setId(id);
        clientService.editClient(client);
        return ResponseEntity.ok("Client updated");
    }

    @GetMapping()
    public ResponseEntity<?> getAllClients() {
        List<Client> clients = clientService.getAllClient();
        if (clients.isEmpty())
            return ResponseEntity.ok("Clients is empty");
        else
            return ResponseEntity.ok(ClientMapper.INSTANCE.clientsToClientsDto(clients));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteClient(@RequestParam(value = "id") Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok("Client deleted");
    }
}
