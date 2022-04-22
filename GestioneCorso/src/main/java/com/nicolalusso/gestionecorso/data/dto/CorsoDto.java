package com.nicolalusso.gestionecorso.data.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CorsoDto {

    private String nome;
    private Long durata;
    private LocalDate data_inizio;
    private String nome_docente;

}
