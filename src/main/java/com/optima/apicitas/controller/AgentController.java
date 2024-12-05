package com.optima.apicitas.controller;

import com.optima.apicitas.dto.DataAgentRegister;
import com.optima.apicitas.model.Agent;
import com.optima.apicitas.service.IAgentService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/agents")
public class AgentController {

    @Autowired
    private IAgentService service;

    @PostMapping
    @Transactional
    public ResponseEntity createAgent(@RequestBody @Valid DataAgentRegister data){
        service.createAgent(new Agent(data));
        return ResponseEntity.ok("Agente creado con éxito");
    }
}
