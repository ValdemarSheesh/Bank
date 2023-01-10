package com.example.Bank.controller;

import com.example.Bank.model.Client;
import com.example.Bank.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    @PostMapping("save")
    public void saveClient(String name, String surname, String patronymic, String phoneNumber, String passportNumber) {
        Client client = new Client();
        clientService.addClient(client);
    }

    @GetMapping("client")
    public Client getClient(Long id) {
        return clientService.getClientById(id);
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClient();
    }

    @DeleteMapping
    public void deleteClient(Long id) {
        clientService.deleteClient(id);
    }
}
