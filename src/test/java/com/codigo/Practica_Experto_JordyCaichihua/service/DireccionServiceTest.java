package com.codigo.Practica_Experto_JordyCaichihua.service;

import com.codigo.Practica_Experto_JordyCaichihua.model.Direccion;
import com.codigo.Practica_Experto_JordyCaichihua.model.Persona;
import com.codigo.Practica_Experto_JordyCaichihua.repository.DireccionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DireccionServiceTest {
    private DireccionRepository direccionRepositoryMock = Mockito.mock(DireccionRepository.class );

    @Autowired
    private DireccionService direccionService= new DireccionService(direccionRepositoryMock);

    @BeforeEach
    void setUp() {
        Persona persona = new Persona(1L,  "nombre",  1);
        Direccion direccion= new Direccion(1L,  "calle",  1,persona);
        List<Direccion> direccionL = new ArrayList<>();
        direccionL.add(direccion);
        Mockito.when(direccionRepositoryMock.findAll()).thenReturn(direccionL);

        Optional<Direccion> direccionOptional = Optional.of(direccion);
        Long id= 1L;
        Mockito.when(direccionRepositoryMock.findById(id)).thenReturn(direccionOptional);

        Persona personaret= new Persona(1L,  "nombre",  1);

        Mockito.when(direccionRepositoryMock.save(direccion)).thenReturn(direccion);
    }



    @Test
    void obtenerTodasDirecciones() {


        Persona persona = new Persona(1L,  "nombre",  1);
        Direccion direccion= new Direccion(1L,  "calle",  1,persona);
        List<Direccion> direccionListExpec = new ArrayList<>();
        direccionListExpec.add(direccion);

        List<Direccion> direccionList = direccionService.obtenerTodosDireccion();

        Assertions.assertEquals(direccionListExpec.get(0).getId(),direccionList.get(0).getId());
        Assertions.assertEquals(direccionListExpec.get(0).getCalle(),direccionList.get(0).getCalle());
        Assertions.assertEquals(direccionListExpec.get(0).getEstado(),direccionList.get(0).getEstado());
        Assertions.assertEquals(direccionListExpec.get(0).getPersona().getId(),direccionList.get(0).getPersona().getId());
    }

    @Test
    void obtenerDireccionXidTest() {


        Persona persona = new Persona(1L,  "nombre",  1);
        Direccion direccion= new Direccion(1L,  "calle",  1,persona);

        Direccion direccionExpec= new Direccion(1L,  "calle",  1,persona);

        Direccion personaList = direccionService.obtenerDireccionXid(direccion.getId());

        Assertions.assertEquals(direccionExpec.getId(),personaList.getId());
        Assertions.assertEquals(direccionExpec.getCalle(),personaList.getCalle());
        Assertions.assertEquals(direccionExpec.getEstado(),personaList.getEstado());
        Assertions.assertEquals(direccionExpec.getPersona().getId(),personaList.getPersona().getId());
    }

    @Test
    void crearDireccionTest() {


        Persona persona = new Persona(1L,  "nombre",  1);
        Direccion direccionCreada= new Direccion(1L,  "calle",  1,persona);


        Direccion direccionListExpec= new Direccion(1L,  "calle",  1,persona);
        Mockito.when(direccionRepositoryMock.save(direccionCreada)).thenReturn(direccionCreada);

        Direccion direccionList = direccionService.crearDireccion(direccionCreada);

        Assertions.assertEquals(direccionListExpec.getId(),direccionList.getId());
        Assertions.assertEquals(direccionListExpec.getCalle(),direccionList.getCalle());
        Assertions.assertEquals(direccionListExpec.getEstado(),direccionList.getEstado());
        Assertions.assertEquals(direccionListExpec.getPersona().getId(),direccionList.getPersona().getId());
    }

    @Test
    void actualizarDireccionTest() {


        Persona persona = new Persona(1L,  "nombre",  1);
        Direccion direccionAct= new Direccion(1L,  "calle",  1,persona);

        Direccion direccionListExpec= new Direccion(1L,  "calle",  1,persona);

        Direccion direccionList = direccionService.actualizarDireccion(direccionAct.getId(),direccionAct);

        Assertions.assertEquals(direccionListExpec.getId(),direccionList.getId());
        Assertions.assertEquals(direccionListExpec.getCalle(),direccionList.getCalle());
        Assertions.assertEquals(direccionListExpec.getEstado(),direccionList.getEstado());
        Assertions.assertEquals(direccionListExpec.getPersona().getId(),direccionList.getPersona().getId());
    }

    @Test
    void eliminadoLogicoDireccionTest() {


        Persona persona = new Persona(1L,  "nombre",  1);
        Direccion direccionEl= new Direccion(1L,  "calle",  1,persona);

        Direccion direccionListExpec= new Direccion(1L,  "calle",  0,persona);

        Direccion direccionList = direccionService.eliminadoLogicoDireccion(direccionEl.getId());

        Assertions.assertEquals(direccionListExpec.getId(),direccionList.getId());
        Assertions.assertEquals(direccionListExpec.getCalle(),direccionList.getCalle());
        Assertions.assertEquals(direccionListExpec.getEstado(),direccionList.getEstado());
        Assertions.assertEquals(direccionListExpec.getPersona().getId(),direccionList.getPersona().getId());
    }


}