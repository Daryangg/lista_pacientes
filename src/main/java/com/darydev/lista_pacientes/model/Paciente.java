package com.darydev.lista_pacientes.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "pacientes")
public class Paciente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer debt;

    @Column(nullable = false)
    private Integer cuot;

    @Column(nullable = false)
    private String date;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pay> payments = new ArrayList<>();

    public void addPayment(Pay payment) {
        payments.add(payment);
    }
}
