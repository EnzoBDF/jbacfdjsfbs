package com.example.cadastroveiculos.controller;
import com.example.cadastroveiculos.model.Genero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import com.example.cadastroveiculos.repository.GeneroRepository;
@CrossOrigin(origins = "http://localhost:5173") // Endereço do front
@RestController

@RequestMapping("/fabricantes")
public class GeneroController {
    @Autowired
    private GeneroRepository generoRepository;
    @GetMapping
    public List<Genero> listarFabricantes() {
        return generoRepository.findAll();
    }
    @PostMapping
    public Genero criarFabricante(@RequestBody Genero fabricante) {
        return generoRepository.save(fabricante);
    }

}
