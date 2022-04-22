package com.nicolalusso.gestionecorso.service;


import com.nicolalusso.gestionecorso.data.dto.CorsoDto;
import com.nicolalusso.gestionecorso.data.entity.Corso;

import java.util.List;

public interface CorsoService {
    List<CorsoDto> findAll();

    CorsoDto findById(Long id);

    String delete(Long id);

    CorsoDto getCorsoByNome(String nome_corso);

    String save(Corso corso);


    Boolean ChkDeleteDocente(Long id_docente);
}
