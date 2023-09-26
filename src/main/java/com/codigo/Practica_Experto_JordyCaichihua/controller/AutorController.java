package com.codigo.Practica_Experto_JordyCaichihua.controller;

import com.codigo.Practica_Experto_JordyCaichihua.model.Autor;
import com.codigo.Practica_Experto_JordyCaichihua.service.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {


    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<Autor> listarAutores(){
        return autorService.obtenerTodosAutores();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Autor> obtenerAutorPorId(@PathVariable Long id){
        Autor autor = autorService.obtenerAutorXid(id);
        return ResponseEntity.ok(autor);
    }

    @PostMapping
    public ResponseEntity<Autor> crearAutor(@RequestBody Autor autor){
        Autor nuevoAutor = autorService.crearAutor(autor);
        return new ResponseEntity<>(nuevoAutor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> actualizarAutor(@PathVariable Long id, @RequestBody Autor autorActualizado){
        Autor autor = autorService.actualizarAutor(id, autorActualizado);
        return ResponseEntity.ok(autor);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Autor> eliminarAutor(@PathVariable Long id){
        Autor autorEl = autorService.eliminadoLogicoAutor(id);
        return ResponseEntity.ok(autorEl);
    }


}
