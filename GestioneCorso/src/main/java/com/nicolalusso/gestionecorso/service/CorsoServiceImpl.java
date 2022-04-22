package com.nicolalusso.gestionecorso.service;

import com.nicolalusso.gestionecorso.client.DocenteClient;
import com.nicolalusso.gestionecorso.converter.CorsoMapper;
import com.nicolalusso.gestionecorso.data.dto.CorsoDto;
import com.nicolalusso.gestionecorso.data.entity.Corso;
import com.nicolalusso.gestionecorso.repository.CorsoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CorsoServiceImpl implements CorsoService {

    @Autowired
    CorsoRepository corsoRepository;

    @Autowired
    CorsoMapper corsoMapper;

    @Autowired
    DocenteClient docenteClient;

    @Override
    public List<CorsoDto> findAll(){
        List<Corso> corsi = corsoRepository.findAll();
        List<CorsoDto> corsi_dto = new ArrayList<>();

        for(Corso corso : corsi){
            corsi_dto.add(corsoMapper.toDto(corso));
        }
        return corsi_dto;
    }

    @Override
    public CorsoDto findById(Long id){
        return corsoMapper.toDto(corsoRepository.findById(id).get());
    }

    @Override
    public String delete(Long id){
        //Controllo del docente
        try{
            Corso corso = corsoRepository.findById(id).get();
            if(this.ChkDeleteDocente(corso.getId_docente())){
                docenteClient.eliminaDocente(corso.getId_docente());
            }
            corsoRepository.delete(corso);
            return "Corso eliminato correttamente";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public CorsoDto getCorsoByNome(String nome_corso){
        try{
            return corsoMapper.toDto(corsoRepository.findByNome(nome_corso));
        }catch (Exception e){
            return new CorsoDto();
        }
    }

    @Override
    public String save(Corso corso) {
        if(docenteClient.getNomeDocenteById(corso.getId_docente()).equals("KO")){
            return "Non esiste il docente";
        }else{
            corsoRepository.save(corso);
            return "Corso salvato correttamente";
        }
    }

    @Override
    public Boolean ChkDeleteDocente(Long id_docente){
        List<Corso> corsi = corsoRepository.findCorsoById_docente(id_docente);
        if(corsi.size() <= 1){
            return true;
        }else{
            return false;
        }
    }

}