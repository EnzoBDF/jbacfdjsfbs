package com.example.cadastroveiculos.controller;
import com.example.cadastroveiculos.model.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import com.example.cadastroveiculos.repository.LivroRepository;
@CrossOrigin(origins = "http://localhost:5173") // Endereço do front
@RestController

@RequestMapping("/veiculos")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;
    @GetMapping
    public List<Livro> listarVeiculos() {
        return livroRepository.findAll();
    }
    @PostMapping
    public Livro criarVeiculo(@RequestBody Livro veiculo) {
        return livroRepository.save(veiculo);
    }
    @DeleteMapping("/{isbn}")
    public ResponseEntity<String> deletarVeiculo(@PathVariable Long isbn) {
        try {
            livroRepository.deleteById(isbn);
            return ResponseEntity.ok("Veiculo deletado com sucesso.");
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{isbn}")
    public ResponseEntity<Livro> atualizarVeiculo(@PathVariable Long isbn, @RequestBody Livro veiculoAtualizado) {
        if (livroRepository.existsById(isbn)) {
            Livro veiculo = livroRepository.findById(isbn).get();
            veiculo.setNome(veiculoAtualizado.getNome());
            veiculo.setCor(veiculoAtualizado.getCor());
            veiculo.setTipo(veiculoAtualizado.getTipo());
            Livro veiculoAtualizadoBD = livroRepository.save(veiculo);
            return ResponseEntity.ok(veiculoAtualizadoBD);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
