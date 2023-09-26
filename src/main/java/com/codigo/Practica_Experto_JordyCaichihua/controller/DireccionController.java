package com.codigo.Practica_Experto_JordyCaichihua.controller;

import com.codigo.Practica_Experto_JordyCaichihua.model.Direccion;
import com.codigo.Practica_Experto_JordyCaichihua.service.DireccionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/direcciones")
public class DireccionController {

    private final DireccionService direccionService;

    public DireccionController(DireccionService direccionService) {
        this.direccionService = direccionService;
    }


    @GetMapping
    public List<Direccion> listarDireccion(){
        return direccionService.obtenerTodosDireccion();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Direccion> obtenerDireccionPorId(@PathVariable Long id){
        Direccion direccion = direccionService.obtenerDireccionXid(id);
        return ResponseEntity.ok(direccion);
    }

    @PostMapping
    public ResponseEntity<Direccion> crearDireccion(@RequestBody Direccion direccion){
        Direccion nuevoDireccion = direccionService.crearDireccion(direccion);
        return new ResponseEntity<>(nuevoDireccion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Direccion> actualizarDireccion(@PathVariable Long id, @RequestBody Direccion direccionActualizado){
        Direccion direccion = direccionService.actualizarDireccion(id, direccionActualizado);
        return ResponseEntity.ok(direccion);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Direccion> eliminarDireccion(@PathVariable Long id){
        Direccion direccionEl = direccionService.eliminadoLogicoDireccion(id);
        return ResponseEntity.ok(direccionEl);
    }


}
