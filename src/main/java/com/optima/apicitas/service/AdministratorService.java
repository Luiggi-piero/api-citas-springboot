package com.optima.apicitas.service;

import com.optima.apicitas.model.Administrator;
import com.optima.apicitas.respository.IAdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService implements IAdministratorService{

    @Autowired
    private IAdministratorRepository repository;

    @Override
    public void createAdministrator(Administrator administrator) {
        repository.save(administrator);
    }
}
