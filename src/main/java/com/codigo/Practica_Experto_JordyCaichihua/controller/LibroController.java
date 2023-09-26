package com.codigo.Practica_Experto_JordyCaichihua.controller;

import com.codigo.Practica_Experto_JordyCaichihua.model.Libro;
import com.codigo.Practica_Experto_JordyCaichihua.service.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<Libro> listarLibros(){

        return libroService.obtenerTodosLibros();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerLibroPorId(@PathVariable Long id){
        Libro libro = libroService.obtenerLibroXid(id);
        return ResponseEntity.ok(libro);
    }


    @PostMapping
    public ResponseEntity<Libro> crearLibro(@RequestBody Libro libro){
        Libro nuevoLibro = libroService.crearLibro(libro);
        return new ResponseEntity<>(nuevoLibro, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable Long id, @RequestBody Libro libroActualizado){
        Libro libroAct= libroService.actualizarLibro(id, libroActualizado);
        return ResponseEntity.ok(libroAct);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Libro> eliminarLibro(@PathVariable Long id){
        Libro libroEl = libroService.eliminadoLogicoLibro(id);
        return ResponseEntity.ok(libroEl);
    }

}
