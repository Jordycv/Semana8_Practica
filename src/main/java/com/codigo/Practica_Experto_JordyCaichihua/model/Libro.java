package com.codigo.Practica_Experto_JordyCaichihua.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@Where(clause = "estado = 1")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "libro_id")
    private Long id;
    private String titulo;
    private Integer estado;

    @ManyToMany
    @JoinTable(
            name = "libroautor",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private Set<Autor> autor = new HashSet<>();
}
