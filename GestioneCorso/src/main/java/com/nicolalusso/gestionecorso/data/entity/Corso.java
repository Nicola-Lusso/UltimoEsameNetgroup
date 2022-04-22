package com.nicolalusso.gestionecorso.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@Table(name = "corso")

public class Corso {


    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nome;

    @Column(name = "data_inizio")
    private LocalDate data_inizio;

    @Column(name = "durata")
    private Long durata;

    @Column
    private Long id_docente;

}
