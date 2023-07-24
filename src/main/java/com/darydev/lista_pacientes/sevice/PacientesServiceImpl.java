package com.darydev.lista_pacientes.sevice;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darydev.lista_pacientes.model.Paciente;
import com.darydev.lista_pacientes.repository.PacienteRepo;
import com.darydev.lista_pacientes.repository.PayRepo;

@Service
public class PacientesServiceImpl implements PacienteService {

   @Autowired
   private PacienteRepo pacienteRepo;
   @Autowired
   private PayRepo payRepo;

   @Override
   public List<Paciente> getPacientes() {
      return pacienteRepo.findAllOrderByName().stream().collect(Collectors.toList());
   }

   @Override
   public Paciente saveOrUpdate(Paciente p) {
      return pacienteRepo.save(p);
   }

   @Override
   public void delete(Long id) {
      pacienteRepo.deleteById(id);
   }

   public void deleteAll() {
      pacienteRepo.deleteAll();
   }

   @Override
   public Paciente getPacienteById(Long id) {
      return pacienteRepo.findById(id)
            .orElse(null);
   }

   @Override
   public Paciente getMaxDebt() {
      int max = pacienteRepo.findAll()
            .stream()
            .mapToInt(Paciente::getDebt)
            .max()
            .orElse(0);

      return pacienteRepo.findByDebt(max);
   }
}
