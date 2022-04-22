package com.nicolalusso.gestionecorso.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "GestioneDocente", url = "http://localhost:8081")
public interface DocenteClient {

    @GetMapping(value = "/api/docente/getNomeById/{id}")
    String getNomeDocenteById(@PathVariable("id") Long id);
    @DeleteMapping(value = "/api/docente/{id}")
    String eliminaDocente(@PathVariable("id") Long id);
}
