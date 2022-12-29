package com.example.Bank.service;

import com.example.Bank.model.Client;

import java.util.List;

public interface ClientService {
    Client addClient(Client client);
    void deleteClient(long id);
    Client getClientByPhoneNumber(String phoneNumber);
    Client editClient(Client client);
    List<Client> getAllClient();
}
