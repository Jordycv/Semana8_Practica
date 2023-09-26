package com.codigo.Practica_Experto_JordyCaichihua.service;

import com.codigo.Practica_Experto_JordyCaichihua.model.Persona;
import com.codigo.Practica_Experto_JordyCaichihua.repository.PersonaRepository;
import net.bytebuddy.dynamic.DynamicType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PersonaServiceTest {

    private PersonaRepository  personaRepositoryMock = Mockito.mock(PersonaRepository.class );

    @Autowired
    private PersonaService personaService= new PersonaService(personaRepositoryMock);

    @BeforeEach
    void setUp() {
        Persona persona= new Persona(1L,  "nombre",  1);
        List<Persona> personaL = new ArrayList<>();
        personaL.add(persona);
        Mockito.when(personaRepositoryMock.findAll()).thenReturn(personaL);


        Optional<Persona> personaOptional = Optional.of(persona);
        Long id= 1L;
        Mockito.when(personaRepositoryMock.findById(id)).thenReturn(personaOptional);

        Mockito.when(personaRepositoryMock.save(persona)).thenReturn(persona);


    }



    @Test
    void obtenerTodasPersonasTest() {


        Persona persona= new Persona(1L,  "nombre",  1);
        List<Persona> personaListExpec = new ArrayList<>();
        personaListExpec.add(persona);

        List<Persona> personaList = personaService.obtenerTodasPersonas();

        Assertions.assertEquals(personaListExpec.get(0).getId(),personaList.get(0).getId());
        Assertions.assertEquals(personaListExpec.get(0).getNombre(),personaList.get(0).getNombre());
        Assertions.assertEquals(personaListExpec.get(0).getEstado(),personaList.get(0).getEstado());
    }
    @Test
    void obtenerPersonaXidTest() {


        Persona persona= new Persona(1L,  "nombre",  1);

        Persona personaListExpec= new Persona(1L,  "nombre",  1);

        Persona personaList = personaService.obtenerPersonaXid(persona.getId());

        Assertions.assertEquals(personaListExpec.getId(),personaList.getId());
        Assertions.assertEquals(personaListExpec.getNombre(),personaList.getNombre());
        Assertions.assertEquals(personaListExpec.getEstado(),personaList.getEstado());
    }

    @Test
    void crearPersonaTest() {


        Persona personaCreada= new Persona(1L,  "nombre",  1);

        Persona personaListExpec= new Persona(1L,  "nombre",  1);
        Mockito.when(personaRepositoryMock.save(personaCreada)).thenReturn(personaCreada);

        Persona personaList = personaService.crearPersona(personaCreada);

        Assertions.assertEquals(personaListExpec.getId(),personaList.getId());
        Assertions.assertEquals(personaListExpec.getNombre(),personaList.getNombre());
        Assertions.assertEquals(personaListExpec.getEstado(),personaList.getEstado());
    }

    @Test
    void actualizarPersonaTest() {


        Persona personaAct= new Persona(1L,  "nombre",  1);

        Persona personaListExpec= new Persona(1L,  "nombre",  1);

        Persona personaList = personaService.actualizarPersona(personaAct.getId(),personaAct);

        Assertions.assertEquals(personaListExpec.getId(),personaList.getId());
        Assertions.assertEquals(personaListExpec.getNombre(),personaList.getNombre());
        Assertions.assertEquals(personaListExpec.getEstado(),personaList.getEstado());
    }

    @Test
    void eliminadoLogicoPersonaTest() {


        Persona personaEl= new Persona(1L,  "nombre",  1);

        Persona personaListExpec= new Persona(1L,  "nombre",  0);

        Persona personaList = personaService.eliminadoLogicoPersona(personaEl.getId());

        Assertions.assertEquals(personaListExpec.getId(),personaList.getId());
        Assertions.assertEquals(personaListExpec.getNombre(),personaList.getNombre());
        Assertions.assertEquals(personaListExpec.getEstado(),personaList.getEstado());
    }





}