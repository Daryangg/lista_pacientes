package com.darydev.lista_pacientes;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.darydev.lista_pacientes.model.Paciente;
import com.darydev.lista_pacientes.sevice.PacienteService;

@SpringBootTest
class ListaPacientesApplicationTests {
@Autowired
PacienteService service;

	@Test
	void addPaciente() {
		
	}

}
