package com.nicolalusso.gestionedocente.rest;


import com.nicolalusso.gestionedocente.data.dto.DocenteDto;
import com.nicolalusso.gestionedocente.data.entity.Docente;
import com.nicolalusso.gestionedocente.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docente")
public class RestDocenteController {

    @Autowired
    DocenteService docenteService;

    @GetMapping(value = "/{id}")
    public DocenteDto getById(@PathVariable("id") Long id) {
        return docenteService.findById(id);
    }

    @GetMapping(value = "/getNomeById/{id}")
    public String getNomeById(@PathVariable("id") Long id){
        try{
            return docenteService.getNomeById(id);
        }catch (Exception e){
            return "KO";
        }
    }

    @GetMapping(value = "/lista")
    public List<DocenteDto> getAll() {
        return docenteService.findAll();
    }

    @PostMapping(value = "/newDocente")
    public void newDocente(@RequestBody Docente docente) {
        docenteService.save(docente);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteDocentePerId(@PathVariable("id") Long id) {
        return docenteService.delete(id);
    }

}
