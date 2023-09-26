package com.codigo.Practica_Experto_JordyCaichihua.repository;

import com.codigo.Practica_Experto_JordyCaichihua.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro,Long> {
}
