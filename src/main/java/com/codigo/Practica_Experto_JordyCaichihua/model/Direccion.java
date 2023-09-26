package com.codigo.Practica_Experto_JordyCaichihua.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Where(clause = "estado = 1")
@AllArgsConstructor
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "direccion_id")
    private Long id;
    private String calle;
    private Integer estado;
    @OneToOne
    @JoinColumn(name="persona_id")
    private Persona persona;
}
