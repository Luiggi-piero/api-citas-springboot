package com.optima.apicitas.model;

import com.optima.apicitas.dto.DataAgentRegister;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "agent")
    private List<Meeting> meetings;

    public Agent() {
    }

    public Agent(Long id, String name, String email, String password, List<Meeting> meetings) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.meetings = meetings;
    }

    public Agent(DataAgentRegister data) {
        this.name = data.name();
        this.email = data.email();
        this.password = data.password();
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
