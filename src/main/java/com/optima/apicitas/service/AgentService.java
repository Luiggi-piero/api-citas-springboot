package com.optima.apicitas.service;

import com.optima.apicitas.model.Agent;
import com.optima.apicitas.respository.IAgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AgentService implements IAgentService {

    @Autowired
    private IAgentRepository repository;

    @Override
    public void createAgent(Agent agent) {
        repository.save(agent);
        /*return new DataAgentResponse(
                a.getId(),
                a.getName(),
                a.getEmail()
        );*/
    }
}
