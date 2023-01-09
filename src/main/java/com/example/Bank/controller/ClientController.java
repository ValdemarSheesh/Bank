package com.example.Bank.controller;

import com.example.Bank.model.Client;
import com.example.Bank.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    @PostMapping("save")
    public void saveClient(String name, String surname, String patronymic, String phoneNumber, String passportNumber) {
        Client client = new Client(name, surname, patronymic, phoneNumber, passportNumber);
        clientService.addClient(client);
    }

    @GetMapping("clients")
    public List<Client> getAllClient() {
        return clientService.getAllClient();
    }

    @DeleteMapping("delete")
    public void deleteClient() {
        clientService.deleteClient(1);
    }
}
