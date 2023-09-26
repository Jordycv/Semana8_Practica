package com.codigo.Practica_Experto_JordyCaichihua.service;

import com.codigo.Practica_Experto_JordyCaichihua.model.Direccion;
import com.codigo.Practica_Experto_JordyCaichihua.repository.DireccionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DireccionService {

    private final DireccionRepository direccionRepository;

    public DireccionService(DireccionRepository direccionRepository) {
        this.direccionRepository = direccionRepository;
    }


    public List<Direccion> obtenerTodosDireccion(){

        return direccionRepository.findAll();
    }

    public Direccion obtenerDireccionXid(Long id){
        Optional<Direccion> direccion = direccionRepository.findById(id);
        if(direccion.isPresent()){
            return direccion.get();
        }else {
            throw new RuntimeException("Direccion no encontrado");
        }
    }

    public Direccion crearDireccion(Direccion direccion){

        return direccionRepository.save(direccion);
    }

    public Direccion actualizarDireccion(Long id, Direccion direccionActualizada){
        Direccion direccionExistente=obtenerDireccionXid(id);
        direccionExistente.setCalle(direccionActualizada.getCalle());
        direccionExistente.setEstado(direccionActualizada.getEstado());
        direccionExistente.setPersona(direccionActualizada.getPersona());

        return direccionRepository.save(direccionExistente);
    }

    public Direccion eliminadoLogicoDireccion(Long id){
        Direccion direccionExistente=obtenerDireccionXid(id);
        Integer estadoCero=0;
        direccionExistente.setEstado(estadoCero);

        return direccionRepository.save(direccionExistente);
    }
}
