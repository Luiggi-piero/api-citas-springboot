package com.optima.apicitas.respository;

import com.optima.apicitas.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdministratorRepository extends JpaRepository<Administrator, Long> {
}
