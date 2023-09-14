package com.example.cadastroveiculos.repository;
import com.example.cadastroveiculos.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
