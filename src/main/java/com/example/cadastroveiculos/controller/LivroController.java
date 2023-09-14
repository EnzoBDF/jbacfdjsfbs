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
    @DeleteMapping("/{placa}")
    public ResponseEntity<String> deletarVeiculo(@PathVariable String placa) {
        try {
            livroRepository.deleteById(placa);
            return ResponseEntity.ok("Veiculo deletado com sucesso.");
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{placa}")
    public ResponseEntity<Livro> atualizarVeiculo(@PathVariable String placa, @RequestBody Livro veiculoAtualizado) {
        if (livroRepository.existsById(placa)) {
            Livro veiculo = livroRepository.findById(placa).get();
            veiculo.setPlaca(veiculoAtualizado.getPlaca());
            veiculo.setCor(veiculoAtualizado.getCor());
            veiculo.setFabricante(veiculoAtualizado.getFabricante());
            veiculo.setModelo(veiculoAtualizado.getModelo());
            veiculo.setCategoria(veiculoAtualizado.getCategoria());
            veiculo.setAno(veiculoAtualizado.getAno());
            Livro veiculoAtualizadoBD = livroRepository.save(veiculo);
            return ResponseEntity.ok(veiculoAtualizadoBD);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
