package com.codigo.Practica_Experto_JordyCaichihua.service;


import com.codigo.Practica_Experto_JordyCaichihua.model.Autor;
import com.codigo.Practica_Experto_JordyCaichihua.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> obtenerTodosAutores(){

        return autorRepository.findAll();
    }

    public Autor obtenerAutorXid(Long id){
        Optional<Autor> autor = autorRepository.findById(id);
        if(autor.isPresent()){
            return autor.get();
        }else {
            throw new RuntimeException("Autor no encontrado");
        }
    }

    public Autor crearAutor(Autor autor){

        return autorRepository.save(autor);
    }

    public Autor actualizarAutor(Long id, Autor autorActualizado){
        Autor autorExistente=obtenerAutorXid(id);
        autorExistente.setNombre(autorActualizado.getNombre());
        autorExistente.setEstado(autorActualizado.getEstado());

        return autorRepository.save(autorExistente);
    }

    public Autor eliminadoLogicoAutor(Long id){
        Autor autorExistente=obtenerAutorXid(id);
        Integer estadoCero=0;
        autorExistente.setEstado(estadoCero);

        return autorRepository.save(autorExistente);
    }
}
