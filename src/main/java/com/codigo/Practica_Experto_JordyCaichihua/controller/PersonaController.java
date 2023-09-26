package com.codigo.Practica_Experto_JordyCaichihua.controller;

import com.codigo.Practica_Experto_JordyCaichihua.model.Persona;
import com.codigo.Practica_Experto_JordyCaichihua.service.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {


    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }


    @GetMapping
    public List<Persona> listarPersonas(){
        return personaService.obtenerTodasPersonas();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Persona> obtenerPersonaPorId(@PathVariable Long id){
        Persona persona = personaService.obtenerPersonaXid(id);
        return ResponseEntity.ok(persona);
    }

    @PostMapping
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona){
        Persona nuevoPersona = personaService.crearPersona(persona);
        return new ResponseEntity<>(nuevoPersona, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable Long id, @RequestBody Persona personaActualizado){
        Persona persona = personaService.actualizarPersona(id, personaActualizado);
        return ResponseEntity.ok(persona);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Persona> eliminarPersona(@PathVariable Long id){
        Persona personarEl = personaService.eliminadoLogicoPersona(id);
        return ResponseEntity.ok(personarEl);
    }

}
