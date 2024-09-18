package br.unipar.programacaointernet.servicecep.projetoframework.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descricao;
    private String data_inicio;
    private String data_limite;

    @ManyToOne
    private Usuario usuario;

}
