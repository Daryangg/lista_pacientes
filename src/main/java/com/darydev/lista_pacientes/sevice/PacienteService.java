package com.darydev.lista_pacientes.sevice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.darydev.lista_pacientes.model.Paciente;

@Service
public interface PacienteService {
    
    public List<Paciente> getPacientes();
    public Paciente getPacienteById(Long id);
    public Paciente saveOrUpdate(Paciente p);
    public void delete(Long id);
    public void deleteAll();
    public Paciente getMaxDebt();

}
