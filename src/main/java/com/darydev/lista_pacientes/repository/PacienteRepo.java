package com.darydev.lista_pacientes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.darydev.lista_pacientes.model.Paciente;

@Repository
public interface PacienteRepo extends JpaRepository<Paciente, Long > {

    @Query("select p from Paciente p order by p.name")
    public List<Paciente> findAllOrderByName();

    public Paciente findByDebt(Integer debt);

}
