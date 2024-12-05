package com.optima.apicitas.controller;

import com.optima.apicitas.dto.DataAdministratorRegister;
import com.optima.apicitas.model.Administrator;
import com.optima.apicitas.service.IAdministratorService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdministratorController {

    @Autowired
    private IAdministratorService service;

    @PostMapping("/administrators")
    @Transactional
    public ResponseEntity createAdministrator(@RequestBody @Valid DataAdministratorRegister data){
        service.createAdministrator(new Administrator(data));
        return ResponseEntity.ok("Administrador creado con éxito!");
    }
}
