package com.nicolalusso.gestionedocente.converter;


import com.nicolalusso.gestionedocente.data.dto.DocenteDto;
import com.nicolalusso.gestionedocente.data.entity.Docente;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocenteMapper {

    public DocenteDto toDto(Docente docente){
        ModelMapper modelDocente = new ModelMapper();
        DocenteDto docenteDto = modelDocente.map(docente, DocenteDto.class);
        return docenteDto;
    }
}
