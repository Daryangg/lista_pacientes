package com.darydev.lista_pacientes.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Data
@Table(name = "pagos")
public class Pay implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Integer mount;

    @Column(nullable = false)
    private String date;

    @ManyToOne 
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

}
