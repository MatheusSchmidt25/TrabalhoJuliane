package br.unipar.programacaointernet.servicecep.projetoframework.model;

import jakarta.persistence.*;
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

    @ManyToOne
    private Usuario usuario;
}
