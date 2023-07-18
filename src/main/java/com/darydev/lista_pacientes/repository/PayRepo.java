package com.darydev.lista_pacientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darydev.lista_pacientes.model.Pay;

@Repository
public interface PayRepo extends JpaRepository<Pay, Long>{
    
}
