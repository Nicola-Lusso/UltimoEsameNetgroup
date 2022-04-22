package com.nicolalusso.gestionedocente.repository;


import com.nicolalusso.gestionedocente.data.entity.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocenteRepository extends JpaRepository<Docente, Long> {
}
