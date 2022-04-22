package com.nicolalusso.gestionecorso.converter;


import com.nicolalusso.gestionecorso.client.DocenteClient;
import com.nicolalusso.gestionecorso.data.dto.CorsoDto;
import com.nicolalusso.gestionecorso.data.entity.Corso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;



@Configuration
public class CorsoMapper {

    @Autowired
    DocenteClient docenteClient;

    public CorsoDto toDto(Corso corso){
        CorsoDto dto = new CorsoDto();

        dto.setNome(corso.getNome());
        dto.setData_inizio(corso.getData_inizio());
        dto.setDurata(corso.getDurata());

        dto.setNome_docente(docenteClient.getNomeDocenteById(corso.getId_docente()));

        return dto;
    }
}
