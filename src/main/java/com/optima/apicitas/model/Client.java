package com.optima.apicitas.model;

import com.optima.apicitas.dto.DataClientRegister;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private Integer age;

    public Client() {
    }

    public Client(Long id, String name, String email, String password, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public Client(DataClientRegister data) {
        this.name = data.name();
        this.email = data.email();
        this.password = data.password();
        this.age = data.age();
    }
}
