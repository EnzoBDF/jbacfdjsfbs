package com.example.cadastroveiculos.controller;

import com.example.cadastroveiculos.model.Autor;
import com.example.cadastroveiculos.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "http://localhost:5173") // Endereço do front
@RestController
@RequestMapping("/autores") // Corrigir o caminho para /autores para refletir a funcionalidade de autor

public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping
    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    @PostMapping
    public Autor criarAutor(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }
}