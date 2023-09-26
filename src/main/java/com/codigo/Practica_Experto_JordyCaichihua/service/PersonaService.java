package com.codigo.Practica_Experto_JordyCaichihua.service;

import com.codigo.Practica_Experto_JordyCaichihua.model.Persona;
import com.codigo.Practica_Experto_JordyCaichihua.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }


    public List<Persona> obtenerTodasPersonas(){

        return personaRepository.findAll();
    }

    public Persona obtenerPersonaXid(Long id){
        Optional<Persona> persona = personaRepository.findById(id);
        if(persona.isPresent()){
            return persona.get();
        }else {
            throw new RuntimeException("Persona no encontrado");
        }
    }


    public Persona crearPersona(Persona persona){


        return personaRepository.save(persona);
    }

    public Persona actualizarPersona(Long id, Persona personaActualizada){
        Persona personaExistente=obtenerPersonaXid(id);
        personaExistente.setNombre(personaActualizada.getNombre());
        personaExistente.setEstado(personaActualizada.getEstado());

        return personaRepository.save(personaExistente);
    }

    public Persona eliminadoLogicoPersona(Long id){
        Persona personaExistente=obtenerPersonaXid(id);
        Integer estadoCero=0;
        personaExistente.setEstado(estadoCero);

        return personaRepository.save(personaExistente);
    }
}
