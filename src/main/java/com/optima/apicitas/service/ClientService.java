package com.optima.apicitas.service;

import com.optima.apicitas.model.Client;
import com.optima.apicitas.respository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements IClientService {

    @Autowired
    private IClientRepository repository;

    @Override
    public Client createClient(Client client) {
        return repository.save(client);
    }
}
