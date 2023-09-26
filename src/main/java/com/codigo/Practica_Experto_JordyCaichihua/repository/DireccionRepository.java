package com.codigo.Practica_Experto_JordyCaichihua.repository;

import com.codigo.Practica_Experto_JordyCaichihua.model.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion,Long> {
}
