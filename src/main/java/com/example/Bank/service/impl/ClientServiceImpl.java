package com.example.Bank.service.impl;

import com.example.Bank.exceptions.NotFoundException;
import com.example.Bank.model.Client;
import com.example.Bank.repo.ClientRepository;
import com.example.Bank.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client addClient(Client client) {
        return clientRepository.saveAndFlush(client);
    }

    @Override
    public void deleteClient(long id) {
        clientRepository.delete(getClientById(id));
    }

    @Override
    public Client getClientByPhoneNumber(Integer phoneNumber) {
        return clientRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new NotFoundException("Client with id " + id + " not found"));
    }

    @Override
    public Client editClient(Client client) {
        return clientRepository.saveAndFlush(getClientById(client.getId()));
    }

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }
}
