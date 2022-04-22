package com.nicolalusso.gestionecorso.repository;


import com.nicolalusso.gestionecorso.data.entity.Corso;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CorsoRepository extends JpaRepository<Corso, Long> {

    @Query(value = "SELECT C FROM Corso C WHERE C.id_docente = :id_docente")
    List<Corso> findCorsoById_docente(@Param("id_docente") Long id_docente);

    Corso findByNome(String nome_corso);
}
