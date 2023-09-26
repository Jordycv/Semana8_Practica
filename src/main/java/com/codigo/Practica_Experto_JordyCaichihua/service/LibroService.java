package com.codigo.Practica_Experto_JordyCaichihua.service;

import com.codigo.Practica_Experto_JordyCaichihua.model.Libro;
import com.codigo.Practica_Experto_JordyCaichihua.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }


    public List<Libro> obtenerTodosLibros(){

        return libroRepository.findAll();
    }

    public Libro obtenerLibroXid(Long id){
        Optional<Libro> libro = libroRepository.findById(id);
        if(libro.isPresent()){
            return libro.get();
        }else {
            throw new RuntimeException("Libro no encontrado");
        }
    }

    public Libro crearLibro(Libro libro){

        return libroRepository.save(libro);
    }

    public Libro actualizarLibro(Long id, Libro libroActualizado){
        Libro libroExistente=obtenerLibroXid(id);
        libroExistente.setTitulo(libroActualizado.getTitulo());
        libroExistente.setEstado(libroActualizado.getEstado());
        libroExistente.setAutor(libroActualizado.getAutor());

        return libroRepository.save(libroExistente);
    }

    public Libro eliminadoLogicoLibro(Long id){
        Libro libroExistente=obtenerLibroXid(id);
        Integer estadoCero=0;
        libroExistente.setEstado(estadoCero);

        return libroRepository.save(libroExistente);
    }
}
