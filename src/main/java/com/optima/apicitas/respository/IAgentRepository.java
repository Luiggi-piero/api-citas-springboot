package com.optima.apicitas.respository;

import com.optima.apicitas.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAgentRepository extends JpaRepository<Agent, Long> {
}
