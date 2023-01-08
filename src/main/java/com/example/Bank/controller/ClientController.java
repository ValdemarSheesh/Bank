package com.example.Bank.controller;

import com.example.Bank.model.Client;
import com.example.Bank.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        Client client = new Client("1", "2", "3", "4", "5");
        Client client1 = new Client("2", "3", "4", "5", "6");
        Client client2 = new Client("3", "4", "5", "6", "7");
        clientService.addClient(client);
        clientService.addClient(client1);
        clientService.addClient(client2);

        return clientService.getAllClient();
    }
}
