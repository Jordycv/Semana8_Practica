package com.codigo.Practica_Experto_JordyCaichihua.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Where(clause = "estado = 1")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "autor_id")
    private Long id;
    private String nombre;
    private Integer estado;
    @OneToOne
    @JsonIgnore
    @JoinColumn(name="persona_id")
    private Persona persona;

    @ManyToMany(mappedBy = "autor")
    @JsonIgnore
    private Set<Libro> libros = new HashSet<>();
}
