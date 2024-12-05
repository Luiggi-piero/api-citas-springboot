package com.optima.apicitas.controller;

import com.optima.apicitas.dto.DataClientRegister;
import com.optima.apicitas.model.Client;
import com.optima.apicitas.service.IClientService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClientController {

    @Autowired
    private IClientService service;

    @PostMapping("/clients")
    @Transactional
    public ResponseEntity createClient(@RequestBody @Valid DataClientRegister data){
        service.createClient(new Client(data));
        return ResponseEntity.ok("Cliente creado con éxito");
    }
}
