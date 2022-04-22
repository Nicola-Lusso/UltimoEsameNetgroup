package com.nicolalusso.gestionedocente.service;


import com.nicolalusso.gestionedocente.data.dto.DocenteDto;
import com.nicolalusso.gestionedocente.data.entity.Docente;

import java.util.List;

public interface DocenteService {
    DocenteDto findById(Long id);

    List<DocenteDto> findAll();

    String getNomeById(Long id);

    String delete(Long id);

    Docente save(Docente docente);
}
