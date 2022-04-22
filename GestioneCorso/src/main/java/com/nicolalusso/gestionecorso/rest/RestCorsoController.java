package com.nicolalusso.gestionecorso.rest;


import com.nicolalusso.gestionecorso.data.dto.CorsoDto;
import com.nicolalusso.gestionecorso.data.entity.Corso;
import com.nicolalusso.gestionecorso.service.CorsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/corso")
public class RestCorsoController {

    @Autowired
    CorsoService corsoService;

    @GetMapping(value = "/ricerca/id/{id}")
    public CorsoDto getById(@PathVariable("id") Long id) {
        return corsoService.findById(id);
    }

    @GetMapping(value = "/lista")
    public List<CorsoDto> getAll() {
        return corsoService.findAll();
    }

    @PostMapping(value = "/newCorso")
    public String newCorso(@RequestBody Corso corso) {
        return corsoService.save(corso);
    }

    @DeleteMapping(value = "/deleteCorso/{id}")
    public void deleteCorsoPerId(@PathVariable("id") Long id) {
        corsoService.delete(id);
    }

    @PostMapping(value = "/modCorso")
    public void modCorso(@RequestBody Corso corso) {
        corsoService.save(corso);
    }

    @GetMapping(value = "/ricerca/nome/{nome_corso}")
    public CorsoDto getCorsoByNome(@PathVariable("nome_corso") String nome_corso){
        return corsoService.getCorsoByNome(nome_corso);
    }

}
