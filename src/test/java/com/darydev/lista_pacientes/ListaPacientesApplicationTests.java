package com.darydev.lista_pacientes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.darydev.lista_pacientes.model.Paciente;
import com.darydev.lista_pacientes.model.Pay;
import com.darydev.lista_pacientes.sevice.PacienteService;

@SpringBootTest
class ListaPacientesApplicationTests {
	@Autowired
	PacienteService pacienteService;

	@Test
	void addPaciente() {
		Paciente paciente = new Paciente();
		paciente.setName("manuel");
		paciente.setDebt(2000);
		paciente.setCuot(32);
		paciente.setDate("2022-06-20");

		Pay pay1 = new Pay();
		pay1.setMount(44444);
		pay1.setDate("2022-05-25");
		pay1.setPaciente(paciente);

		Pay pay2 = new Pay();
		pay2.setMount(55555);
		pay2.setDate("2022-06-05");
		pay2.setPaciente(paciente);

		paciente.addPayment(pay1);
		paciente.addPayment(pay2);

		pacienteService.saveOrUpdate(paciente);
	}

}
