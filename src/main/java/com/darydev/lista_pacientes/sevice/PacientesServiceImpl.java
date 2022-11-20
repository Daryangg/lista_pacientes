package com.darydev.lista_pacientes.sevice;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darydev.lista_pacientes.model.Paciente;
import com.darydev.lista_pacientes.repository.PacienteRepo;

@Service
public class PacientesServiceImpl implements PacienteService {

   @Autowired
   private PacienteRepo repo;

   @Override
   public List<Paciente> getPacientes() {
      return repo.findAllOrderByDate()
            .stream().collect(Collectors.toList());
   }

   @Override
   public Paciente saveOrUpdate(Paciente p) {

      return repo.save(p);
   }

   @Override
   public void delete(Long id) {
      repo.deleteById(id);
   }

   public void deleteAll() {
      repo.deleteAll();
   }

   @Override
   public Paciente getPacienteById(Long id) {
      return repo.findById(id)
            .orElse(null);
   }
}
