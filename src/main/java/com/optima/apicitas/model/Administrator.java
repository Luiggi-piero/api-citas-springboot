package com.optima.apicitas.model;

import com.optima.apicitas.dto.DataAdministratorRegister;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;

    public Administrator() {
    }

    public Administrator(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Administrator(DataAdministratorRegister data) {
        this.name = data.name();
        this.email = data.email();
        this.password = data.password();
    }
}
