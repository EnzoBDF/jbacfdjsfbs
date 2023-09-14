package com.example.cadastroveiculos.repository;
import com.example.cadastroveiculos.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}
