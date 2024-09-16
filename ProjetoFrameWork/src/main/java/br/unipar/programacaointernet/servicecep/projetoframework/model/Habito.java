package br.unipar.programacaointernet.servicecep.projetoframework.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Habito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Boolean agua;
    private Boolean exercicio;
    private Boolean ler;
    private Boolean vegetais;
    private Boolean estudar;
    private Boolean dormir;
    private String data;
}
